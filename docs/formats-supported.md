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
