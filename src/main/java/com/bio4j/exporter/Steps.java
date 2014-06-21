package com.bio4j.exporter;

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
	public static GremlinPipeline<Vertex, Vertex> geneOntologyRelatedVertices(
			Graph g, String relation) {
		return new GremlinPipeline<Vertex, Vertex>(g).V().out(relation);
	}

	/**
	 * @param g
	 * @param index
	 * @param relation
	 * @return
	 */
	public static GremlinPipeline<Vertex, Vertex> geneOntologyVertexRelatedVertices(
			Graph g, int index, String relation) {
		return new GremlinPipeline<Vertex, Vertex>(g.getVertex(index))
				.out(relation);
	}

	/**
	 * @param g
	 * @param relation
	 * @return
	 */
	public static GremlinPipeline<Vertex, Edge> geneOntologyRelatedEdges(
			Graph g, String relation) {
		return new GremlinPipeline<Vertex, Edge>(g).V().outE(relation);
	}

	/**
	 * @param g
	 * @param index
	 * @param relation
	 * @return
	 */
	public static GremlinPipeline<Vertex, Edge> geneOntologyAssociationsEdges(
			Graph g, int index, String relation) {
		return new GremlinPipeline<Vertex, Edge>(g.getVertex(index))
				.outE(relation);
	}
}