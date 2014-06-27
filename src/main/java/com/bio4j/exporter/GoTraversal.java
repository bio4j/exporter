package com.bio4j.exporter;

import com.tinkerpop.gremlin.process.Traversal;
import com.tinkerpop.gremlin.process.graph.step.map.FlatMapStep;
import com.tinkerpop.gremlin.process.graph.step.map.MapStep;
import com.tinkerpop.gremlin.process.graph.step.map.StartStep;
import com.tinkerpop.gremlin.process.util.DefaultTraversal;
import com.tinkerpop.gremlin.structure.Edge;
import com.tinkerpop.gremlin.structure.Graph;
import com.tinkerpop.gremlin.structure.Vertex;

public interface GoTraversal<S, E> extends Traversal<S, E> {
	// Iterates all GeneOntology terms
	public default GoTraversal<S, Vertex> goTerms() {
		return (GoTraversal) this.addStep(
				new StartStep<Vertex>(this, this.memory().<Graph>get("g").V()));
	}

	// Iterates a specific GeneOntology term
	public default GoTraversal<S, Vertex> goTerm(int id) {
		return (GoTraversal) this.addStep(
				new StartStep<Vertex>(this, this.memory().<Graph>get("g").v(id)));
	}

	//Iterates all related vertices with given relation
	public default GoTraversal<S, Vertex> relatedVertices(String rel) {
		FlatMapStep<Vertex, Vertex> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().out(rel));
		return (GoTraversal) this.addStep(flatMapStep);
	}

	//Iterates all related edges with given relation
	public default GoTraversal<S, Edge> relatedEdges(String rel) {
		FlatMapStep<Vertex, Edge> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().outE(rel));
		return (GoTraversal) this.addStep(flatMapStep);
	}

	public default GoTraversal<S,String> name() {
		MapStep<Vertex,String> mapStep = new MapStep<>(this);
		mapStep.setFunction(v -> v.get().<String>value("com.bio4j.titan.model.go.nodes.TitanGoTerm.TitanGoTermType.name"));
		return (GoTraversal) this.addStep(mapStep);
	}

	public static GoTraversal of() {
		return new DefaultGoTraversal();
	}

	public class DefaultGoTraversal extends DefaultTraversal implements GoTraversal {}
}
