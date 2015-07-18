name := "scalaspace-scanner"

version := "0.1"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-nop" % "1.7.12",
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.2",
  "com.lihaoyi" %% "upickle" % "0.3.4",
  "joda-time" % "joda-time" % "2.8.1",
  "org.joda" % "joda-convert" % "1.7"
)
