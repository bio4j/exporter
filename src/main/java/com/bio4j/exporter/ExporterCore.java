package com.bio4j.exporter;


enum Relationship
{
   IS_A,
   PART_OF,
   HAS_PART_OF,
   REGULATES,
   POSITIVELY_REGULATES,
   NEGATIVELY_REGULATES,
   SUB_ONTOLOGY,
   GO_SLIM
}

//holds business logic behind the exporter
public class ExporterCore {
	
	public static String returnRelString(Relationship rel){
		switch(rel){
			case IS_A:
				return "com.bio4j.titan.model.go.relationships.TitanIsA.TitanIsAType";
			case PART_OF:
				return "com.bio4j.titan.model.go.relationships.TitanPartOf.TitanPartOfType";
			case HAS_PART_OF:
				return "com.bio4j.titan.model.go.relationships.TitanHasPartOf.TitanHasPartOfType";
			case REGULATES:
				return "com.bio4j.titan.model.go.relationships.TitanPositivelyRegulates.TitanRegulatesType";
			case POSITIVELY_REGULATES:
				return "com.bio4j.titan.model.go.relationships.TitanPositivelyRegulates.TitanPositivelyRegulatesType";
			case NEGATIVELY_REGULATES:
				return "com.bio4j.titan.model.go.relationships.TitanNegativelyRegulates.TitanNegativelyRegulatesType";
			case SUB_ONTOLOGY:
				return "com.bio4j.titan.model.go.relationships.TitanSubOntology.TitanSubOntologyType";
			case GO_SLIM:
				return "com.bio4j.titan.model.go.relationships.TitanGoSlim.TitanGoSlimType";
			default:
				return null;
		}		
	} 
}

