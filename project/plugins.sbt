// Comment to get more information during initialization
logLevel := Level.Warn

// Resolvers
resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"

// Sbt plugins
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.1")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.8")

addSbtPlugin("com.vmunier" % "sbt-play-scalajs" % "0.2.3")

addSbtPlugin("com.typesafe.sbt" % "sbt-gzip" % "1.0.0")

//libraryDependencies += "org.scala-js" %% "scalajs-env-selenium" % "0.1.1"

//libraryDependencies += "org.scala-js" %% "scalajs-tools" % "0.6.8"
