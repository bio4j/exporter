package com.bio4j.exporter;

import com.tinkerpop.gremlin.process.Traversal;
import com.tinkerpop.gremlin.process.graph.step.map.FlatMapStep;
import com.tinkerpop.gremlin.process.graph.step.map.MapStep;
import com.tinkerpop.gremlin.process.graph.step.map.StartStep;
import com.tinkerpop.gremlin.process.util.DefaultTraversal;
import com.tinkerpop.gremlin.structure.Edge;
import com.tinkerpop.gremlin.structure.Graph;
import com.tinkerpop.gremlin.structure.Vertex;
import com.bio4j.exporter.ExporterCore;
import com.bio4j.exporter.Relationship;

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
	public default GoTraversal<S, Vertex> in(Relationship relationship) {
		String rel = ExporterCore.returnRelString(relationship);			

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
	
	//Iterates all related inbound edges 
		public default GoTraversal<S, Edge> inE() {
			FlatMapStep<Vertex, Edge> flatMapStep = new FlatMapStep<>(this);
			flatMapStep.setFunction(v -> v.get().inE());
			return (GoTraversal<S, Edge>) this.addStep(flatMapStep);
		}

	//Iterates all related inbound edges with given relation
	public default GoTraversal<S, Edge> inE(Relationship relationship) {
		String rel = ExporterCore.returnRelString(relationship);	
		
		FlatMapStep<Vertex, Edge> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().inE(rel));
		return (GoTraversal<S, Edge>) this.addStep(flatMapStep);
	}

	//Iterates all related outbound vertices with given relation
	public default GoTraversal<S, Vertex> out(Relationship relationship) {
		String rel = ExporterCore.returnRelString(relationship);	
		
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
	
	//Iterates all related outbound edges 
		public default GoTraversal<S, Edge> outE() {
			FlatMapStep<Vertex, Edge> flatMapStep = new FlatMapStep<>(this);
			flatMapStep.setFunction(v -> v.get().outE());
			return (GoTraversal<S, Edge>) this.addStep(flatMapStep);
		}

	//Iterates all related outbound edges with given relation
	public default GoTraversal<S, Edge> outE(Relationship relationship) {
		String rel = ExporterCore.returnRelString(relationship);	
		
		FlatMapStep<Vertex, Edge> flatMapStep = new FlatMapStep<>(this);
		flatMapStep.setFunction(v -> v.get().outE(rel));
		return (GoTraversal<S, Edge>) this.addStep(flatMapStep);
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
