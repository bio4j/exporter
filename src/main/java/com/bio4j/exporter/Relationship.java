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
