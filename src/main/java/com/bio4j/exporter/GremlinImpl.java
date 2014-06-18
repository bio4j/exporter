package com.bio4j.exporter;

import java.util.ArrayList;
import java.util.List;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.gremlin.groovy.Gremlin;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.pipes.Pipe;

public class GremlinImpl {
	private static GremlinImpl instance;
	private static Gremlin gremlin;

	private GremlinImpl() {
		gremlin = new Gremlin();
		defineGeneOntologyAssoc();
		defineInteproAssoc();
		defineReactomeAssoc();
		defineOrganism();
		defineEnzymeAssoc();
		definePfamAssoc();
	}

	public static GremlinImpl getInstance() {
		if (instance == null) {
			instance = new GremlinImpl();
		}
		return instance;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	/**
	 * Generares the [Vertex, Pipe] list for the user defined steps
	 *
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private List<Class> createClassList() {
		List<Class> listClass = new ArrayList<Class>();
		listClass.add(Vertex.class);
		listClass.add(Pipe.class);
		return listClass;
	}

	@SuppressWarnings("rawtypes")
	private void defineGeneOntologyAssoc() {
		DummyClosure closure = (String relationship) -> {
			new GremlinPipeline().as("x").out(relationship);
		};
		Gremlin.defineStep("go", createClassList(),
				(groovy.lang.Closure) closure);
	}

	@SuppressWarnings("rawtypes")
	private void defineInteproAssoc() {
		DummyClosure closure = (String relationship) -> {
			new GremlinPipeline().as("x").out(relationship);
		};
		Gremlin.defineStep("intepro", createClassList(),
				(groovy.lang.Closure) closure);

	}

	@SuppressWarnings("rawtypes")
	private void defineReactomeAssoc() {
		DummyClosure closure = (String relationship) -> {
			new GremlinPipeline().as("x").out(relationship);
		};
		Gremlin.defineStep("reactome", createClassList(),
				(groovy.lang.Closure) closure);

	}

	private void defineOrganism() {

	}

	@SuppressWarnings("rawtypes")
	private void defineEnzymeAssoc() {
		DummyClosure closure = (String relationship) -> {
			new GremlinPipeline().as("x").out(relationship);
		};
		Gremlin.defineStep("enzyme", createClassList(),
				(groovy.lang.Closure) closure);
	}

	@SuppressWarnings("rawtypes")
	private void definePfamAssoc() {
		DummyClosure closure = (String relationship) -> {
			new GremlinPipeline().as("x").out(relationship);
		};
		Gremlin.defineStep("pfam", createClassList(),
				(groovy.lang.Closure) closure);
	}

	public Gremlin getGremlin() {
		return gremlin;
	}
}

interface DummyClosure {
	void doCall(String s);
}
