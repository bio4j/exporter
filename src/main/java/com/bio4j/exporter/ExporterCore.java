package com.bio4j.exporter;

//holds business logic behind the exporter
public class ExporterCore {
//	private String outputFormat;
//	private int limit;
//	private int maxTime;
//	private boolean stream;
//	private String source;
//	private String query;
//	private Graph graph;
//
//	private final String[] supportedFormats = { "gexf", "graphml", "graphson" };
//
//	public ExporterCore() {
//	}
//
//	public String getFormat() {
//		return this.outputFormat;
//	}
//
//	public void setFormat(String format) throws Exception {
//		this.outputFormat = null;
//		String lowercaseFormat = format.toLowerCase();
//		// check whether the format is supported or not
//		for (String supported : supportedFormats) {
//			if (lowercaseFormat.equals(supported)) {
//				this.outputFormat = lowercaseFormat;
//				break;
//			}
//		}
//		if (this.outputFormat == null) {
//			throw new Exception("Format not supported: " + format);
//		}
//	}
//
//	public int getLimit() {
//		return this.limit;
//	}
//
//	public void setLimit(int limit) {
//		this.limit = limit;
//	}
//
//	public void setLimit(String limit) {
//		setLimit(Integer.parseInt(limit));
//	}
//
//	public int getMaxTime() {
//		return this.maxTime;
//	}
//
//	public void setMaxTime(int maxTime) {
//		this.maxTime = maxTime;
//	}
//
//	public void setMaxTime(String maxTime) {
//		setMaxTime(Integer.parseInt(maxTime));
//	}
//
//	public boolean isStream() {
//		return this.stream;
//	}
//
//	public void setStream(boolean stream) {
//		this.stream = stream;
//	}
//
//	public void setStream(String stream) throws Exception {
//		if(stream == null){
//			throw new Exception("Stream flag can't be null");
//		}
//		String lowercaseStream = stream.toLowerCase();
//		if (lowercaseStream.equals("yes")) {
//			this.stream = true;
//		} else if (lowercaseStream.equals("no")) {
//			this.stream = false;
//		} else {
//			throw new Exception("Stream flag requires 'yes' or 'no'");
//		}
//	}
//
//	public String getSource() {
//		return this.source;
//	}
//
//	public void setSource(String source) throws Exception {
//		if(source == null){
//			throw new Exception("Source can't be null");
//		} 
//		this.source = source;
//	}
//
//	public String getQuery() {
//		return this.query;
//	}
//
//	public void setQuery(String query) {
//		if(query == null){
//			this.query = null;
//			return;
//		}
//		query = query.replace("[", "(");
//		query = query.replace("]", ")");
//		this.query = query;		
//	}
//
//	public void runQuery() {
//		final TinkerGraph g = TinkerFactory.createClassic();
//		try {
//			FileOutputStream f = new FileOutputStream("bio4j.json");
//			if(this.outputFormat.equals("graphson")){
//				// Export query to graphSON
//				GraphSONWriter w = GraphSONWriter.create().embedTypes(true).build();
//				w.writeVertices(f, g.traversal(GoTraversal.class).goTerms().out("created"), Direction.BOTH);
//				System.out.println("==> exported to bio4j.json");
//			}
//			if(this.outputFormat.equals("graphml")){
//				//TODO export to graphml
//				
//			}
//			if(this.outputFormat.equals("gexf")){
//				//TODO export to graphml
//			}
//			f.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}			
//	}
//
//	public void shutdownGraph() {
//		// TODO Auto-generated method stub
//		
//	}
}

