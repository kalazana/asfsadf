package de.jasperroloff.education.lpsw.b.b9;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 *
 * This program determines how a stock price changed from the beginning to the end of a year.
 * The data is read from a csv file, which has to meet the following requirements:
 * - the data starts at line 7 (line 1 to 6 are for description and other things)
 * - the first column is the date with format dd.MM.yyyy
 * - the second column is the stock price without thousand separator and with comma or dot as decimal separator
 * - columns have to be separated by a semicolon
 * - the rows have to be ordered by date in a descending order
 *
 * The result or, if occuring, errors will be printed out to console.
 */
public class Program {
	/**
	 * Runs the program
	 * @param args requires no args
	 */
    public static void main(String[] args) {
    	// configure the year
        int year = 2011;

		// define begin and end
		Calendar startOfYear = new GregorianCalendar();
		Calendar endOfYear = new GregorianCalendar();

		// set begin and end
		startOfYear.set(year, Calendar.JANUARY, 1);
		endOfYear.set(year, Calendar.DECEMBER, 31);

		// save begin and date into date variables
		Date startDate = startOfYear.getTime();
		Date endDate = endOfYear.getTime();

        try {
			String[] result = findStartAndEndRow(startDate, endDate, new File("example-files/DWS-TOP-DIVIDENDE.csv"));
			printResult(
					Double.parseDouble(result[0].split(";")[1].replace(",", ".")),
					Double.parseDouble(result[1].split(";")[1].replace(",", "."))
			);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
    }

	/**
	 * Given a start value and a end value this method prints whether the value has increased or decreased.
	 * @param startValue value at the beginning of desired  time range
	 * @param endValue value at the end of desired time range
	 */
	private static void printResult(double startValue, double endValue) {
        if (startValue < endValue) {
            System.out.printf("Kurs gestiegen (Bull) von %f auf %f", startValue, endValue);
            System.out.println();
        } else if (startValue > endValue) {
            System.out.printf("Kurs gefallen (Bear) von %f auf %f", startValue, endValue);
            System.out.println();
        } else {
            System.out.println("Kein Kursunterschied zwischen Anfang und Ende");
        }
    }

	/**
	 * Given a start date, an end date and a file object, this method reads the file and finds the first row in the time series and the last row in the time series
	 * @param startDate beginning of desired time range
	 * @param endDate end of desired time range
	 * @param file csv file
	 * @return returns an array containing two elements: [first row, last row] within desired time range
	 * @throws Exception when reading of the file did fail, e.g. when dates failed to parse or when the file wasn't found
	 */
    private static String[] findStartAndEndRow(Date startDate, Date endDate, File file) throws Exception {
    	// return variable
    	String[] result = new String[2];

    	// line index of input file
		int rowCount = 1;

		// define date pattern
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

		// variables for start or end rows
		String startRow = null;
		String endRow = null;

		// variable where date of current row will be saved
		Date currentDate;

		try {
			// open file
			BufferedReader in = new BufferedReader(new FileReader(file));

			// skip first 6 lines of input file
			for (; rowCount <= 7; rowCount++) {
				if (in.readLine() == null) {
					break;
				}
			}

			// loop through lines of file
			String row;
			while ((row = in.readLine()) != null) {
				// read and parse date column
				currentDate = dateFormat.parse(row.split(";")[0]);

				// check if date is within desired range
				if (currentDate.getTime() <= endDate.getTime()) {
					// if date is in desired range, check if it is the first one
					if (endRow == null) {
						// if date is the first one in desired range, save it
						endRow = row;
					}

					// if date is after start of year save it, so after this loop we have the latest value
					if (currentDate.getTime() >= startDate.getTime()) {
						startRow = row;
					}
				}

				rowCount++;
			}
		} catch (ParseException e) {
			StringBuilder message = new StringBuilder();
			Formatter formatter = new Formatter(message);
			formatter.format("Date parsing failed in line %d of input file!", rowCount);
			throw new Exception(message.toString());
		} catch (FileNotFoundException e) {
			throw new Exception("Die Datei konnte nicht gefunden werden!");
		} catch (IOException e) {
			throw new Exception("Es ist ein Fehler beim Lesen der Datei aufgetreten");
		}

		if (startRow != null) {
			System.out.println("Start row: " + startRow);
			System.out.println("End row:   " + endRow);
			result[0] = startRow;
			result[1] = endRow;
		} else {
			throw new Exception("Es konnte keine Daten aus dem gewünschtem Jahr gefunden werden");
		}

		return result;
	}
}
