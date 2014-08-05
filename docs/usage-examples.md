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
