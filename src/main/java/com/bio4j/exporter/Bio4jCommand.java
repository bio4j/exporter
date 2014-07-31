package com.bio4j.exporter;

import java.util.List;

import org.codehaus.groovy.tools.shell.CommandSupport;
import org.codehaus.groovy.tools.shell.Groovysh;
import org.codehaus.groovy.tools.shell.IO;

import com.bio4j.exporter.ExporterCore;

public class Bio4jCommand extends CommandSupport {
	private static final int FORMAT_INDEX = 0;
	private static final int PATH_INDEX = 1;
	private static final int QUERY_INDEX = 2;

	private final IO io;	

	public Bio4jCommand(final Groovysh shell, final IO io) {
		super(shell, ":bio4j", ":b4j");
		this.io = io;
	}

	@Override
	public Object execute(List<String> arg0) {
		try {
			String format = null;
			String path = null;
			String query = null;			
			if (arg0.size() == 2){
				format = arg0.get(FORMAT_INDEX).toLowerCase();
				query = arg0.get(PATH_INDEX);
			} else if (arg0.size() == 3){
				format = arg0.get(FORMAT_INDEX).toLowerCase();
				path= arg0.get(PATH_INDEX);
				query = arg0.get(QUERY_INDEX);				
			} else {
				throw new IllegalArgumentException("Invalid number of arguments"); 
			}				 

			if(format.equals("graphson")){
				ExporterCore.exportGraphson(this.shell, this.io, query, path);
			} 
			else if(format.equals("graphml")){
				ExporterCore.exportGraphml(this.shell, this.io, query, path);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
