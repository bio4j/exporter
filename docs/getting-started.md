#### Building and loading the Plugin

* Clone or download the exporter.

* ``sbt assembly`` This will generate a jar with the plugin and all it's dependencies.

* After generating it you need to copy the jar to the ``/lib/`` folder on the Gremlin Console path and start it. 

The plugin should show its name as one of the ones that was loaded at startup:
```
         \,,,/
         (o o)
-----oOOo-(3)-oOOo-----
plugin loaded: bio4j
gremlin>
```

You can now start using the plugin.
