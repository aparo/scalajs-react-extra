import sbt.Project.projectToRef

lazy val clients = Seq(examplesClient, reactBootstrap)
lazy val scalaV = "2.11.5"

lazy val exampleServer = (project in file("examples-server")).settings(
  scalaVersion := scalaV,
  scalaJSProjects := clients,
  pipelineStages := Seq(scalaJSProd, gzip),
  libraryDependencies ++= Seq(
    "com.vmunier" %% "play-scalajs-scripts" % "0.1.0",
    "org.webjars" %% "webjars-play" % "2.3.0",
    "org.webjars" % "bootstrap" % "3.3.2-1",
    "org.webjars" % "font-awesome" % "4.3.0-1",
    "org.webjars" % "react" % "0.12.1",
    "org.webjars" % "jquery" % "1.11.1"
  ),
  EclipseKeys.skipParents in ThisBuild := false).
  enablePlugins(PlayScala).
  aggregate(clients.map(projectToRef): _*).
  dependsOn(exampleSharedJvm)

lazy val examplesClient = (project in file("examples-client")).
  enablePlugins(ScalaJSPlugin, ScalaJSPlay).settings(
  scalaVersion := scalaV,
  persistLauncher := true,
  persistLauncher in Test := false,
  sourceMapsDirectories += exampleSharedJs.base / "..",
  unmanagedSourceDirectories in Compile := Seq((scalaSource in Compile).value),
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.8.0",
    "com.github.japgolly.scalajs-react" %%% "extra" % "0.8.0"
  )).
  dependsOn(exampleSharedJs, reactBootstrap)

lazy val reactBootstrap = (project in file("react-bootstrap")).
  enablePlugins(ScalaJSPlugin, ScalaJSPlay).settings(
  scalaVersion := scalaV,
  persistLauncher := false,
  persistLauncher in Test := false,
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.8.0",
    "com.github.japgolly.scalajs-react" %%% "extra" % "0.8.0"
  ))

lazy val exampleShared = (crossProject.crossType(CrossType.Pure) in file("examples-shared")).
  settings(scalaVersion := scalaV).
  jsConfigure(_ enablePlugins ScalaJSPlay).
  jsSettings(sourceMapsBase := baseDirectory.value / "..")

lazy val exampleSharedJvm = exampleShared.jvm
lazy val exampleSharedJs = exampleShared.js

// loads the jvm project at sbt startup
onLoad in Global := (Command.process("project exampleServer", _: State)) compose (onLoad in Global).value
