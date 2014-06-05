package examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.util.io.graphson.GraphSONReader;
import com.tinkerpop.blueprints.util.io.graphson.GraphSONWriter;

// This example reads GraphSON data into a graph and prints some of the info contained in the graph
public class GraphSON {
	public static void main(String[] args) throws IOException {
		Graph inputGraph = new TinkerGraph();
		File file = new File("etc/examples/example.graphson");
		InputStream GraphSONInputStream = new FileInputStream(file);

		GraphSONReader.inputGraph(inputGraph, GraphSONInputStream);
		for (Vertex v : inputGraph.getVertices()) {
			Integer age = v.getProperty("age");
			if (age != null) {
				System.out.println("Vertex id: " + v.getId().toString()
						+ " has age: " + age);
			}
		}

		// Now try exporting the graph into a different file
		File outputFile = new File("etc/examples/output.graphson");
		FileOutputStream GraphSONOutputStream = new FileOutputStream(outputFile);
		GraphSONWriter.outputGraph(inputGraph, GraphSONOutputStream);
	}
}
