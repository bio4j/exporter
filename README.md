## Bio4j Gexf/Graphml/GraphSON exporter

Plugin for the [Tinkerpop3's Gremlin Console](https://github.com/tinkerpop/tinkerpop3). 

It provides [Traversal Steps](http://www.tinkerpop.com/docs/current/#_the_traversal_api) implemented in Bio4j's Domain Specific Language and it also provides the ``:bio4j`` command. 

``:bio4j`` allows you to export queries expressed in [Gremlin Graph Querying Language](https://github.com/thinkaurelius/titan/wiki/Gremlin-Query-Language) or in [Bio4j's DSL]() to GraphSON, GraphML and GEXF. 

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
