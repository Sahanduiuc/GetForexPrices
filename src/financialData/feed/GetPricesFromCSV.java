package financialData.feed;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
		fileToRead = "\\Resources\\Price_Sets\\" + fileToRead;
		
		InputStream in = GetPricesFromCSV.class.getResourceAsStream(fileToRead); 
		
		return new BufferedReader( new  InputStreamReader(in) );
	}

	/**
	 * This function translates a buffered reader into a String[][] to return
	 * @param  valuesToRead - a bufferedReader setup with a text file.
	 * @return String[][] returns the parsed ontents of the text file in String[row][column] 
	 * format.
	*/
	@SuppressWarnings("unchecked")
	private static HashMap <String, ArrayList <String> > setReturnValues(BufferedReader valuesToRead) {
		ArrayList <String> [] column;
		
		try {
			// To store the read columns from the data set
			column = new ArrayList [7]; 
			
			String currentLine = null;	
			while ( (currentLine = valuesToRead.readLine()) != null)
			{   
				String[] records = currentLine.split(",");
				
				for(int j = 0; j < records.length; j++) {
					column[j].add(records[j]);
				}
			}
			
			HashMap <String, ArrayList <String> > rawData = new HashMap <String, ArrayList<String>  > ();
			
			rawData.put( RecordKeys.DATE, column[RecordKeys.LOCATIONOFDATE] );
			rawData.put( RecordKeys.TIME, column[RecordKeys.LOCATIONOFTIME] );
			rawData.put( RecordKeys.OPEN, column[RecordKeys.LOCATIONOFOPEN] );
			rawData.put( RecordKeys.HIGH, column[RecordKeys.LOCATIONOFHIGH] );
			rawData.put( RecordKeys.LOW, column[RecordKeys.LOCATIONOFLOW] );
			rawData.put( RecordKeys.CLOSE, column[RecordKeys.LOCATIONOFCLOSE] );
			rawData.put( RecordKeys.VOLUME, column[RecordKeys.LOCATIONOFVOLUME] );
			
			return rawData;
		}
		catch(IOException exceptionDetails) {
			System.out.println("IOException in GetPricesFromCSV.setReturnValues");
			System.out.println(exceptionDetails);	
			return null;
		}		
	}

}
