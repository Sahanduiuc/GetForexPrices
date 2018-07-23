package financialData;

import java.math.BigDecimal;

public class GetFinancialData {
	private static String currentDataSetKey;
	
	public static BigDecimal getFinancialRecord(String asset, String timeFrame, String attribute, int timePeriod) {
		String key = asset + "_" + timeFrame;
		
		if( !currentDataSetKey.equals(key) ) {
			changeCurrentDataset();
		}
		
		return null;
	}
	
	public static BigDecimal getFinancialRecord(String asset, String timeFrame, String attribute, String date) {
		String key = asset + "_" + timeFrame;
		
		if( !currentDataSetKey.equals(key) ) {
			changeCurrentDataset();
		}
		
		return null;
	}
	
	public static BigDecimal[] getFinancialRecords(String asset, String timeFrame, 
								String attribute, int startPeriod, int endPeriod) {
		String key = asset + "_" + timeFrame;
		
		if( !currentDataSetKey.equals(key) ) {
			changeCurrentDataset();
		}
		
		return null;
	}
	
	public static BigDecimal[] getFinancialRecords(String asset, String timeFrame, 
								String attribute, String startDate, String endDate) {
		String key = asset + "_" + timeFrame;
		
		if( !currentDataSetKey.equals(key) ) {
			changeCurrentDataset();
		}
		
		return null;
	}
	
	public static String getDate(String asset, String timeFrame, String attribute, int timePeriod) {
		String key = asset + "_" + timeFrame;
		
		if( !currentDataSetKey.equals(key) ) {
			changeCurrentDataset();
		}
		
		return null;
	}
	
	public static BigDecimal getTime(String asset, String timeFrame, String date) {
		String key = asset + "_" + timeFrame;
		
		if( !currentDataSetKey.equals(key) ) {
			changeCurrentDataset();
		}
		
		return null;
	}
	public static BigDecimal[] getTimes(String asset, String timeFrame, String date) {
		String key = asset + "_" + timeFrame;
		
		if( !currentDataSetKey.equals(key) ) {
			changeCurrentDataset();
		}
		
		return null;
	}
	
	public static BigDecimal[] getTimes(String asset, String timeFrame, int timePeriod) {
		String key = asset + "_" + timeFrame;
		
		if( !currentDataSetKey.equals(key) ) {
			changeCurrentDataset();
		}
		
		return null;
	}
	
	public static BigDecimal[] getDates(String asset, String timeFrame, 
										int startPeriod, int endPeriod) {
		String key = asset + "_" + timeFrame;
		
		if( !currentDataSetKey.equals(key) ) {
			changeCurrentDataset();
		}
		
		return null;
	}
	
	public static BigDecimal[] getAllDates(
					String asset, String timeFrame) {
		String key = asset + "_" + timeFrame;
		
		if( !currentDataSetKey.equals(key) ) {
			changeCurrentDataset();
		}
		
		return null;
	}
	
	
	
	private static void changeCurrentDataset() {
		
	}
}
