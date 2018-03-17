import sbt._
import scala.languageFeature._
import org.scalajs.sbtplugin.ScalaJSPlugin
import ScalaJSPlugin.autoImport._
import org.scalajs.sbtplugin.cross.CrossProject

object Dependencies {

  object Scala {
    lazy val version  = "2.12.4"
    val compiler = "org.scala-lang" %% "scala-compiler"  % version
    val library  = "org.scala-lang" %% "scala-library"  % version
    val reflect  = "org.scala-lang" %% "scala-reflect" % version
    val macroDef = Seq(reflect, compiler % "provided")
  }

  // JVM dependency family with JS fork
  object Scalaz {
    lazy val version  = "7.2.1"
    val core       =  Def.setting("org.scalaz"%%%"scalaz-core" % version)
    val effect     =  Def.setting("org.scalaz"%%%"scalaz-effect" % version)
    val concurrent =  Def.setting("org.scalaz"%%%"scalaz-concurrent" % version)
  }

  // JS-only dependency family
  object React {
    lazy val version  = "1.2.0"
    val core    =  Def.setting("com.github.japgolly.scalajs-react" %%% "core" % version)
    val test    =  Def.setting("com.github.japgolly.scalajs-react" %%%"test" % version)
    val scalaz  = Seq(Def.setting("com.github.japgolly.scalajs-react" %%% "ext-scalaz72"% version),  Scalaz.effect)
    //val monocle = mm("ext-monocle") ++ Monocle.core
    val extra   =  Def.setting("com.github.japgolly.scalajs-react" %%%"extra" % version)
    val most    = Seq(core, extra) ++ scalaz 
  }

  // JS-only dependency family
  object ScalaJs {
    val dom= Def.setting("org.scala-js" %%% "scalajs-dom" % "0.9.5")
  }

  // JVM & JS cross-compiled dependencies
  val boopickle =  Def.setting("me.chrons" %%% "boopickle" % "1.1.3")
  val μTest     =  Def.setting("com.lihaoyi" %%% "utest" % "0.4.3") 

  // JVM-only dependencies
  val jodaTime    = Seq("joda-time"                   % "joda-time"             % "2.9.3", 
    "org.joda"                    % "joda-convert"          % "1.8.1")
}
