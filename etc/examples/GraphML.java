package examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.util.io.graphml.GraphMLReader;

// This example reads GraphML data into a graph and prints some of the info contained in the graph
public class GraphML {
	public static void main(String[] args) throws IOException {
		Graph inputGraph = new TinkerGraph();
		File file = new File("etc/examples/example.graphml");
		InputStream graphMLInputStream = new FileInputStream(file);

		GraphMLReader.inputGraph(inputGraph, graphMLInputStream);
		for (Vertex v : inputGraph.getVertices()) {
			Integer age = v.getProperty("age");
			if (age != null) {
				System.out.println("Vertex id: " + v.getId().toString()
						+ " has age: " + age);
			}
		}
	}
}
