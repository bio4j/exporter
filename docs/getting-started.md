### Getting started

#### Prerequisites

* [sbt](http://www.scala-sbt.org/) installed
* gremlin-3 console installed: [instructions here](https://github.com/tinkerpop/tinkerpop3)


#### Building and loading the Plugin

##### First Method (easiest)

* Clone or download the exporter.
* Publish the application to your local maven repository (``.m2/``) using ``sbt publish``. This will publish the exporter under ``.m2`` due to the ``publishTo`` flag on ``sbt.build```:

```groovy
publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository")))
```
* Start the plugin:
```
         \,,,/
         (o o)
-----oOOo-(3)-oOOo-----
gremlin> :install bio4j exporter 0.1.0-SNAPSHOT
==>loaded: [bio4j, exporter, 0.1.0-SNAPSHOT]
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

##### Second Method

* Clone or download the exporter.
* ``sbt assembly`` This will generate a jar with the plugin and all it's dependencies.
* After generating it you need to copy the jar to the ``/lib/`` folder on the Gremlin Console path and start it.
* Now you need to activate the bio4j plugin, this can be done in two different ways:
Add ``com.bio4j.exporter.Bio4jGremlinPlugin`` to the ``/ext/plugins.txt`` file on the Tinkerpop3 folder.
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
