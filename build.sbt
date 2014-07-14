Nice.javaProject

name := "exporter"

description := "Bio4j Gexf/Graphml/GraphSON exporter"

organization := "bio4j"

bucketSuffix := "era7.com"

javaVersion := "1.8"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq(
  "com.tinkerpop" % "tinkerpop" % "3.0.0-SNAPSHOT",
  "com.tinkerpop" % "gremlin-core" % "3.0.0-SNAPSHOT",
  "com.tinkerpop" % "gremlin-groovy" % "3.0.0-SNAPSHOT",
  "com.tinkerpop" % "gremlin-test" % "3.0.0-SNAPSHOT",  
  "junit" % "junit" % "4.11"
)

