package com.bio4j.exporter;

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
		return TitanFactory.open(source);
	}

	public String getQuery() {
		return this.query;
	}

	public void setQuery(String query) {
		query = query.replace("[", "(");
		query = query.replace("]", ")");
		this.query = query;		
	}

	public void runQuery() {
		if(this.query.startsWith("g.V().")){
			String translatedQuery = this.query.substring(6); // discard g.V()
			Pipe pipe = Gremlin.compile("_()." + translatedQuery); // create pipe for iteration
			pipe.setStarts(this.graph.getVertices());
				for(Object name : pipe) {
					System.out.println("----------------------------------------------------");
					System.out.println((String) name);
					System.out.println("----------------------------------------------------");
				}			
		}
		if(this.query.startsWith("g.v(")){
			// get the index number given
			String[] indexInString = this.query.split("\\("); 
			indexInString = indexInString[1].split("\\)"); // get the number between parentesis
			int index = Integer.parseInt(indexInString[0]); // number should be in the vector
			
			String translatedQuery = this.query.substring(4); // discard 'g.v('
			translatedQuery = translatedQuery.substring(indexInString[0].length() + 1); // discard the number and ')'
			
			if(translatedQuery.equals("")){
				//TODO IMPROVE QUERY HANDLING
				return;
			}
		    		    
		    Pipe pipe = Gremlin.compile("_()." + translatedQuery) ;
		    pipe.setStarts(new SingleIterator<Vertex>(graph.getVertex(index))); // create pipe for iteration
		    for(Object name : pipe) {
		    	System.out.println("----------------------------------------------------");
				System.out.println((String) name);
				System.out.println("----------------------------------------------------");
		    }		
		}
	}

	public void shutdownGraph() {
		if(this.graph instanceof TitanGraph){
			this.graph.shutdown();
		}		
	}
}

