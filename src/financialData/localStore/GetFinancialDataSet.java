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
	public static void update(String key, String date, String time, 
			BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close) {
		if( !containsKey(key) ) {
			financialDataSets.put(key, new FinancialDataSet() );
		}
		
		financialDataSets.get(key).addNewRecord(date, time, open, high, low, close);
		
	}
}
