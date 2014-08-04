
```java
package com.bio4j.exporter;


/**
* @author <a href="mailto:andre.garcia.nunes@gmail.com"> André Nunes </a>
*
* ### GO Relationships
* 
* See [GO Ontology Relations](http://www.geneontology.org/GO.ontology.relations.shtml). They are obviously modeled as edges. We have
* 	- is a
* 	- part of
* 	- has part of
* 	- regulates
* 		- negatively regulates
*	  	- positively regulates
*
*  This enum provides an abstraction for the use of GO Relationships in the user queries, example:
*  ``:bio4j graphml g.Traversal(GoTraversal.class).GoTerms(Relationship.REGULATES)``
*  ExporterCore will translate ``Relationship.REGULATES`` to ``com.bio4j.titan.model.go.relationships.TitanPositivelyRegulates.TitanRegulatesType``
*  	
**/
public enum Relationship {
	IS_A,
	PART_OF,
	HAS_PART_OF,
	REGULATES,
	POSITIVELY_REGULATES,
	NEGATIVELY_REGULATES,
	SUB_ONTOLOGY,
	GO_SLIM
}

```


------

### Index

+ src
  + main
    + resources
      + META-INF
        + services
    + java
      + com
        + bio4j
          + exporter
            + [Bio4jCommand.java][main/java/com/bio4j/exporter/Bio4jCommand.java]
            + [Bio4jGremlinPlugin.java][main/java/com/bio4j/exporter/Bio4jGremlinPlugin.java]
            + [ExporterCore.java][main/java/com/bio4j/exporter/ExporterCore.java]
            + [Relationship.java][main/java/com/bio4j/exporter/Relationship.java]
            + [GoTraversal.java][main/java/com/bio4j/exporter/GoTraversal.java]
  + test
    + java
      + com
        + bio4j
          + exporter
            + test
              + [AllTests.java][test/java/com/bio4j/exporter/test/AllTests.java]
              + [ExporterCoreTest.java][test/java/com/bio4j/exporter/test/ExporterCoreTest.java]

[main/java/com/bio4j/exporter/Bio4jCommand.java]: Bio4jCommand.java.md
[main/java/com/bio4j/exporter/Bio4jGremlinPlugin.java]: Bio4jGremlinPlugin.java.md
[main/java/com/bio4j/exporter/ExporterCore.java]: ExporterCore.java.md
[main/java/com/bio4j/exporter/Relationship.java]: Relationship.java.md
[main/java/com/bio4j/exporter/GoTraversal.java]: GoTraversal.java.md
[test/java/com/bio4j/exporter/test/AllTests.java]: ../../../../../test/java/com/bio4j/exporter/test/AllTests.java.md
[test/java/com/bio4j/exporter/test/ExporterCoreTest.java]: ../../../../../test/java/com/bio4j/exporter/test/ExporterCoreTest.java.md