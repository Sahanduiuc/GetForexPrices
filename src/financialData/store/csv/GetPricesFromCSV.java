package financialData.store.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;

import financialDataKeys.RecordKeys;


/**
 * Reads contents of CSV file. Separates values at commas and stores in a String[][].
 * Where String[][] = String[row][column]. Link to data source provided underneath.
 * When failed class does not send back null but sends back a String[1][1] where 
 * String[1][1] = "fail". Source of data is provided
 * 
 * @author James Austin
 * @version 1.0
 * @since 42/04/2018
 * @link https://www.dukascopy.com/plugins/fxMarketWatch/?historical_data
 */

class GetPricesFromCSV {
	/**
	 * <p>Takes a String input which should contain the full name of the asset class to parse. 
	 * I.e. String fileToRead = "GBP_USD_HOUR" . </p>
	 * 
	 * <p>It then parses the assets CSV file and returns the contents as String[row][column].
	 * <br>I.e. String[0][0] holds the first column data from the first period.
	 * </p>
	 * 
	 * @param String
	 * @return String[][]
	 */
	static HashMap <String, ArrayList <String> > getPrices(String fileToRead) {	
		try{
			BufferedReader valuesToRead = getBufferedReader(fileToRead);
			return setReturnValues(valuesToRead);
		}
		catch(NullPointerException exceptionDetails) {
			System.out.println("Null Pointer in GetPricesFromCSV.getPrices()");
			System.out.println("Attempted to get " + fileToRead);
			System.out.println(exceptionDetails);
			return null;
		} catch (FileNotFoundException exceptionDetails) {
			System.out.println("Null Pointer in GetPricesFromCSV.getPrices()");
			System.out.println("Attempted to get " + fileToRead);
			System.out.println(exceptionDetails);
			return null;
		}
	}

	/**
	 * This function sets up buffered reader with the text file to parse. Returns the setup
	 * buffered reader
	 * 
	 * @return BufferedReader
	 */
	private static BufferedReader getBufferedReader(String fileToRead) throws FileNotFoundException {
		fileToRead = "Resources\\Price_Sets\\" + fileToRead;
		File file = new File(fileToRead);
		return new BufferedReader( new FileReader(file) );
	}

	/**
	 * This function translates a buffered reader into a String[][] to return
	 * @param  valuesToRead - a bufferedReader setup with a text file.
	 * @return String[][] returns the parsed ontents of the text file in String[row][column] 
	 * format.
	*/
	private static HashMap <String, ArrayList <String> > setReturnValues(BufferedReader valuesToRead) {
		HashMap <String, ArrayList <String> > rawValues = setupReturnHashMap();
		
		try {
			String currentLine = null;	
			
			while ( (currentLine = valuesToRead.readLine()) != null)
			{   
				String[] records = currentLine.split(",");

				rawValues.get(RecordKeys.DATE).add(records[RecordKeys.LOCATIONOFDATE]);
				rawValues.get(RecordKeys.TIME).add(records[RecordKeys.LOCATIONOFTIME]);
				rawValues.get(RecordKeys.OPEN).add(records[RecordKeys.LOCATIONOFOPEN]);
				rawValues.get(RecordKeys.HIGH).add(records[RecordKeys.LOCATIONOFHIGH]);
				rawValues.get(RecordKeys.LOW).add(records[RecordKeys.LOCATIONOFLOW]);
				rawValues.get(RecordKeys.CLOSE).add(records[RecordKeys.LOCATIONOFCLOSE]);
				rawValues.get(RecordKeys.VOLUME).add(records[RecordKeys.LOCATIONOFVOLUME]);
			}
			

			return rawValues;
		}
		catch(IOException exceptionDetails) {
			System.out.println("IOException in GetPricesFromCSV.setReturnValues");
			System.out.println(exceptionDetails);	
			return null;
		}		
	}
	
	private static HashMap <String, ArrayList <String> > setupReturnHashMap() {
		HashMap <String, ArrayList <String> > rawData = new HashMap <String, ArrayList<String>  > ();
		
		rawData.put( RecordKeys.DATE, new ArrayList<String>() );
		rawData.put( RecordKeys.TIME, new ArrayList<String>() );
		rawData.put( RecordKeys.OPEN, new ArrayList<String>() );
		rawData.put( RecordKeys.HIGH, new ArrayList<String>() );
		rawData.put( RecordKeys.LOW, new ArrayList<String>() );
		rawData.put( RecordKeys.CLOSE, new ArrayList<String>() );
		rawData.put( RecordKeys.VOLUME, new ArrayList<String>() );
		
		return rawData;
	}

}
