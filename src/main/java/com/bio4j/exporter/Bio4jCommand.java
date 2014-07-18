package com.bio4j.exporter;

import java.io.FileOutputStream;
import java.util.List;

import org.codehaus.groovy.tools.shell.CommandSupport;
import org.codehaus.groovy.tools.shell.Groovysh;

import com.tinkerpop.gremlin.console.Mediator;
import com.tinkerpop.gremlin.process.Traversal;
import com.tinkerpop.gremlin.structure.Vertex;
import com.tinkerpop.gremlin.structure.io.graphson.GraphSONWriter;

import com.bio4j.exporter.ExporterCore;

public class Bio4jCommand extends CommandSupport {
	private final Mediator mediator;

	public Bio4jCommand(final Groovysh shell, final Mediator mediator) {
		super(shell, ":bio4j", ":b4j");
		this.mediator = mediator;
	}

	@Override
	public Object execute(List<String> arg0) {
		//		String test = (String) this.shell.execute("g.traversal(GoTraversal.class).goTerms().out()");
		//		System.out.println(test);
		try {
			FileOutputStream f = new FileOutputStream("bio4j.json");
			String format = arg0.get(0).toLowerCase();
			String query = arg0.get(1);

			if(format.equals("graphson")){
				ExporterCore.exportGraphson(this.shell, format, query);
			}
			if(format.equals("graphml")){
				ExporterCore.exportGraphml(this.shell, format, query);

			}
			if(format.equals("gexf")){
				ExporterCore.exportGexf(this.shell, format, query);
			}

			f.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		

		return null; // ????
	}
}
