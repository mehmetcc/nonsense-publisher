ThisBuild / scalaVersion     := "2.13.16"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

val ZioVersion       = "2.1.14"
val ZioKafkaVersion  = "2.10.0"
val ZioConfigVersion = "4.0.3"

lazy val root = (project in file("."))
  .settings(
    name := "nonsense-producer",
    libraryDependencies ++= Seq(
      "dev.zio"             %% "zio"                 % ZioVersion,
      "dev.zio"             %% "zio-kafka"           % ZioKafkaVersion,
      "dev.zio"             %% "zio-config"          % ZioConfigVersion,
      "dev.zio"             %% "zio-config-typesafe" % ZioConfigVersion,
      "dev.zio"             %% "zio-config-magnolia" % ZioConfigVersion,
      "dev.zio"             %% "zio-json"            % "0.7.4",
      "com.github.javafaker" % "javafaker"           % "1.0.2",
      "org.slf4j"            % "slf4j-simple"        % "2.0.16",
      "dev.zio"             %% "zio-test"            % ZioVersion % Test
    ),
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
  )

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

dockerBaseImage := "eclipse-temurin:19-jdk" // Base Docker image
