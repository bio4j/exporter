package com.bio4j.exporter;

//holds business logic behind the exporter
public class ExporterCore {
	private String format;
	private int limit;
	private int maxTime;
	private boolean stream;

	private final String[] supportedFormats = { "gexfl", "graphml", "graphson" };

	public ExporterCore() {
	}

	public String getFormat() {
		return format;
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
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public void setLimit(String limit) {
		setLimit(Integer.parseInt(limit));
	}

	public int getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}

	public void setMaxTime(String maxTime) {
		setMaxTime(Integer.parseInt(maxTime));
	}

	public boolean isStream() {
		return stream;
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

}
