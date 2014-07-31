import AssemblyKeys._

Nice.javaProject

fatArtifactSettings

name := "exporter"

description := "Bio4j Gexf/Graphml/GraphSON exporter"

organization := "bio4j"

bucketSuffix := "era7.com"

javaVersion := "1.8"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq(
  ("com.tinkerpop" % "tinkerpop" % "3.0.0-SNAPSHOT"),
  ("com.tinkerpop" % "gremlin-core" % "3.0.0-SNAPSHOT").
    exclude("com.esotericsoftware.minlog", "minlog").
    exclude("org.objenesis", "objenesis"),
  ("com.tinkerpop" % "gremlin-groovy" % "3.0.0-SNAPSHOT"),
  ("com.tinkerpop" % "gremlin-console" % "3.0.0-SNAPSHOT").
    exclude("commons-logging", "commons-logging").
    exclude("commons-collections", "commons-collections"),  
  ("com.tinkerpop" % "gremlin-test" % "3.0.0-SNAPSHOT").
    exclude("org.hamcrest", "hamcrest-core"),
  ("junit" % "junit" % "4.11").
    exclude("org.hamcrest", "hamcrest-core").
    exclude("org.objenesis", "objenesis"),
  ("com.novocode" % "junit-interface" % "0.10" % "test")
)


