### Getting started

#### Prerequisites

* Install [sbt](http://www.scala-sbt.org/download)
* Install [Tinkerpop3 Gremlin Console](http://www.tinkerpop.com)


#### Installing the plugin

* Clone or download the exporter:
      ```
      $ git clone https://github.com/bio4j/exporter.git
      ```

* Publish it to your local maven repository: 
      ```
      $ cd exporter
      $ sbt publishM2
      ```

* Then run the Gremlin Console and add the plugin:
    ```
             \,,,/
             (o o)
    -----oOOo-(3)-oOOo-----
    gremlin> :install bio4j exporter 0.1.0-SNAPSHOT
    ==>loaded: [bio4j, exporter, 0.1.0-SNAPSHOT]
    gremlin> :plugin use bio4j
    ==>bio4j activated
    ```

Now you can try out the plugin. See the [Usage examples](usage-examples.md) section.
