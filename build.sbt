ThisBuild / scalaVersion     := "2.13.16"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

val ZioVersion      = "2.1.14"
val ZioKafkaVersion = "2.10.0"

lazy val root = (project in file("."))
  .settings(
    name := "nonsense-producer",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio"       % ZioVersion,
      "dev.zio" %% "zio-kafka" % ZioKafkaVersion,
      "dev.zio" %% "zio-test"  % ZioVersion % Test
    ),
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
  )
