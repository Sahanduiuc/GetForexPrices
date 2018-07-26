package financialData;

import java.math.BigDecimal;

import financialData.feed.FeedRawData;
import financialData.hardStore.GetDataFromDatabase;
import financialData.hardStore.csv.GetPricesFromCSV;
import financialData.localStore.FinancialDataSet;
import financialData.localStore.GetFinancialDataSetFromLocalStore;

/**
 * Object to get financial data.
 * @author James
 * @version 1.0
 * @since 26/07/2018
 */
public class GetFinancialData {
	/** The key for the current data set */
	private static String currentDataSetKey = "";
	/** The current data set */
	private static FinancialDataSet currentFinancialDataSet;
	
	/**
	 * Returns a specified financial record.<br><br>
	 * 
	 * <b>Example</b><br>
	 * <i>asset:</i> GBPUSD<br>
	 * <i>timeFrame:</i> HOUR<br>
	 * <i>attribute:</i> OPEN<br>
	 * <i>timePeriod:</i> 0<br><br>
	 * 
	 * Would return the open price for GBPUSD hour for the first record held.
	 * @param asset
	 * @param timeFrame
	 * @param attribute
	 * @param timePeriod
	 * @return financial record
	 */
	public static BigDecimal getFinancialRecord(String asset, String timeFrame, String attribute, int timePeriod) {
		checkIfDatasetNeedsChanging(asset, timeFrame);
		return currentFinancialDataSet.getRecord(attribute, timePeriod);
	}
	
	/**
	 * Returns a specified financial record.<br><br>
	 * 
	 * <b>Example</b><br>
	 * <i>asset:</i> GBPUSD<br>
	 * <i>timeFrame:</i> DAY<br>
	 * <i>attribute:</i> OPEN<br>
	 * <i>date:</i> 01/03/2005 <br><br>
	 * 
	 * Would return the open price for GBPUSD on the 01/03/2005
	 * @param asset
	 * @param timeFrame
	 * @param attribute
	 * @param timePeriod
	 * @return financial record
	 */
	public static BigDecimal getFinancialRecord(String asset, String timeFrame, String attribute, String date) {
		checkIfDatasetNeedsChanging(asset, timeFrame);
		
		return null;
	}
	
	/**
	 * Returns financial records between start-period and end-period.<br><br>
	 * 
	 * <b>Example</b><br>
	 * <i>asset:</i> GBPUSD<br>
	 * <i>timeFrame:</i> DAY<br>
	 * <i>attribute:</i> OPEN<br>
	 * <i>startPeriod:</i> 0<br><br>
	 * <i>finishPeriod:</i> 1000<br><br>
	 * 
	 * Would return the open prices for GBPUSD day between the first record and the
	 * 1001 record (INCLUSIVE OF BOTH).
	 * 
	 * @param asset
	 * @param timeFrame
	 * @param attribute
	 * @param startPeriod
	 * @param endPeriod
	 * @return financial records
	 */
	public static BigDecimal[] getFinancialRecords(String asset, String timeFrame, 
								String attribute, int startPeriod, int endPeriod) {
		checkIfDatasetNeedsChanging(asset, timeFrame);
		
		return null;
	}
	
	/**
	 * Returns financial records between start-date and end-date.<br><br>
	 * 
	 * <b>Example</b><br>
	 * <i>asset:</i> GBPUSD<br>
	 * <i>timeFrame:</i> DAY<br>
	 * <i>attribute:</i> OPEN<br>
	 * <i>startDate:</i> 01/03/2005 <br><br>
	 * <i>finishDate:</i> 01/03/2006 <br><br>
	 * 
	 * Would return the open prices for GBPUSD day between 01/03/2005 and 01/03/2006 
	 * (INCLUSIVE OF BOTH).
	 * 
	 * @param asset
	 * @param timeFrame
	 * @param attribute
	 * @param startDate
	 * @param endDate
	 * @return financial record
	 */
	public static BigDecimal[] getFinancialRecords(String asset, String timeFrame, 
								String attribute, String startDate, String endDate) {
		checkIfDatasetNeedsChanging(asset, timeFrame);
		
		return null;
	}
	
	/**
	 * Returns the date held.<br><br>
	 * 
	 * <b>Example</b><br>
	 * <i>asset:</i> GBPUSD<br>
	 * <i>timeFrame:</i> DAY<br>
	 * <i>timePeriod:</i> 0<br><br>
	 * 
	 * Returns the date of the first record for GBPUSD day.
	 * 
	 * @param asset
	 * @param timeFrame
	 * @param timePeriod
	 * @return date
	 */
	public static String getDate(String asset, String timeFrame, int timePeriod) {
		checkIfDatasetNeedsChanging(asset, timeFrame);
		
		return currentFinancialDataSet.getDate(timePeriod);
	}
	
	/**
	 * Returns the time held.<br><br>
	 * 
	 * <b>Example</b><br>
	 * <i>asset:</i> GBPUSD<br>
	 * <i>timeFrame:</i> DAY<br>
	 * <i>timePeriod:</i> 0<br><br>
	 * 
	 * Returns the time of the first record for GBPUSD day.
	 * 
	 * @param asset
	 * @param timeFrame
	 * @param timePeriod
	 * @return time
	 */
	public static String getTime(String asset, String timeFrame, int timePeriod) {
		checkIfDatasetNeedsChanging(asset, timeFrame);
		
		return currentFinancialDataSet.getTime(timePeriod);
	}
	
	/**
	 * Returns the dates held between start period and end period.<br><br>
	 * 
	 * <b>Example<b><br>
	 * <i>asset:</i> GBPUSD </i>
	 * <i>timeFrame:</i> DAY </i>
	 * <i>startPeriod:</i> 0 </i>
	 * <i>endPeriod:</i> 1000 </i>
	 * 
	 * Returns all the dates for GBPUSD day between the 1st and the 1001st record
	 * (INCLUSIVE).
	 * 
	 * @param asset
	 * @param timeFrame
	 * @param startPeriod
	 * @param endPeriod
	 * @return dates held
	 */
	public static BigDecimal[] getDates(String asset, String timeFrame, 
										int startPeriod, int endPeriod) {
		checkIfDatasetNeedsChanging(asset, timeFrame);
		return null;
	}
	
	/**
	 * Returns all dates held under the selected asset and time frame.
	 * @param asset
	 * @param timeFrame
	 * @return All dates held
	 */
	public static BigDecimal[] getAllDates(String asset, String timeFrame) {
		checkIfDatasetNeedsChanging(asset, timeFrame);
		
		return null;
	}
	
	/**
	 * Checks if the currently stored financial data set is correct for the query. 
	 * @param asset
	 * @param timeFrame
	 */
	private static void checkIfDatasetNeedsChanging(String asset, String timeFrame) {
		String key = asset + "_" + timeFrame;
		
		if( !currentDataSetKey.equals(key) ) {
			currentFinancialDataSet = getFinancialDataSet(key);
			currentDataSetKey = key;
		}
	}
	
	/**
	 * Sets up a new financial data set to store.
	 * @param key
	 * @return FinancialDataSet
	 */
	private static FinancialDataSet getFinancialDataSet(String key) {
		if( GetFinancialDataSetFromLocalStore.containsKey(key) ) {
			return GetFinancialDataSetFromLocalStore.getFinancialDataSet(key);
		}
		else if( GetDataFromDatabase.containsKey(key) ) {
			
		}
		else {
			FeedRawData feed = new FeedRawData();
			feed.feedInRawData(key, GetPricesFromCSV.getPrices(key));
		}
		return GetFinancialDataSetFromLocalStore.getFinancialDataSet(key);
	}
	
}
