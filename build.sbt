import Dependencies._

ThisBuild / scalaVersion     := "2.13.10"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "craigslist-scraper",
    libraryDependencies += munit % Test
  )

libraryDependencies ++= Seq(
  "dev.doamaral" %% "zio-selenium" % "1.0.0"
)