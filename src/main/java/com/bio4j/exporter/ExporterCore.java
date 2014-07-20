package com.bio4j.exporter;

import groovy.lang.Binding;

import java.io.FileOutputStream;
import java.io.IOException;

import org.codehaus.groovy.tools.shell.Groovysh;
import org.codehaus.groovy.tools.shell.IO;

import com.tinkerpop.gremlin.process.Traversal;
import com.tinkerpop.gremlin.structure.Vertex;
import com.tinkerpop.gremlin.structure.io.graphson.GraphSONWriter;


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
		}
		throw new IllegalArgumentException("Unknown relationship: " + rel);
	} 
	
	public static void exportGraphson(Groovysh shell, Binding binding, IO io, String query) throws IOException {
		// Export query to graphSON
		assert binding != null;
		FileOutputStream f = new FileOutputStream("bio4j.json");
		GraphSONWriter w = GraphSONWriter.create().build();
		shell.execute("t = " + query + ";null");
		w.writeVertices(f, (Traversal<?, Vertex>) binding.getVariable("t"));
		io.out.println("==> exported to bio4j.json");
		f.close();		
	}
	
	public static void exportGraphml(Groovysh shell, Binding binding, IO io, String query) {
		// TODO Auto-generated method stub
		
	}
	
	public static void exportGexf(Groovysh shell, Binding binding, IO io, String query) {
		// TODO Auto-generated method stub
		
	}
}

