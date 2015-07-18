lazy val root = project.in(file(".")).
  aggregate(scannerJS, scannerJVM).
  settings(
    publish := {},
    publishLocal := {}
  )

lazy val scanner = crossProject.in(file(".")).
  settings(
    name := "scalaspace-scanner",
    version := "0.1",
    scalaVersion := "2.11.7",
    libraryDependencies ++= Seq(
      "joda-time" % "joda-time" % "2.8.1",
      "org.joda" % "joda-convert" % "1.7"
    )
  ).
  jvmSettings(
    name := "scalaspace-scanner",
    version := "0.1",
    scalaVersion := "2.11.7",
    libraryDependencies ++= Seq(
      "com.lihaoyi" %% "upickle" % "0.3.4",
      "org.slf4j" % "slf4j-nop" % "1.7.12",
      "net.databinder.dispatch" %% "dispatch-core" % "0.11.2"
    )
  ).
  jsSettings(
    name := "scalaspace-scanner",
    version := "0.1",
    scalaVersion := "2.11.7",
    persistLauncher := true,
    libraryDependencies ++= Seq(
      "be.doeraene" %%% "scalajs-jquery" % "0.8.0",
      "com.lihaoyi" %%% "upickle" % "0.3.4"
    )
  )

lazy val scannerJVM = scanner.jvm
lazy val scannerJS = scanner.js