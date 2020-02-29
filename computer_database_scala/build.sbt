name := "computer-database-scala"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.8"

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
  specs2 % Test,
  "com.typesafe.slick" %% "slick" % "3.0.0",
  "com.typesafe" % "config" % "1.3.1",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "org.webjars" % "jquery" % "2.1.4",
  "org.postgresql" % "postgresql" % "9.4-1204-jdbc42",
  "org.webjars" % "bootstrap" % "3.3.5"
)

lazy val root = (project in file(".")).enablePlugins(PlayScala)

routesGenerator := InjectedRoutesGenerator