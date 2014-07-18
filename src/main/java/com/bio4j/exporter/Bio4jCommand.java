package com.bio4j.exporter;

import java.util.List;

import org.codehaus.groovy.tools.shell.CommandSupport;
import org.codehaus.groovy.tools.shell.Groovysh;
import org.codehaus.groovy.tools.shell.IO;

import com.tinkerpop.gremlin.console.Mediator;
import com.bio4j.exporter.ExporterCore;

public class Bio4jCommand extends CommandSupport {
	private final Mediator mediator;
	private final IO io;

	public Bio4jCommand(final Groovysh shell, IO io, final Mediator mediator) {
		super(shell, ":bio4j", ":b4j");
		this.mediator = mediator;
		this.io = io;
	}

	@Override
	public Object execute(List<String> arg0) {
		//		String test = (String) this.shell.execute("g.traversal(GoTraversal.class).goTerms().out()");
		//		System.out.println(test);
		try {
			String format = arg0.get(0).toLowerCase();
			String query = arg0.get(1);

			if(format.equals("graphson")){
				ExporterCore.exportGraphson(this.shell, this.io, query);
			} 
			else if(format.equals("graphml")){
				ExporterCore.exportGraphml(this.shell, this.io, query);

			}
			else if(format.equals("gexf")){
				ExporterCore.exportGexf(this.shell, this.io, query);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		

		return null; // ????
	}
}
