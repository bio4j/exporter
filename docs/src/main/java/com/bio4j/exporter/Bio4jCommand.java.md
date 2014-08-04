
```java
package com.bio4j.exporter;

import java.util.List;

import org.codehaus.groovy.tools.shell.CommandSupport;
import org.codehaus.groovy.tools.shell.Groovysh;
import org.codehaus.groovy.tools.shell.IO;

import com.bio4j.exporter.ExporterCore;
```



@author <a href="mailto:andre.garcia.nunes@gmail.com"> André Nunes </a>

This class implements the ``:bio4j`` command for the plugin. It handles user input and passes the query to be executed to ExporterCore. 
 


```java
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