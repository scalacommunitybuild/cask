scalaVersion := "2.13.4"
organization := "com.lihaoyi"
name := "cask"

libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
libraryDependencies += "io.undertow" % "undertow-core" % "2.0.13.Final"
libraryDependencies += "org.java-websocket" % "Java-WebSocket" % "1.4.0"

libraryDependencies += "com.lihaoyi" %% "geny" % "0.6.2"
libraryDependencies += "com.lihaoyi" %% "upickle" % "1.2.0"
libraryDependencies += "com.lihaoyi" %% "castor" % "0.1.7"
libraryDependencies += "com.lihaoyi" %% "pprint" % "0.6.0"

testFrameworks := Seq(new TestFramework("utest.runner.Framework"))
libraryDependencies += "com.lihaoyi" %% "utest" % "0.7.4" % Test
libraryDependencies += "com.lihaoyi" %% "requests" % "0.6.5" % Test

Compile / unmanagedSourceDirectories += baseDirectory.value / "cask" / "src"
Compile / unmanagedSourceDirectories += baseDirectory.value / "cask" / "src-2"
Compile / unmanagedSourceDirectories += baseDirectory.value / "cask" / "util" / "src"
Compile / unmanagedSourceDirectories += baseDirectory.value / "cask" / "util" / "src-jvm"
Test / unmanagedSourceDirectories += baseDirectory.value / "cask" / "test" / "src"
Compile / scalacOptions ++= Seq("-feature", "-deprecation")
