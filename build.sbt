name := "algebra"

version := "0.1.0"

organization := "org.conbere"

licenses := Seq("BSD-style" -> url("http://www.opensource.org/licenses/bsd-license.php"))

homepage := Some(url("http://github.com/aconbere/scala-algebra"))

scalaVersion := "2.10.0"

scalacOptions ++= Seq(
  "-deprecation",
  "-feature"
)

fork in run := true

testOptions in Test += Tests.Argument("-oDF")

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test"
, "junit" % "junit" % "4.10" % "test"
, "org.apache.logging.log4j" % "log4j-core" % "2.0-beta3"
, "com.typesafe" %% "scalalogging-log4j" % "1.0.1"
)
