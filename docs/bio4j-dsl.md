### Bio4j DSL

#### GeneOntology Module

[GoTraversal class](https://github.com/bio4j/exporter/blob/master/docs/src/main/java/com/bio4j/exporter/GoTraversal.java.md) implements Bio4j Domain Specific Language for the Gene Ontology module. 
This DSL is respective of the semantics of the data, instead of querying in terms of vertices/edges/properties, users can query in terms of GoTerms and their properties.

##### Vertices and their properties in GO Module

*   ``GoTerm``
    * id
    * name
    * synonyms
    * definition
    * comment
*   ``GoSlims``
*   ``SubOntologies``

##### Relationships in GO Module

The [Relationship.java enum](https://github.com/bio4j/exporter/blob/master/docs/src/main/java/com/bio4j/exporter/Relationship.java.md) provides the abstraction for the use of GO Relationships in the user queries.

Supported relations:
- `IS_A` — [node A is a _subtype of_ node B](http://geneontology.org/page/ontology-relations#isa)
- `PART_OF` — [B is _necessarily part of_ A](http://geneontology.org/page/ontology-relations#partof)
*   ``HAS_PART_OF`` — [A _necessarily has part_ B](http://geneontology.org/page/ontology-relations#haspart)
*   ``REGULATES`` — [C _always regulates_ D](http://geneontology.org/page/ontology-relations##reg)
*   ``POSITIVELY_REGULATES`` 
*   ``NEGATIVELY_REGULATES`` 
*   ``SUB_ONTOLOGY``  
*   ``GO_SLIM`` 

##### Examples 


```java
g.of(GoTraversal.class).GoTerms(Relationship.IS_A)
```

This query traverses all the GoTerms that share the IS_A relationship in the graph `g`.


```java
g.of(GoTraversal.class).GoTerm(2).out()
```

This query traverses all the outbound vertices(GoTerms) reachable from the second vertex of the graph `g`.

You can then export the results of these queries using the [`:bio4j` command](usage-examples.md).
