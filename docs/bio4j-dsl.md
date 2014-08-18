### Bio4j DSL

#### GeneOntology Module

[GoTraversal class](https://github.com/bio4j/exporter/blob/master/docs/src/main/java/com/bio4j/exporter/GoTraversal.java.md) implements Bio4j Domain Specific Language for the Gene Ontology module. 
This DSL is respective of the semantics of the data, instead of querying in terms of vertices/edges/properties, users can query in terms of GoTerms and their properties.

<!-- TODO: if you mention relationships, let's mention also vertex types and their properties -->

##### Relationships in GO Module

The [Relationship.java enum](https://github.com/bio4j/exporter/blob/master/docs/src/main/java/com/bio4j/exporter/Relationship.java.md) provides the abstraction for the use of GO Relationships in the user queries.

<!-- TODO: link to the source is good, but there is no any comments about the relationships there; so better just to list them here with some _short_ coments -->

##### Examples 


```java
g.Traversal(GoTraversal.class).GoTerms(Relationship.IS_A)
```

This query traverses all the GoTerms that share the IS_A relationship in the graph `g`.


```java
g.Traversal(GoTraversal.class).GoTerm(2).out()
```

This query traverses all the outbound vertices(GoTerms) reachable from the second vertice of the graph `g`.

You can then export the results of these queries using the [`:bio4j` command](usage-examples.md).
