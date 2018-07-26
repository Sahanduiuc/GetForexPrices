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
				   BigDecimal high3, BigDecimal high5, BigDecimal high10,
				   BigDecimal high20, BigDecimal high50, BigDecimal high100,
				   BigDecimal high200,
				   BigDecimal low3, BigDecimal low5, BigDecimal low10,
				   BigDecimal low20, BigDecimal low50, BigDecimal low100,
				   BigDecimal low200,
				   BigDecimal volume ) {
		if( !containsKey(key) ) {
			financialDataSets.put(key, new FinancialDataSet() );
		}
		
		financialDataSets.get(key).
			addNewRecord(date, time, open, high, low, close,
					     ma3, ma5, ma10, ma20, ma50, ma100, ma200, 
					     high3, high5, high10, high20, high50, 
					     high100, high200,
					     low3, low5, low10, low20, low50, 
					     low100, low200,
					     volume);
		
	}
}
