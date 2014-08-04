
```java
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

```


------

### Index

+ src
  + main
    + resources
      + META-INF
        + services
    + java
      + com
        + bio4j
          + exporter
            + [Bio4jCommand.java][main/java/com/bio4j/exporter/Bio4jCommand.java]
            + [Bio4jGremlinPlugin.java][main/java/com/bio4j/exporter/Bio4jGremlinPlugin.java]
            + [ExporterCore.java][main/java/com/bio4j/exporter/ExporterCore.java]
            + [Relationship.java][main/java/com/bio4j/exporter/Relationship.java]
            + [GoTraversal.java][main/java/com/bio4j/exporter/GoTraversal.java]
  + test
    + java
      + com
        + bio4j
          + exporter
            + test
              + [AllTests.java][test/java/com/bio4j/exporter/test/AllTests.java]
              + [ExporterCoreTest.java][test/java/com/bio4j/exporter/test/ExporterCoreTest.java]

[main/java/com/bio4j/exporter/Bio4jCommand.java]: Bio4jCommand.java.md
[main/java/com/bio4j/exporter/Bio4jGremlinPlugin.java]: Bio4jGremlinPlugin.java.md
[main/java/com/bio4j/exporter/ExporterCore.java]: ExporterCore.java.md
[main/java/com/bio4j/exporter/Relationship.java]: Relationship.java.md
[main/java/com/bio4j/exporter/GoTraversal.java]: GoTraversal.java.md
[test/java/com/bio4j/exporter/test/AllTests.java]: ../../../../../test/java/com/bio4j/exporter/test/AllTests.java.md
[test/java/com/bio4j/exporter/test/ExporterCoreTest.java]: ../../../../../test/java/com/bio4j/exporter/test/ExporterCoreTest.java.md