import sbt.Project.projectToRef
import Dependencies._
/*
lazy val clients = Seq(examplesClient, reactBootstrap)

lazy val exampleServer = (project in file("examples-server")).settings(
  scalaVersion := Dependencies.Scala.version,
  scalaJSProjects := clients,
  pipelineStages := Seq(scalaJSProd, gzip),
  libraryDependencies ++= Seq(
    "com.vmunier" %% "play-scalajs-scripts" % "0.4.0",
    "org.webjars" %% "webjars-play" % "2.5.0",
    "org.webjars" % "bootstrap" % "3.3.6",
    "org.webjars" % "font-awesome" % "4.5.0",
    "org.webjars" % "react" % "0.14.8",
    "org.webjars" % "jquery" % "1.12.3"
  ))
  .enablePlugins(PlayScala).
  aggregate(clients.map(projectToRef): _*).
  dependsOn(exampleSharedJvm)

lazy val examplesClient = (project in file("examples-client")).
  enablePlugins(ScalaJSPlugin, ScalaJSPlay).settings(
  scalaVersion := Dependencies.Scala.version,
  persistLauncher := true,
  sourceMapsDirectories += exampleSharedJs.base / "..",
  unmanagedSourceDirectories in Compile := Seq((scalaSource in Compile).value),
  libraryDependencies ++= Seq(React.extra.value, ScalaJs.dom.value)).
  dependsOn(exampleSharedJs, reactBootstrap)
*/

lazy val commonJS = (project in file("common")).
  enablePlugins(ScalaJSPlugin).settings(
  scalaVersion := Dependencies.Scala.version,
  libraryDependencies ++= Seq())


lazy val reactBootstrap = (project in file("react-bootstrap")).
  enablePlugins(ScalaJSPlugin).settings(
  scalaVersion := Dependencies.Scala.version,
  libraryDependencies ++= Seq(React.extra.value, ScalaJs.dom.value))
  .dependsOn(commonJS)

/*
lazy val exampleShared = (crossProject.crossType(CrossType.Pure) in file("examples-shared")).
  settings(scalaVersion := Dependencies.Scala.version).
  jsConfigure(_ enablePlugins ScalaJSPlay).
  jsSettings(sourceMapsBase := baseDirectory.value / "..")

lazy val exampleSharedJvm = exampleShared.jvm
lazy val exampleSharedJs = exampleShared.js

// loads the jvm project at sbt startup
onLoad in Global := (Command.process("project exampleServer", _: State)) compose (onLoad in Global).value
*/