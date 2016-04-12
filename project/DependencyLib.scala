import sbt._
import sbt.Keys._
import scala.languageFeature._
import org.scalajs.sbtplugin.ScalaJSPlugin
import ScalaJSPlugin.autoImport._
import org.scalajs.sbtplugin.cross.CrossProject

object DependencyLib {

  sealed trait HasDialect
  sealed trait HasJvm extends HasDialect
  sealed trait HasJs extends HasDialect
  type HasBoth = HasJvm with HasJs

  sealed abstract class Dialect[D <: HasDialect](val name: String)
  case object JVM extends Dialect[HasJvm]("jvm")
  case object JS  extends Dialect[HasJs] ("js")
  type AnyDialect = Dialect[_ <: HasDialect]

  object GlobalMod {
    // This was a little hack I used to apply a modification to ALL dependencies
    // (Usually to exclude a transitive dependency)
    def apply[D <: HasDialect](d: Dep[D]): Dep[D] = d
  }

  case class ModDepScope(scope: String) extends AnyVal {
    def apply[D <: HasDialect](d: Dep[D]): Dep[D] =
      d % scope
  }

  /**
   * Type class witnessing the least upper bound of a pair of types and providing conversions from each to their common
   * supertype.
   *
   * @author Miles Sabin
   */
  trait Lub[-A, -B, Out] extends Serializable {
    def left(a : A): Out
    def right(b : B): Out
  }

  object Lub {
    implicit def lub[T] = new Lub[T, T, T] {
      def left(a : T): T = a
      def right(b : T): T = b
    }
  }

  // -------------------------------------------------------------------------------------------------------------------

  object Dep {
    val empty = new Dep[Nothing](Map.empty)

    def apply[D <: HasDialect](dialect: Dialect[D], m: ModuleID): Dep[D] =
      GlobalMod(new Dep[D](empty.ids.updated(dialect, Seq(m))))
  }

  class Dep[D <: HasDialect] private[Dep](val ids: Map[AnyDialect, Seq[ModuleID]]) extends AnyVal {
    def widen[E >: D <: HasDialect]: Dep[E] =
      new Dep(ids)

    def modAll(f: ModuleID => ModuleID): Dep[D] =
      new Dep(Dep.empty.ids ++ ids.toStream.map(p => (p._1, p._2 map f)))

    private def concat[R <: HasDialect](that: Dep[_ <: HasDialect]): Dep[R] =
      new Dep(that.ids.foldLeft(ids) { case (q, (k, v)) =>
        q.updated(k, q.get(k).fold(v)(_ ++ v))
      })

    def mergeDialects[E <: HasDialect](that: Dep[E]): Dep[D with E] =
      concat[D with E](that)

    def ++[E <: HasDialect, R <: HasDialect](that: Dep[E])(implicit lub: Lub[D, E, R]): Dep[R] =
      concat[R](that)

    def apply(d: AnyDialect): Seq[ModuleID] =
      ids.getOrElse(d, Seq.empty)

    def %(revision: String) = modAll(_ % revision)

    def exclude(org: String, name: String) = modAll(_ exclude(org, name))
  }

  def jvmOnly(m: ModuleID): Dep[HasJvm] =
    Dep(JVM, m)

  def jsOnly(m: ModuleID): Dep[HasJs] =
    Dep(JS, m)

//  def jvmAndJs(group: String, name: String, ver: String): Dep[HasBoth] =
//    Dep(JVM, group %% name % ver) mergeDialects Dep(JS, group %%%! name % ver)

//  def jvmAndJsFork(jvmGroup: String, name: String, ver: String)(jsGroup: String, jsVerSuffix: String = ""): Dep[HasBoth] =
//    Dep(JVM, jvmGroup %% name % ver) mergeDialects Dep(JS, jsGroup %%%! name % (ver + jsVerSuffix))

  /*
  // Test
  val jvm : Dep[HasJvm]  = ???
  val js  : Dep[HasJs]   = ???
  val both: Dep[HasBoth] = ???
  val bb: Dep[HasBoth] = both ++ both
  val bj: Dep[HasJvm]  = jvm  ++ both
  val jb: Dep[HasJvm]  = both ++ jvm
  val jj: Dep[HasJvm]  = jvm ++ jvm
  val fail1 = jvm + js // should fail
  */

  // -------------------------------------------------------------------------------------------------------------------

  def scalaItself(ver: String): MultiModule[HasBoth] =
    new MultiModule[HasBoth](n => {
      val m = "org.scala-lang" % n % ver
      Dep(JVM, m) mergeDialects Dep(JS, m)
    })


  object MultiModule {
    def apply[D <: HasDialect](d: Dialect[D], f: String => ModuleID) =
      new MultiModule[D](n => Dep[D](d, f(n)))

    def java(group: String, ver: String): MultiModule[HasJvm] =
      MultiModule(JVM, group % _ % ver)

    def scala(group: String, ver: String): MultiModule[HasJvm] =
      MultiModule(JVM, group %% _ % ver)

    def js(group: String, ver: String): MultiModule[HasJs] =
      MultiModule(JS, group %%%! _ % ver)

    def jvmAndJs(group: String, ver: String): MultiModule[HasBoth] =
      scala(group, ver) mergeDialects js(group, ver)

    def jvmAndJsFork(jvmGroup: String, ver: String)(jsGroup: String, jsVerSuffix: String = ""): MultiModule[HasBoth] =
      scala(jvmGroup, ver) mergeDialects js(jsGroup, ver + jsVerSuffix)
  }

  class MultiModule[D <: HasDialect](val f: String => Dep[D]) extends AnyVal {
    def apply(name: String) = f(name)

    def mergeDialects[E <: HasDialect](that: MultiModule[E]): MultiModule[D with E] =
      new MultiModule[D with E](name => this(name).mergeDialects[E](that(name)))
  }


  implicit class CrossProjectExt(val p: CrossProject) extends AnyVal {

    def configureBoth(fs: (Project => Project)*): CrossProject =
      fs.foldLeft(p)((q,f) => q.jvmConfigure(f).jsConfigure(f))

    def configureJvm(fs: (Project => Project)*): CrossProject =
      fs.foldLeft(p)((q,f) => q.jvmConfigure(f))

    def configureJs(fs: (Project => Project)*): CrossProject =
      fs.foldLeft(p)((q,f) => q.jsConfigure(f))

    def depsForBoth(deps: Dep[HasBoth]): CrossProject =
      depsForJvm(deps.widen).depsForJs(deps.widen)

    def depsForJvm(deps: Dep[HasJvm]): CrossProject =
      p.jvmSettings(libraryDependencies ++= deps(JVM))

    def depsForJs(deps: Dep[HasJs]): CrossProject =
      p.jsSettings(libraryDependencies ++= deps(JS))

    def aggregateJvm(refs: sbt.ProjectReference*):  CrossProject =
      p.jvmConfigure(_.aggregate(refs: _*))

    def aggregateJs(refs: sbt.ProjectReference*):  CrossProject =
      p.jsConfigure(_.aggregate(refs: _*))
  }

  implicit class ProjectExt(val p: Project) extends AnyVal {
    def deps(deps: Dep[HasJvm]): Project =
      p.settings(libraryDependencies ++= deps(JVM))

    def depsForJs(deps: Dep[HasJs]): Project =
      p.settings(libraryDependencies ++= deps(JS))
  }

  def depScope(s: String): ModDepScope = ModDepScope(s)
  def depScope(c: Configuration): ModDepScope = depScope(c.name)
  def testScope = depScope("test")
  def providedScope = depScope("provided")

}

