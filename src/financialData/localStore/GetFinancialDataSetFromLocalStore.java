package financialData.localStore;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * The object is the local store for FinancialDataSet. The store comprises of a HashMap.
 * @author James
 * @version 1.0
 * @since 26/07/2018
 */
public final class GetFinancialDataSetFromLocalStore {
	/** Maps a key (i.e. GBP_USD_HOUR) to its FinancialDataSet */
	private static HashMap <String, FinancialDataSet> financialDataSets = 
			  new HashMap <String, FinancialDataSet> (); 
	
	/**
	 * Checks whether FinancialDataSet is stored locally.
	 * @param key
	 * @return boolean
	 */
	public static boolean containsKey(String key) {
		return financialDataSets.containsKey(key);
	}
	
	/**
	 * Get a FinancialDataSet
	 * @param key
	 * @return FinancialDataSet
	 */
	public static FinancialDataSet getFinancialDataSet(String key) {
		return financialDataSets.get(key);
	}
	
	/**
	 * Update a FinancialDataSet. If set is not already stored it also creates the set.
	 * @param key
	 * @param date
	 * @param time
	 * @param open
	 * @param high
	 * @param low
	 * @param close
	 * @param ma3
	 * @param ma5
	 * @param ma10
	 * @param ma20
	 * @param ma50
	 * @param ma100
	 * @param ma200
	 * @param high3
	 * @param high5
	 * @param high10
	 * @param high20
	 * @param high50
	 * @param high100
	 * @param high200
	 * @param low3
	 * @param low5
	 * @param low10
	 * @param low20
	 * @param low50
	 * @param low100
	 * @param low200
	 * @param so3
	 * @param so5
	 * @param so10
	 * @param so20
	 * @param so50
	 * @param so100
	 * @param so200
	 * @param rsi3
	 * @param rsi5
	 * @param rsi10
	 * @param rsi20
	 * @param rsi50
	 * @param rsi100
	 * @param rsi200
	 * @param rs3
	 * @param rs5
	 * @param rs10
	 * @param rs20
	 * @param rs50
	 * @param rs100
	 * @param rs200
	 * @param volume
	 */
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
				   BigDecimal so3, BigDecimal so5, BigDecimal so10,
				   BigDecimal so20, BigDecimal so50, BigDecimal so100,
				   BigDecimal so200,
				   BigDecimal rsi3, BigDecimal rsi5, BigDecimal rsi10,
				   BigDecimal rsi20, BigDecimal rsi50, BigDecimal rsi100,
				   BigDecimal rsi200,
				   BigDecimal rs3, BigDecimal rs5, BigDecimal rs10,
				   BigDecimal rs20, BigDecimal rs50, BigDecimal rs100,
				   BigDecimal rs200,
				   BigDecimal volume ) {
		if( !containsKey(key) ) {
			financialDataSets.put(key, new FinancialDataSet() );
		}
		
		financialDataSets.
			get(key).
				addNewRecord(
						 date, time, open, high, low, close,
					     ma3, ma5, ma10, ma20, ma50, ma100, ma200, 
					     high3, high5, high10, high20, high50, high100, high200,
					     low3, low5, low10, low20, low50,  low100, low200,
					     so3, so5, so10, so20, so50, so100, so200,
					     rsi3, rsi5, rsi10, rsi20, rsi50, rsi100, rsi200,
					     rs3, rs5, rs10, rs20, rs50, rs100, rs200,
					     volume);
		
	}
}
