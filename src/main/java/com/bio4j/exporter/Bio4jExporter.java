package com.bio4j.exporter;

import java.util.Scanner;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;

public class Bio4jExporter {

	public static void main(String[] args) {
		// Gremlin gremlin = GremlinImpl.getInstance().getGremlin();
		Options options = generateOptions();
		BasicParser parser = new BasicParser();
		ExporterCore exporter = new ExporterCore();

		try {
			// parse the command line arguments
			CommandLine cmd = parser.parse(options, args);

			if (cmd.hasOption("output-format")) {
				exporter.setFormat(cmd.getOptionValue("output-format"));
			}
			if (cmd.hasOption("limit")) {
				exporter.setLimit(cmd.getOptionValue("limit"));
			}
			if (cmd.hasOption("max-time")) {
				exporter.setMaxTime(cmd.getOptionValue("max-time"));
			}
			if (cmd.hasOption("s") || cmd.hasOption("stream")) {
				exporter.setStream(cmd.getOptionValue("stream"));
			}
			if (cmd.hasOption("h") || cmd.hasOption("help")) {
				// automatically generate the help statement
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp("bio4j-exporter", options);
				return;
			}

			printBanner();
			if (exporter.getFormat() == null) {
				System.out
						.print("Please state the desired output file format (Gexf/Graphml/GraphSON):");
				Scanner scanIn = new Scanner(System.in);
				String format = scanIn.nextLine();
				scanIn.close();
				exporter.setFormat(format);
			}
			/* do exporter stuff */

		} catch (Exception exp) {
			System.out.println("Unexpected exception:" + exp.getMessage());
		}
	}

	@SuppressWarnings("static-access")
	private static Options generateOptions() {

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

	private static void printBanner() {
		String banner = " __     __         _____    __                                     __                \n"
				+ "|  |--.|__|.-----.|  |  |  |__| .-----..--.--..-----..-----..----.|  |_ .-----..----.\n"
				+ "|  _  ||  ||  _  ||__    | |  | |  -__||_   _||  _  ||  _  ||   _||   _||  -__||   _|\n"
				+ "|_____||__||_____|   |__|  |  | |_____||__.__||   __||_____||__|  |____||_____||__|  \n"
				+ "                          |___|               |__|                                   ";
		System.out.println(banner);
	}
}
