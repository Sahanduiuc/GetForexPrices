package financialData.localStore;

import java.math.BigDecimal;
import java.util.HashMap;

public final class GetFinancialDataSet {
	private static HashMap <String, FinancialDataSet> financialDataSets = 
			new HashMap <String, FinancialDataSet> (); 
	
	public static FinancialDataSet getFinancialDataSet(String key) {
		return financialDataSets.get(key);
	}
	public static boolean containsKey(String key) {
		return financialDataSets.containsKey(key);
	}
	public static void update( String key,
				   String date, String time, BigDecimal open, BigDecimal high, 
				   BigDecimal low, BigDecimal close, 
				   BigDecimal ma3, BigDecimal ma5, BigDecimal ma10, BigDecimal ma20, 
				   BigDecimal ma50, BigDecimal ma100, BigDecimal ma200,
				   BigDecimal volume ) {
		if( !containsKey(key) ) {
			financialDataSets.put(key, new FinancialDataSet() );
		}
		
		financialDataSets.get(key).
			addNewRecord(date, time, open, high, low, close,
					     ma3, ma5, ma10, ma20, ma50, ma100, ma200, volume);
		
	}
}
