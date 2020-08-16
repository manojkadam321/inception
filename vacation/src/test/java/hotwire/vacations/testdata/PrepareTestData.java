package hotwire.vacations.testdata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Manoj Kadam : QA Automation
 * Methods throws ParseException
 *
 */
public class PrepareTestData {

	public static String getNextDayDateAsString() throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);// add 1 day to return next day date
		return dateFormat.format(c.getTimeInMillis());
	}

	public static String getThreeWeeksAfterDayDateAsString() throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 21);// add 21 days to return three weeks after date
		return dateFormat.format(c.getTimeInMillis());
	}

}
