package com.bio4j.exporter;

import com.tinkerpop.gremlin.process.Traversal;
import com.tinkerpop.gremlin.process.graph.step.map.FlatMapStep;
import com.tinkerpop.gremlin.process.graph.step.map.MapStep;
import com.tinkerpop.gremlin.process.graph.step.map.StartStep;
import com.tinkerpop.gremlin.process.util.DefaultTraversal;
import com.tinkerpop.gremlin.structure.Graph;
import com.tinkerpop.gremlin.structure.Vertex;


// 	OLD CODE
//	public static GremlinPipeline<Vertex, Vertex> geneOntologyRelatedVertices(
//			Graph g, String relation) {
//		return new GremlinPipeline<Vertex, Vertex>(g).V().out(relation);
//	}
//	public static GremlinPipeline<Vertex, Vertex> geneOntologyVertexRelatedVertices(
//			Graph g, int index, String relation) {
//		return new GremlinPipeline<Vertex, Vertex>(g.getVertex(index))
//				.out(relation);
//	}
//	public static GremlinPipeline<Vertex, Edge> geneOntologyRelatedEdges(
//			Graph g, String relation) {
//		return new GremlinPipeline<Vertex, Edge>(g).V().outE(relation);
//	}
//	public static GremlinPipeline<Vertex, Edge> geneOntologyAssociationsEdges(
//			Graph g, int index, String relation) {
//		return new GremlinPipeline<Vertex, Edge>(g.getVertex(index))
//				.outE(relation);
//	}


public interface GoTraversal<S, E> extends Traversal<S, E> {
//		EXAMPLE CODE
//	   public default GoTraversal<S, Vertex> people() {
//	     return (GoTraversal) this.addStep(
//	       new StartStep<Vertex>(this, this.memory().<Graph>get("g").V().has("age")));
//	   }
//
//	   public default GoTraversal<S, Vertex> people(String name) {
//	     return (GoTraversal) this.addStep(
//	       new StartStep<Vertex>(this, this.memory().<Graph>get("g").V().has("name", name)));
//	   }
//
//	  public default GoTraversal<S, Vertex> knows() {
//	    FlatMapStep<Vertex, Vertex> flatMapStep = new FlatMapStep<>(this);
//	    flatMapStep.setFunction(v -> v.get().out("knows"));
//	    return (GoTraversal) this.addStep(flatMapStep);
//	  }
//
//	  public default GoTraversal<S,String> name() {
//	    MapStep<Vertex,String> mapStep = new MapStep<>(this);
//	    mapStep.setFunction(v -> v.get().<String>value("name"));
//	    return (GoTraversal) this.addStep(mapStep);
//	  }
//
//	  public static GoTraversal of() {
//	    return new DefaultSocialTraversal();
//	  }
//
//	  public class DefaultSocialTraversal extends DefaultTraversal implements GoTraversal {		  
//	  }
}