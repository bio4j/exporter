### Usage examples

#### Loading the data

Loading the data graph depends on it's implementation, Tinkerpop3 supports these graph types:
* [TinkerGraph](http://www.tinkerpop.com/docs/3.0.0.M1/#tinkergraph-gremlin)
* [Neo4j](http://www.tinkerpop.com/docs/3.0.0.M1/#neo4j-gremlin)
* [Giraph](http://www.tinkerpop.com/docs/3.0.0.M1/#giraph-gremlin)


#### Bio4j's DSL 

We've created a [DSL](http://www.tinkerpop.com/docs/current/#_domain_specific_languages) that is respective of the semantics of the GeneOntology module. [`GoTraversal`](https://github.com/bio4j/exporter/blob/master/docs/src/main/java/com/bio4j/exporter/GoTraversal.java.md) extends `Traversal`, it can now be used as follows:

```java
gremlin> g.traversal(GoTraversal.class).goTerms()
``` 

It iterates over all the GoTerms in a Gene Ontology graph `g`.

`GoTraversal` provides [other methods]((https://github.com/bio4j/exporter/blob/master/docs/src/main/java/com/bio4j/exporter/GoTraversal.java.md)):
- ``goTerms()``
- ``goTerm(int)``
- ``in(Relationship)``
- ``in()``
- ``inE()``
- ``inE(Relationship)``
- ``out(Relationship)``
- ``out()``
- ``outE()``
- ``outE(Relationship)``
- ``id()``
- ``synonyms()``
- ``name()``
- ``definition()``
- ``comment()``

For more info about the DSL, see the [Bio4j DSL](bio4j-dsl.md) section.


#### The `:bio4j` command

For example

* Save to `/home/andre/bio4j.json`:

    ```java
    gremlin> :bio4j graphson /home/andre g.traversal(GoTraversal.class).goTerms()
    ```

* Save to `bio4j.json` in the current folder:

    ```java
    gremlin> :bio4j graphson g.traversal(GoTraversal.class).goTerms()
    ```

* Save to `/home/andre/out.json`:

    ```java
    gremlin> :bio4j graphson /home/andre/out.json g.traversal(GoTraversal.class).goTerms()
    ```

Generalizing:

`gremlin> :bio4j format path query` or simply `gremlin> :bio4j format query` to save to current location.

On the possible export formats, see the [Supported formats](formats-supported.md) section.
