package main.java;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Bio4jExporter {

	public static void main(String[] args) {
		Options options = generateOptions();
		BasicParser parser = new BasicParser();
		String format = null;
		String limit = null;
		String maxTime = null;
		String stream = null;

		try {
			// parse the command line arguments
			CommandLine cmd = parser.parse(options, args);

			if (cmd.hasOption("output-format")) {
				format = cmd.getOptionValue("output-format");
			}
			if (cmd.hasOption("limit")) {
				limit = cmd.getOptionValue("limit");
			}
			if (cmd.hasOption("max-time")) {
				maxTime = cmd.getOptionValue("max-time");
			}
			if (cmd.hasOption("s") || cmd.hasOption("stream")) {
				stream = cmd.getOptionValue("stream");
			}
			if (cmd.hasOption("h") || cmd.hasOption("help")) {
				// automatically generate the help statement
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp("bio4j-exporter", options);
				return;
			}

			/* do exporter stuff */

		} catch (ParseException exp) {
			System.out.println("Unexpected exception:" + exp.getMessage());
		}
	}

	@SuppressWarnings("static-access")
	public static Options generateOptions() {

		Options options = new Options();

		options.addOption(OptionBuilder.withLongOpt("output-format")
				.withDescription("output file format (Gexf/Graphml/GraphSON)")
				.hasArg().withArgName("FORMAT").create());

		options.addOption(OptionBuilder.withLongOpt("limit")
				.withDescription("limit for results").hasArg()
				.withArgName("LIMIT").create());

		options.addOption(OptionBuilder.withLongOpt("max-time")
				.withDescription("maximum elapsed time").hasArg()
				.withArgName("TIME").create());

		options.addOption("s", "stream", true, "stream results ([yes]/[no])");

		options.addOption("h", "help", false, "print help statement");

		return options;
	}
}
