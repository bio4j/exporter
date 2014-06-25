Nice.javaProject

name := "exporter"

description := "Bio4j Gexf/Graphml/GraphSON exporter"

organization := "bio4j"

bucketSuffix := "era7.com"

javaVersion := "1.8"

libraryDependencies ++= Seq(
  "com.thinkaurelius.titan" % "titan-all" % "0.4.0",
  "com.thinkaurelius.titan" % "titan-cassandra" % "0.4.0" exclude("com.thinkaurelius.titan", "titan-all"),
  "com.thinkaurelius.titan" % "titan-berkeleyje" % "0.4.0" exclude("com.thinkaurelius.titan", "titan-all") , 
  "commons-cli" % "commons-cli" % "1.2",
  "junit" % "junit" % "4.11"
)

dependencyOverrides ++= Set(
  "com.tinkerpop.blueprints" % "blueprints-core" % "2.5.0",
  "com.tinkerpop.gremlin" % "gremlin-java" % "2.5.0",
  "com.tinkerpop.gremlin" % "gremlin-groovy" % "2.5.0",
  "tomcat" % "jasper-compiler" % "5.5.23",
  "tomcat" % "jasper-runtime" % "5.5.23"
) 
