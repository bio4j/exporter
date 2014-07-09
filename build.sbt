Nice.javaProject

name := "exporter"

description := "Bio4j Gexf/Graphml/GraphSON exporter"

organization := "bio4j"

bucketSuffix := "era7.com"

javaVersion := "1.8"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq(
  "com.tinkerpop" % "tinkergraph-gremlin" % "3.0.0-SNAPSHOT",
  "commons-cli" % "commons-cli" % "1.2",
  "junit" % "junit" % "4.11"
)


