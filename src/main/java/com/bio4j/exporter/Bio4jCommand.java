package com.bio4j.exporter;

import groovy.lang.Binding;

import java.util.List;

import org.codehaus.groovy.tools.shell.CommandSupport;
import org.codehaus.groovy.tools.shell.Groovysh;
import org.codehaus.groovy.tools.shell.IO;

import com.tinkerpop.gremlin.console.Mediator;
import com.bio4j.exporter.ExporterCore;

public class Bio4jCommand extends CommandSupport {
	private final Mediator mediator;
	private final IO io;

	public Bio4jCommand(final Groovysh shell, final IO io, final Mediator mediator) {
		super(shell, ":bio4j", ":b4j");
		this.mediator = mediator;
		this.io = io;
	}

	@Override
	public Object execute(List<String> arg0) {
		try {
			String format = null;
			String path = null;
			String query = null;			
			if (arg0.size() == 2){
				format = arg0.get(0).toLowerCase();
				query = arg0.get(1);
			} else if (arg0.size() == 3){
				format = arg0.get(0).toLowerCase();
				path= arg0.get(1);
				query = arg0.get(2);				
			} else {
				throw new IllegalArgumentException("Invalid number of arguments"); 
			}				 
			
			if(format.equals("graphson")){
				ExporterCore.exportGraphson(this.shell, this.io, query, path);
			} 
			else if(format.equals("graphml")){
				ExporterCore.exportGraphml(this.shell, this.io, query, path);

			}
			else if(format.equals("gexf")){
				ExporterCore.exportGexf(this.shell, this.io, query, path);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		

		return null;
	}
}
