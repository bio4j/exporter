package examples;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;

public class AvgAge {

	static int graphSize(Graph g) {
		int size = 0;
		for (@SuppressWarnings("unused")
		Vertex v : g.getVertices()) {
			size++;
		}
		return size;
	}

	public static void main(String[] args) {
		Graph g = TinkerGraphFactory.createTinkerGraph();
		float total = 0;
		for (Vertex v : g.getVertices()) {
			Integer age = v.getProperty("age");
			if (age != null) {
				total = total + age;
			}
		}
		System.out.println(total / graphSize(g));
	}
}
