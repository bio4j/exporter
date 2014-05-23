package exporter.examples;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Ls {
	@SuppressWarnings("static-access")
	public static Options generateOptions() {

		Options options = new Options();
		options.addOption("a", "all", false,
				"do not hide entries starting with .");
		options.addOption("A", "almost-all", false,
				"do not list implied . and ..");
		options.addOption("b", "escape", false,
				"print octal escapes for nongraphic " + "characters");
		options.addOption(OptionBuilder.withLongOpt("block-size")
				.withDescription("use SIZE-byte blocks").hasArg()
				.withArgName("SIZE").create());
		options.addOption("B", "ignore-backups", false,
				"do not list implied entried " + "ending with ~");
		options.addOption("c", false,
				"with -lt: sort by, and show, ctime (time of last "
						+ "modification of file status information) with "
						+ "-l:show ctime and sort by name otherwise: sort "
						+ "by ctime");
		options.addOption("C", false, "list entries by columns");

		return options;
	}

	public static void main(String[] args) {
		Options options = generateOptions();

		BasicParser parser = new BasicParser();
		try {
			// parse the command line arguments
			CommandLine line = parser.parse(options, args);

			// validate that block-size has been set
			if (line.hasOption("block-size")) {
				// print the value of block-size
				System.out.println(line.getOptionValue("block-size"));
			}
		} catch (ParseException exp) {
			System.out.println("Unexpected exception:" + exp.getMessage());
		}
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("ls", options);
	}

}
