import AssemblyKeys._

Nice.javaProject

fatArtifactSettings

name := "exporter"

description := "Bio4j Gexf/Graphml/GraphSON exporter"

organization := "bio4j"

bucketSuffix := "era7.com"

javaVersion := "1.8"

libraryDependencies ++= Seq(
  ("com.tinkerpop" % "tinkerpop" % "3.0.0.M1"),
  ("com.tinkerpop" % "gremlin-core" % "3.0.0.M1"),
  ("com.tinkerpop" % "gremlin-groovy" % "3.0.0.M1"),
  ("com.tinkerpop" % "gremlin-console" % "3.0.0.M1"),
  ("com.tinkerpop" % "gremlin-test" % "3.0.0.M1"),
  ("junit" % "junit" % "4.11"),
  ("com.novocode" % "junit-interface" % "0.10" % "test")
)

dependencyOverrides ++= Set(
  "org.hamcrest" % "hamcrest-core" % "1.3"
) 
