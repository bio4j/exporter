Nice.javaProject

name := "exporter"

description := "Bio4j Gexf/Graphml/GraphSON exporter"

organization := "bio4j"

bucketSuffix := "era7.com"

javaVersion := "1.8"

libraryDependencies ++= Seq(
  "com.thinkaurelius.titan" % "titan-all" % "0.4.4",
  "commons-cli" % "commons-cli" % "1.2" exclude("org.slf4j", "slf4j-log4j12"),
  "junit" % "junit" % "4.11"
)

dependencyOverrides ++= Set(
  "com.tinkerpop.blueprints" % "blueprints-core" % "2.5.0",
  "com.tinkerpop.gremlin" % "gremlin-java" % "2.5.0",
  "com.tinkerpop.gremlin" % "gremlin-groovy" % "2.5.0",
  "tomcat" % "jasper-compiler" % "5.5.23",
  "tomcat" % "jasper-runtime" % "5.5.23"
) 
