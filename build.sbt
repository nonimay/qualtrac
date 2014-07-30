name := "QualTrac"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-slick" % "0.8.0-RC2"
)

lazy val root = (project in file(".")).enablePlugins(PlayScala)
