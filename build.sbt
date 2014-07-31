name := "QualTrac"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.0" % "test",
  "com.typesafe.play" %% "play-slick" % "0.8.0-RC2"
)

lazy val root = (project in file(".")).enablePlugins(PlayScala)
