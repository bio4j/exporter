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
		ExporterCore exporter = new ExporterCore();

		try {
			// parsing the command line arguments
			if (parseCmdLineArgs(args, options, exporter) == 0) {
				return; // user asked to quit, exporter stops
			}

			if(!initialSetup(exporter)){
				return; // // user asked to quit during setup
			}
			initialQuery(exporter);
			readEvalPrintLoop(exporter, options);

		} catch (Exception e) {
			System.out.println("Invalid query, caught unexpected exception: " + e.getMessage());
			readEvalPrintLoop(exporter, options);
		}
	}

	private static void initialQuery(ExporterCore exporter) {
		if(exporter.getQuery() == null){
			return;
		} else {
			exporter.runQuery();
		}	
	}

	/**
	 * @param exporter
	 * @throws Exception
	 */
	private static boolean initialSetup(ExporterCore exporter) throws Exception {
		printBanner();	

		Scanner scanIn = new Scanner(System.in);
		if (exporter.getFormat() == null) {
			System.out
			.print("Please state the desired output file format (Gexf/Graphml/GraphSON): ");
			String format = scanIn.nextLine();
			if(checkQuit(exporter, scanIn, format))
				return false;
			exporter.setFormat(format);
		}
		if (exporter.getSource() == null) {
			System.out.print("Please state input source adress: ");
			String source = scanIn.nextLine();
			if(checkQuit(exporter, scanIn, source))
				return false;
			exporter.setSource(source);
		}
		return true;
	}

	/**
	 * @param exporter
	 */
	private static void readEvalPrintLoop(ExporterCore exporter, Options options) {
		Scanner scanIn;
		// REPL			
		try {
			while(true){
				exporter.setQuery(null);

				if(exporter.getQuery() == null){
					scanIn = new Scanner(System.in);				
					System.out.print("bio4jexporter> ");
					String arguments = scanIn.nextLine();
					String tokens[] = arguments.split(" ");

					switch(parseCmdLineArgs(tokens, options, exporter)) {
						case 0:	
							scanIn.close();
							exporter.shutdownGraph();
							return; // user asked to quit, exporter stops
						case 1:
							break; // user asked for help, repeat cycle
						default: 
							if(checkQuit(exporter, scanIn, arguments)){
								return;				
							}
							exporter.runQuery();
					}								
				}			
			}
		} catch (Exception e) {
			System.out.println("Invalid query, caught unexpected exception: " + e.getMessage());
			readEvalPrintLoop(exporter, options);
		}
	}

	/**
	 * @param exporter
	 * @param scanIn
	 * @param query
	 * @return 
	 * @throws Exception 
	 */
	private static boolean checkQuit(ExporterCore exporter, Scanner scanIn,
			String query) throws Exception {
		if(query.equalsIgnoreCase("quit") || query.equalsIgnoreCase("exit") ){
			scanIn.close();
			exporter.shutdownGraph();
			return true;			
		} else 
			return false;
	}

	/**
	 * @param args
	 * @param options
	 * @param parser
	 * @param exporter
	 * @throws ParseException
	 * @throws Exception
	 */
	private static int parseCmdLineArgs(String[] args, Options options, ExporterCore exporter) throws ParseException,
	Exception {

		BasicParser parser = new BasicParser();
		CommandLine cmd = parser.parse(options, args);

		if (cmd.hasOption("quit")) {
			return 0;
		}

		if (cmd.hasOption("help")) {
			// automatically generate the help statement
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("bio4j-exporter", options);
			return 1;
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
		return 2;
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

		options.addOption("qr", "query", true,
				"query expressed in Gremlin Graph Querying Language");

		options.addOption("q", "quit", false,
				"exit from the exporter");

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
