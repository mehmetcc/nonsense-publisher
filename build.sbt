ThisBuild / scalaVersion     := "2.13.15"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

val ZioVersion = "2.1.14"

lazy val root = (project in file("."))
  .settings(
    name := "nonsense-producer",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio"      % ZioVersion,
      "dev.zio" %% "zio-test" % ZioVersion % Test
    ),
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
  )
