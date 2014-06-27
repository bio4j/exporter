package com.bio4j.exporter;

import java.util.Scanner;

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
		ExporterCore exporter = new ExporterCore();

		try {
			// parsing the command line arguments
			if (!parseCmdLineArgs(args, options, parser, exporter)) {
				return; // user asked for help, exporter stops
			}

			printBanner();

			Scanner scanIn = new Scanner(System.in);
			if (exporter.getFormat() == null) {
				System.out
					.print("Please state the desired output file format (Gexf/Graphml/GraphSON): ");
				String format = scanIn.nextLine(); 
				exporter.setFormat(format);
			}
			if (exporter.getSource() == null) {
				System.out.print("Please state input source adress: ");
				String source = scanIn.nextLine();
				exporter.setSource(source);
			}
			
			System.out.println("Attempting to run query. . . ");
			exporter.runQuery();
			// REPL			
			while(true){
				scanIn = new Scanner(System.in);				
				System.out.print("bio4jexporter> ");
				String query = scanIn.nextLine();
				
				exporter.setQuery(query);
				if(query.equalsIgnoreCase("quit")){
					scanIn.close();
					return;
				}
				exporter.runQuery();
			}
			
		} catch (Exception exp) {
			System.out.println("Unexpected exception: " + exp.getMessage());
		}
	}

	/**
	 * @param args
	 * @param options
	 * @param parser
	 * @param exporter
	 * @throws ParseException
	 * @throws Exception
	 */
	private static boolean parseCmdLineArgs(String[] args, Options options,
			BasicParser parser, ExporterCore exporter) throws ParseException,
			Exception {

		CommandLine cmd = parser.parse(options, args);

		if (cmd.hasOption("help")) {
			// automatically generate the help statement
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("bio4j-exporter", options);
			return false;
		}

		if (cmd.hasOption("output-format")) {
			exporter.setFormat(cmd.getOptionValue("output-format"));
		}
		if (cmd.hasOption("limit")) {
			exporter.setLimit(cmd.getOptionValue("limit"));
		}
		if (cmd.hasOption("max-time")) {
			exporter.setMaxTime(cmd.getOptionValue("max-time"));
		}
		if (cmd.hasOption("stream")) {
			exporter.setStream(cmd.getOptionValue("stream"));
		}
		if (cmd.hasOption("source")) {
			exporter.setSource(cmd.getOptionValue("source"));
		}
		if (cmd.hasOption("query")) {
			exporter.setQuery(cmd.getOptionValue("query"));
		}
		return true;
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

		options.addOption("src", "source", true,
				"input source adress");

		options.addOption("q", "query", true,
				"query expressed in Gremlin Graph Querying Language");

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
