package com.bio4j.exporter;

import java.util.HashSet;
import java.util.Set;

import com.tinkerpop.gremlin.groovy.plugin.GremlinPlugin;
import com.tinkerpop.gremlin.groovy.plugin.PluginAcceptor;

public class Bio4jGremlinPlugin implements GremlinPlugin {
	
	private static final String IMPORT = "import ";
    private static final String DOT_STAR = ".*";

    private static final Set<String> IMPORTS = new HashSet<String>() {{
        add(IMPORT + ExporterCore.class.getPackage().getName() + DOT_STAR);
    }};

    @Override
    public String getName() {
        return "bio4j";
    }

    @Override
    public void pluginTo(final PluginAcceptor pluginAcceptor) {
        pluginAcceptor.addImports(IMPORTS);
    }
}
