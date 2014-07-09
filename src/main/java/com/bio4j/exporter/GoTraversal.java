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
		return (GoTraversal<S, Vertex>) this.addStep(
				new StartStep<Vertex>(this, this.memory().<Graph>get("g").V()));
	}

	// Iterates a specific GeneOntology term
	public default GoTraversal<S, Vertex> goTerm(int id) {
		return (GoTraversal<S, Vertex>) this.addStep(
				new StartStep<Vertex>(this, this.memory().<Graph>get("g").v(id)));
	}

	//Iterates all related inbound vertices with given relation
	public default GoTraversal<S, Vertex> in(String rel) {
		FlatMapStep<Vertex, Vertex> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().in(rel));
		return (GoTraversal<S, Vertex>) this.addStep(flatMapStep);
	}

	//Iterates all related inbound vertices
	public default GoTraversal<S, Vertex> in() {
		FlatMapStep<Vertex, Vertex> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().in());
		return (GoTraversal<S, Vertex>) this.addStep(flatMapStep);
	}

	//Iterates all related inbound edges with given relation
	public default GoTraversal<S, Edge> inE(String rel) {
		FlatMapStep<Vertex, Edge> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().inE(rel));
		return (GoTraversal<S, Edge>) this.addStep(flatMapStep);
	}

	//Iterates all related outbound vertices with given relation
	public default GoTraversal<S, Vertex> out(String rel) {
		FlatMapStep<Vertex, Vertex> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().out(rel));
		return (GoTraversal<S, Vertex>) this.addStep(flatMapStep);
	}

	//Iterates all related outbound vertices
	public default GoTraversal<S, Vertex> out() {
		FlatMapStep<Vertex, Vertex> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().out());
		return (GoTraversal<S, Vertex>) this.addStep(flatMapStep);
	}

	//Iterates all related outbound edges with given relation
	public default GoTraversal<S, Edge> outE(String rel) {
		FlatMapStep<Vertex, Edge> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().outE(rel));
		return (GoTraversal<S, Edge>) this.addStep(flatMapStep);
	}

	//Iterates all related outbound vertices with a IsA relation
	public default GoTraversal<S, Vertex> outIsA() {
		FlatMapStep<Vertex, Vertex> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().out("com.bio4j.titan.model.go.relationships.TitanIsA.TitanIsAType"));
		return (GoTraversal<S, Vertex>) this.addStep(flatMapStep);
	}

	//Iterates all related outbound vertices with a PartOf relation
	public default GoTraversal<S, Vertex> outPartOf() {
		FlatMapStep<Vertex, Vertex> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().out("com.bio4j.titan.model.go.relationships.TitanPartOf.TitanPartOfType"));
		return (GoTraversal<S, Vertex>) this.addStep(flatMapStep);
	}

	//Iterates all related outbound vertices with a HasPartOf relation
	public default GoTraversal<S, Vertex> outHasPartOf() {
		FlatMapStep<Vertex, Vertex> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().out("com.bio4j.titan.model.go.relationships.TitanHasPartOf.TitanHasPartOfType"));
		return (GoTraversal<S, Vertex>) this.addStep(flatMapStep);
	}

	//Iterates all related outbound vertices with a Regulates relation
	public default GoTraversal<S, Vertex> outRegulates() {
		FlatMapStep<Vertex, Vertex> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().out("com.bio4j.titan.model.go.relationships.TitanRegulates.TitanRegulatesType"));
		return (GoTraversal<S, Vertex>) this.addStep(flatMapStep);
	}

	//Iterates all related outbound vertices with a PositivelyRegulates relation
	public default GoTraversal<S, Vertex> outPositivelyRegulates() {
		FlatMapStep<Vertex, Vertex> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().out("com.bio4j.titan.model.go.relationships.TitanPositivelyRegulates.TitanPositivelyRegulatesType"));
		return (GoTraversal<S, Vertex>) this.addStep(flatMapStep);
	}

	//Iterates all related outbound vertices with a NegativelyRegulates relation
	public default GoTraversal<S, Vertex> outNegativelyRegulates() {
		FlatMapStep<Vertex, Vertex> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().out("com.bio4j.titan.model.go.relationships.TitanNegativelyRegulates.TitanNegativelyRegulatesType"));
		return (GoTraversal<S, Vertex>) this.addStep(flatMapStep);
	}

	//Iterates all related outbound vertices with a SubOntology relation
	public default GoTraversal<S, Vertex> outSubOntology() {
		FlatMapStep<Vertex, Vertex> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().out("com.bio4j.titan.model.go.relationships.TitanSubOntology.TitanSubOntologyType"));
		return (GoTraversal<S, Vertex>) this.addStep(flatMapStep);
	}

	//Iterates all related outbound vertices with a GoSlim relation
	public default GoTraversal<S, Vertex> outGoSlim() {
		FlatMapStep<Vertex, Vertex> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().out("com.bio4j.titan.model.go.relationships.TitanGoSlim.TitanGoSlimType"));
		return (GoTraversal<S, Vertex>) this.addStep(flatMapStep);
	}

	//Iterates all related inbound vertices with a IsA relation
	public default GoTraversal<S, Vertex> inIsA() {
		FlatMapStep<Vertex, Vertex> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().in("com.bio4j.titan.model.go.relationships.TitanIsA.TitanIsAType"));
		return (GoTraversal<S, Vertex>) this.addStep(flatMapStep);
	}

	//Iterates all related inbound vertices with a PartOf relation
	public default GoTraversal<S, Vertex> inPartOf() {
		FlatMapStep<Vertex, Vertex> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().in("com.bio4j.titan.model.go.relationships.TitanPartOf.TitanPartOfType"));
		return (GoTraversal<S, Vertex>) this.addStep(flatMapStep);
	}

	//Iterates all related inbound vertices with a HasPartOf relation
	public default GoTraversal<S, Vertex> inHasPartOf() {
		FlatMapStep<Vertex, Vertex> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().in("com.bio4j.titan.model.go.relationships.TitanHasPartOf.TitanHasPartOfType"));
		return (GoTraversal<S, Vertex>) this.addStep(flatMapStep);
	}

	//Iterates all related inbound vertices with a Regulates relation
	public default GoTraversal<S, Vertex> inRegulates() {
		FlatMapStep<Vertex, Vertex> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().in("com.bio4j.titan.model.go.relationships.TitanRegulates.TitanRegulatesType"));
		return (GoTraversal<S, Vertex>) this.addStep(flatMapStep);
	}

	//Iterates all related inbound vertices with a PositivelyRegulates relation
	public default GoTraversal<S, Vertex> inPositivelyRegulates() {
		FlatMapStep<Vertex, Vertex> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().in("com.bio4j.titan.model.go.relationships.TitanPositivelyRegulates.TitanPositivelyRegulatesType"));
		return (GoTraversal<S, Vertex>) this.addStep(flatMapStep);
	}

	//Iterates all related inbound vertices with a NegativelyRegulates relation
	public default GoTraversal<S, Vertex> inNegativelyRegulates() {
		FlatMapStep<Vertex, Vertex> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().in("com.bio4j.titan.model.go.relationships.TitanNegativelyRegulates.TitanNegativelyRegulatesType"));
		return (GoTraversal<S, Vertex>) this.addStep(flatMapStep);
	}

	//Iterates all related inbound vertices with a SubOntology relation
	public default GoTraversal<S, Vertex> inSubOntology() {
		FlatMapStep<Vertex, Vertex> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().in("com.bio4j.titan.model.go.relationships.TitanSubOntology.TitanSubOntologyType"));
		return (GoTraversal<S, Vertex>) this.addStep(flatMapStep);
	}

	//Iterates all related inbound vertices with a GoSlim relation
	public default GoTraversal<S, Vertex> inGoSlim() {
		FlatMapStep<Vertex, Vertex> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().in("com.bio4j.titan.model.go.relationships.TitanGoSlim.TitanGoSlimType"));
		return (GoTraversal<S, Vertex>) this.addStep(flatMapStep);
	}		

	public default GoTraversal<S,String> id() {
		MapStep<Vertex,String> mapStep = new MapStep<>(this);
		mapStep.setFunction(v -> v.get().<String>value("com.bio4j.titan.model.go.nodes.TitanGoTerm.TitanGoTermType.id"));
		return (GoTraversal<S,String>) this.addStep(mapStep);
	}

	public default GoTraversal<S,String> synonyms() {
		//TODO
		return null;		
	}

	public default GoTraversal<S,String> name() {
		MapStep<Vertex,String> mapStep = new MapStep<>(this);
		mapStep.setFunction(v -> v.get().<String>value("com.bio4j.titan.model.go.nodes.TitanGoTerm.TitanGoTermType.name"));
		return (GoTraversal<S,String>) this.addStep(mapStep);
	}

	public default GoTraversal<S,String> definition() {
		MapStep<Vertex,String> mapStep = new MapStep<>(this);
		mapStep.setFunction(v -> v.get().<String>value("com.bio4j.titan.model.go.nodes.TitanGoTerm.TitanGoTermType.definition"));
		return (GoTraversal<S,String>) this.addStep(mapStep);
	}

	public default GoTraversal<S,String> comment() {
		MapStep<Vertex,String> mapStep = new MapStep<>(this);
		mapStep.setFunction(v -> v.get().<String>value("com.bio4j.titan.model.go.nodes.TitanGoTerm.TitanGoTermType.comment"));
		return (GoTraversal<S,String>) this.addStep(mapStep);
	}

	public static GoTraversal of() {
		return new DefaultGoTraversal();
	}

	public class DefaultGoTraversal extends DefaultTraversal implements GoTraversal {}
}
