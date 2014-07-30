## Bio4j Graphml/GraphSON exporter

Plugin for the [Tinkerpop3's Gremlin Console](https://github.com/tinkerpop/tinkerpop3). 

It provides [Traversal Steps](http://www.tinkerpop.com/docs/current/#_the_traversal_api) implemented in Bio4j's Domain Specific Language and it also provides the ``:bio4j`` command. 

``:bio4j`` allows you to export queries expressed in [Gremlin Graph Querying Language](https://github.com/thinkaurelius/titan/wiki/Gremlin-Query-Language) or in [Bio4j's DSL]() to GraphSON, GraphML. 

## Documentation

#### Building and loading the Plugin

* Clone or download the exporter.

* ``sbt assembly`` This will generate a jar with the plugin and all it's dependencies.

* After generating it you need to copy the jar to the ``/lib/`` folder on the Gremlin Console path and start it. 

The plugin should show its name as one of the ones that was loaded at startup:
```
         \,,,/
         (o o)
-----oOOo-(3)-oOOo-----
plugin loaded: bio4j
gremlin>
```

You can now start using the plugin.

#### Usage examples
##### Bio4j's DSL 
By extending ``Traversal``, we've created a [DSL](http://www.tinkerpop.com/docs/current/#_domain_specific_languages) that is respective of the semantics of the GeneOntology module. ``GoTraversal`` extends ``Traversal``, this traversal definition can now be used as follows:

``gremlin> g.traversal(GoTraversal.class).goTerms()`` Iterates all the GoTerms in a Gene Ontology Graph ``g``.

``GoTraversal`` provides [other methods]().

##### :bio4j command
``gremlin> :bio4j graphson /home/andre g.traversal(GoTraversal.class).goTerms()``
saves to ``/home/andre/bio4j.json``

``gremlin> :bio4j graphson g.traversal(GoTraversal.class).goTerms()``
saves to ``bio4j.json`` in the current folder 

``gremlin> :bio4j graphson /home/andre/out.json g.traversal(GoTraversal.class).goTerms()``
saves to ``/home/andre/out.json``

Generalizing:
``gremlin> :bio4j format path query`` or simply ``gremlin> :bio4j format query`` to save to current location.

#### Formats supported
At the moment the plugin supports [GraphSON](https://github.com/thinkaurelius/faunus/wiki/GraphSON-Format) and [GraphML](http://graphml.graphdrawing.org/). Due to their different implementations, the exporting possibilities vary:

##### GraphSON
GraphSON is a [JSON](http://json.org/) based graph format developed by [TinkerPop](http://www.tinkerpop.com/) with readers and writers provided by Blueprints.

Our plugin is able to export queries (Traversals) that iterate Vertices or Edges, for example: 

``gremlin> :bio4j graphson /home/andre g.traversal(GoTraversal.class).goTerms()``

Will export all the GoTerms(Vertices) in the ``g`` graph to GraphSON.

##### GraphML
 GraphML is a comprehensive and easy-to-use file format for graphs. It consists of a language core to describe the structural properties of a graph and a flexible extension mechanism to add application-specific data.
 As GraphML is a specification for the serialization of an entire graph and not the individual elements of a graph, methods that support input and output of single vertices and edges are not supported by Tinkerpop. Therefore we are only able to export whole graphs at this point.

 Exporting a graph to GraphML using the plugin goes like this:
 
``gremlin> :bio4j graphml path graphName`` where ``graphName`` is the variable that holds the graph you want to export. This can be any graph, you can create subgraphs of other graphs using TinkerPop's [subgraph step](http://www.tinkerpop.com/docs/current/#subgraph-step) and then export the resulting subgraph. 
