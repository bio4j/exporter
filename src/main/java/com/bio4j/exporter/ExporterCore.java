package com.bio4j.exporter;

import groovy.lang.Binding;

import java.io.File;
import java.io.FileNotFoundException;
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
	
	private static final String DEFAULT_FILE_NAME = "bio4j.json";

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
	
	public static void exportGraphson(Groovysh shell, IO io, String query, String path) throws IOException {
		// Export query to graphSON
		FileOutputStream f;
		path = resolvePath(path);
		File file = new File(path);
		f = new FileOutputStream(file);
		GraphSONWriter w = GraphSONWriter.create().build();
		shell.execute("t = " + query + ";null");
		Traversal<?, Vertex> traversal = (Traversal<?, Vertex>) shell.getInterp().getContext().getProperty("t");
		w.writeVertices(f, traversal);
		io.out.println("==> exported to " + path);
		f.close();		
	}

	/**
	 * @param path
	 * @return
	 */
	private static String resolvePath(String path) {
		if(path == null){
			//default path
			path = DEFAULT_FILE_NAME;
		} else if (path.endsWith(".json")) {
			return path;
		} else if (path.endsWith("/")){
			path = path + DEFAULT_FILE_NAME;
		} else {
			path = path + "/" + DEFAULT_FILE_NAME;
		}
		return path;
	}
	
	public static void exportGraphml(Groovysh shell, IO io, String query, String path) {
		// TODO Auto-generated method stub
		
	}
	
	public static void exportGexf(Groovysh shell, IO io, String query, String path) {
		// TODO Auto-generated method stub
		
	}
}

