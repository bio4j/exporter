package main.java;

import com.tinkerpop.gremlin.groovy.Gremlin;

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

	private void defineGeneOntologyAssoc() {
		// ExporterCore.gremlin.defineStep(arg0, arg1, arg2);
	}

	private void defineInteproAssoc() {

	}

	private void defineReactomeAssoc() {

	}

	private void defineOrganism() {

	}

	private void defineEnzymeAssoc() {

	}

	private void definePfamAssoc() {

	}

	public Gremlin getGremlin() {
		return gremlin;
	}
}
