package exporter.examples;

import java.util.Date;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

// Example of application using CLI
public class DateApp {

	public static void main(String[] args) throws ParseException {

		// create Options object
		Options options = new Options();

		// add t option
		options.addOption("time", false, "displays current time");
		options.addOption("date", false, "displays current time");

		// There are several implementations to parse command line arguments,
		// the recommended one is the DefaultParser but I can't find it in the
		// library, probably outdated documentation
		BasicParser parser = new BasicParser();
		CommandLine cmd = parser.parse(options, args);

		if (cmd.hasOption("time")) {

			Date date = new Date();
			// current time
			String str = String.format("Current Time : %tT", date);
			System.out.printf(str);

		} else if (cmd.hasOption("date")) {

			Date date = new Date();
			// current date
			String str = String.format("Current Date : %tF", date);
			System.out.printf(str);

		}

	}
}
