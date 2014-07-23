package com.bio4j.exporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.codehaus.groovy.tools.shell.Groovysh;
import org.codehaus.groovy.tools.shell.IO;

import com.tinkerpop.gremlin.process.Traversal;
import com.tinkerpop.gremlin.structure.Edge;
import com.tinkerpop.gremlin.structure.Graph;
import com.tinkerpop.gremlin.structure.Vertex;
import com.tinkerpop.gremlin.structure.io.graphml.GraphMLWriter;
import com.tinkerpop.gremlin.structure.io.graphson.GraphSONWriter;
import com.tinkerpop.gremlin.tinkergraph.structure.TinkerFactory;
import com.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;
import com.tinkerpop.gremlin.util.function.SPredicate;

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

	private static final String DEFAULT_JSON_NAME = "bio4j.json";
	private static final String DEFAULT_XML_NAME = "bio4j.xml";

	public static void exportGraphson(Groovysh shell, IO io, String query, String path) throws IOException {
		// Export query to graphSON
		FileOutputStream f;
		path = resolvePath(path, DEFAULT_JSON_NAME);
		File file = new File(path);
		f = new FileOutputStream(file);
		GraphSONWriter w = GraphSONWriter.create().build();
		shell.execute("t = " + query + ";null");
		Traversal<?, Vertex> traversal = (Traversal<?, Vertex>) shell.getInterp().getContext().getProperty("t");
		w.writeVertices(f, traversal);
		io.out.println("==> exported to " + path);
		f.close();		
	}	

	public static void exportGraphml(Groovysh shell, IO io, String graphName, String path) throws IOException {
		// Export graph to graphML
		FileOutputStream f;
		path = resolvePath(path, DEFAULT_XML_NAME);
		File file = new File(path);
		f = new FileOutputStream(file);
		GraphMLWriter w = GraphMLWriter.create().build();
		Graph graph = (Graph) shell.getInterp().getContext().getProperty(graphName);
		w.writeGraph(f, graph);
		io.out.println("==> exported to " + path);
		f.close();	
	}

	public static void exportGexf(Groovysh shell, IO io, String query, String path) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param path
	 * @return
	 */
	private static String resolvePath(String path, String defaultFileName) {
		if(path == null){
			//default path
			path = defaultFileName;
		} else if (path.endsWith(".json") || (path.endsWith(".xml"))) {
			return path;
		} else if (path.endsWith("/")){
			path = path + defaultFileName;
		} else {
			path = path + "/" + defaultFileName;
		}
		return path;
	}

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
}

