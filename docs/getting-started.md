### Getting started

#### Prerequisites

* [sbt](http://www.scala-sbt.org/) installed
* gremlin-3 console installed: [instructions here](https://github.com/tinkerpop/tinkerpop3)


#### Building and loading the Plugin

* Clone or download the exporter.

* ``sbt assembly`` This will generate a jar with the plugin and all it's dependencies.

* After generating it you need to copy the jar to the ``lib/`` folder on the Gremlin Console path and start it.

* Now you need to activate the bio4j plugin, this can be done in two different ways:
 
Add ``com.bio4j.exporter.Bio4jGremlinPlugin`` to the ``ext/plugins.txt`` file on the Tinkerpop3 folder.
Then the plugin should show its name as one of the ones that was activated at startup:
```
         \,,,/
         (o o)
-----oOOo-(3)-oOOo-----
plugin activated: bio4j
gremlin>
```

**Alternatively** you can activate the plugin manually: 

```
         \,,,/
         (o o)
-----oOOo-(3)-oOOo-----
gremlin> :plugin list
==>bio4j
==>server
==>gephi
==>sugar
==>utilities
gremlin> :plugin use bio4j
==>bio4j activated
gremlin>
```

You can now try out the plugin. See the [Usage examples](usage-examples.md) section.


