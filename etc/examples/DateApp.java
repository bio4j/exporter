package examples;

import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

// Example of application using CLI
public class DateApp {

	public static void main(String[] args) throws ParseException {

		// create Options object
		Options options = new Options();

		// add time option
		options.addOption("time", false, "displays current time");
		// add date option
		options.addOption("date", false, "displays current time");
		// add local option
		options.addOption("local", true, "country code");

		// There are several implementations to parse command line arguments,
		// the recommended one is the DefaultParser but I can't find it in the
		// library, probably outdated documentation
		BasicParser parser = new BasicParser();
		CommandLine cmd = parser.parse(options, args);

		if (cmd.hasOption("time")) { // java DateApp -time

			Date date = new Date();
			// current time
			String str = String.format("Current Time : %tT", date);
			System.out.printf(str);

		} else if (cmd.hasOption("date")) { // java DateApp -date

			Date date = new Date();
			// current date
			String str = String.format("Current Date : %tF", date);
			System.out.printf(str);

		} else if (cmd.hasOption("local")) {
			// get local option value
			String countryCode = cmd.getOptionValue("local");

			// for demonstration purposes it only supports "America/New_York"
			if (countryCode.equals("America/New_York")) {
				Date date = new Date();
				DateFormat nyDf = DateFormat.getDateTimeInstance(
						DateFormat.FULL, DateFormat.FULL);
				nyDf.setTimeZone(TimeZone.getTimeZone("America/New_York"));

				System.out.println("NY    : " + nyDf.format(date));
			}
		}

	}
}
