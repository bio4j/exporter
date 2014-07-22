package com.bio4j.exporter;

import java.util.HashSet;
import java.util.Set;

import org.codehaus.groovy.tools.shell.Groovysh;
import org.codehaus.groovy.tools.shell.IO;

import com.tinkerpop.gremlin.groovy.plugin.GremlinPlugin;
import com.tinkerpop.gremlin.groovy.plugin.PluginAcceptor;

public class Bio4jGremlinPlugin implements GremlinPlugin {

	private static final String IMPORT = "import ";
	private static final String DOT_STAR = ".*";
	private static final String NAME = "bio4j";

	private static final Set<String> IMPORTS = new HashSet<String>() {{
		add(IMPORT + ExporterCore.class.getPackage().getName() + DOT_STAR);
	}};

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public void pluginTo(final PluginAcceptor pluginAcceptor) {
		pluginAcceptor.addImports(IMPORTS);
		final Groovysh groovy = (Groovysh) pluginAcceptor.environment().get("ConsolePluginAcceptor.shell");
		final IO io = (IO) pluginAcceptor.environment().get("ConsolePluginAcceptor.io");      
		groovy.register(new Bio4jCommand(groovy, io));
	}   
}
