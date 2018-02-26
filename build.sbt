name := "Total_Scala_with_sbt"

version := "0.1"

scalaVersion := "2.12.4"


//libraryDependencies +=  "org.scalaj" %% "scalaj-http" % "2.3.0"     單一套件引用，可以這樣表示。

libraryDependencies ++= Seq(
  "org.scalaj" %% "scalaj-http" % "2.3.0",
  "org.jsoup" % "jsoup" % "1.11.2",
  "com.typesafe.play" %% "play-json" % "2.6.7"
)