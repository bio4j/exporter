package com.bio4j.exporter;

import java.util.List;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.gremlin.java.GremlinPipeline;

public class Steps {

	/**
	 * @param g
	 * @param relation
	 * @return
	 */
	public static List geneOntologyAssociationsVertices(Graph g, String relation) {
		List list = null;

		GremlinPipeline pipe = new GremlinPipeline<Vertex, Vertex>(g).V().outE(
				relation);
		list = pipe.toList();
		return list;
	}

	/**
	 * @param g
	 * @param index
	 * @param relation
	 * @return
	 */
	public static List geneOntologyAssociationsVertices(Graph g, int index,
			String relation) {
		List list = null;

		GremlinPipeline pipe = new GremlinPipeline<Vertex, Vertex>(
				g.getVertex(index)).outE(relation);
		list = pipe.toList();
		return list;
	}

	/**
	 * @param g
	 * @param relation
	 * @return
	 */
	public static List geneOntologyAssociationsEdges(Graph g, String relation) {
		List list = null;

		GremlinPipeline pipe = new GremlinPipeline<Vertex, Edge>(g).V().outE(
				relation);
		list = pipe.toList();
		return list;
	}

	/**
	 * @param g
	 * @param index
	 * @param relation
	 * @return
	 */
	public static List geneOntologyAssociationsEdges(Graph g, int index,
			String relation) {
		List list = null;

		GremlinPipeline pipe = new GremlinPipeline<Vertex, Edge>(
				g.getVertex(index)).outE(relation);
		list = pipe.toList();
		return list;
	}
}