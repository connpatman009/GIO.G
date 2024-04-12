lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  //.enablePlugins(PlayNettyServer).disablePlugins(PlayAkkaHttpServer) // uncomment to use the Netty backend
  .settings(
    name := """play-scala-starter-example""",
    organization := "edu.pitt.cs.db",
    version := "1.0-SNAPSHOT",
    crossScalaVersions := Seq("2.13.13", "3.3.3"),
    scalaVersion := crossScalaVersions.value.head,
    libraryDependencies ++= Seq(
      guice,
      "com.h2database" % "h2" % "2.2.224",
      "org.scalatestplus.play" %% "scalatestplus-play" % "6.0.1" % Test,
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-Werror"
    ),
    unmanagedBase := baseDirectory.value / "lib",
    unmanagedJars := (baseDirectory.value ** "*.jar").classpath,
    dependencyOverrides ++= Seq(
      "com.fasterxml.jackson.core" % "jackson-annotations" % "2.14.2",
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.14.2",
      "com.fasterxml.jackson.core" % "jackson-core" % "2.14.2",
      "com.fasterxml.jackson.dataformat" % "jackson-dataformat-cbor" % "2.14.2",
      "com.fasterxml.jackson.datatype" % "jackson-datatype-jdk8" % "2.14.2",
      "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % "2.14.2",
      "com.fasterxml.jackson.module" % "jackson-module-parameter-names" % "2.14.2",
      "com.fasterxml.jackson.module" % "jackson-module-scala_2.13" % "2.14.2",
      "com.fasterxml.jackson.databind" % "jackson-databind" % "2.14.2",
    ),
    // Needed for ssl-config to create self signed certificated under Java 17
    Test / javaOptions ++= List("--add-exports=java.base/sun.security.x509=ALL-UNNAMED"),
  )
