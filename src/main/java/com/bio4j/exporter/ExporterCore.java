package com.bio4j.exporter;

import org.apache.commons.configuration.BaseConfiguration;
import org.apache.commons.configuration.CombinedConfiguration;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.gremlin.groovy.Gremlin;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.iterators.SingleIterator;
import com.thinkaurelius.titan.core.TitanFactory;
import com.thinkaurelius.titan.core.TitanGraph;

//holds business logic behind the exporter
public class ExporterCore {
	private String format;
	private int limit;
	private int maxTime;
	private boolean stream;
	private String source;
	private String query;
	private TitanGraph graph;

	private final String[] supportedFormats = { "gexf", "graphml", "graphson" };

	public ExporterCore() {
	}

	public String getFormat() {
		return this.format;
	}

	public void setFormat(String format) throws Exception {
		String lowercaseFormat = format.toLowerCase();
		// check whether the format is supported or not
		for (String supported : supportedFormats) {
			if (lowercaseFormat.equals(supported)) {
				this.format = lowercaseFormat;
				break;
			}
		}
		if (this.format == null) {
			throw new Exception("Format not supported: " + format);
		}
	}

	public int getLimit() {
		return this.limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public void setLimit(String limit) {
		setLimit(Integer.parseInt(limit));
	}

	public int getMaxTime() {
		return this.maxTime;
	}

	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}

	public void setMaxTime(String maxTime) {
		setMaxTime(Integer.parseInt(maxTime));
	}

	public boolean isStream() {
		return this.stream;
	}

	public void setStream(boolean stream) {
		this.stream = stream;
	}

	public void setStream(String stream) throws Exception {
		String lowercaseStream = stream.toLowerCase();
		if (lowercaseStream.equals("yes")) {
			this.stream = true;
		} else if (lowercaseStream.equals("no")) {
			this.stream = false;
		} else {
			throw new Exception("Stream flag requires 'yes' or 'no'");
		}
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
		this.graph = loadTitanGraph(source);
	}

	private TitanGraph loadTitanGraph(String source) {
//		BaseConfiguration conf = new BaseConfiguration();
//		conf.setProperty("storage.directory", source);
		return TitanFactory.open(source);
	}

	public String getQuery() {
		return this.query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public void runQuery() {
//		Pipe pipe = Gremlin.compile("_().['com.bio4j.titan.model.go.nodes.TitanGoTerm.TitanGoTermType.name']");
//		pipe.setStarts(new SingleIterator<Vertex>(this.graph.getVertex(2340)));
//		for(Object name : pipe) {
//		  System.out.println((String) name);
//		}
	}

}
