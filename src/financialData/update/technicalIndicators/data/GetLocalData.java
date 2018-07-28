package financialData.update.technicalIndicators.data;

import java.math.BigDecimal;
import java.util.HashMap;

import keys.RecordKeys;

/**
 * This class is designed to store data for use with technical indicators. It stores the 
 * previous 200 values of open, close, high and low. This is so the technical indicators 
 * can update internally.<br><br>
 * 
 * GetLocalData is static so that individual technical indicators do not need an object 
 * sent to them, as this is heavy on storage.<br><br>
 * 
 * GetLocalData is a HashMap which stores a String to another HashMap. This first HashMap
 * uses the asset + time frame as a key (i.e. GBP_USD_HOUR).<br><br>
 * 
 * The second HashMap stores a String to a 'LocalDataSet'. The key in this case is the 
 * attribute, i.e. open, close, high, low. The LocalDataSet is just a set that stores the 
 * previous 200 values.<br><br>
 * 
 * This means to get data you send in three parameters:<br>
 * Asset+TimeFrame String for the first key.<br>
 * Attribute for the second key. <br>
 * Location is the final parameter.<br><br>
 * 
 * This leaves us with this: <br>
 * getValue("GBP_USD_HOUR", "Close", 0);<br>
 * Which would return the latest close value stored under GBP_USD_HOUR.<br><br>
 * 
 * To update, you need to send in all the attribute values of the latest record, 
 * plus the key for the dataset.<br><br>
 * 
 * This leaves us with this:<br>
 * update(String key, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close);<br><br>
 * 
 * <b>Please note</b><br>
 * The 'location' when retrieving values is how many periods away from the latest period you want 
 * to retrieve.<br>
 * I.e. 0 = latest value, 1 = value from 1 periods ago, 2 = values from 2 period ago etc.
 * 
 * @author James
 * @version 1.0
 * @since 28/07/2018
 */
public final class GetLocalData {
	/** Stores an asset + timeFrame key with the hashmap storing the attribute values */
	private static HashMap <String, HashMap<String, LocalDataSet>> localDataHashmap
			= new  HashMap<String, HashMap<String, LocalDataSet>>() ;
	
	/**
	 * Update LocalDataStore with new values. Send in the key, plus the open, high, low, close values
	 * and this will update the store with the latest values.<br><br>
	 * 
	 * <b>Please note:</b><br>
	 * If key is not present, it creates a new data-set to store.
	 * 
	 * @param key
	 * @param open
	 * @param high
	 * @param low
	 * @param close
	 */
	public static void update(String key, String open, String high, String low, String close) {
		update(key, new BigDecimal(open), new BigDecimal(high),
					new BigDecimal(low), new BigDecimal(close));		
	}
	
	/**
	 * Update LocalDataStore with new values. Send in the key, plus the open, high, low, close values
	 * and this will update the store with the latest values.<br><br>
	 * 
	 * <b>Please note:</b><br>
	 * If key is not present, it creates a new data-set to store.
	 * 
	 * @param key
	 * @param open
	 * @param high
	 * @param low
	 * @param close
	 */
	public static void update(String key, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close) {
		if( !localDataHashmap.containsKey(key) ) {
			addNewLocalDataSet(key);
		}
		
		HashMap<String, LocalDataSet> dataStoreHashMap = localDataHashmap.get(key);
		
		dataStoreHashMap.get(RecordKeys.OPEN).add(open);
		dataStoreHashMap.get(RecordKeys.HIGH).add(high);
		dataStoreHashMap.get(RecordKeys.LOW).add(low);
		dataStoreHashMap.get(RecordKeys.CLOSE).add(close);
	}
	
	/**
	 * Returns the latest value for 'attributeKey' - open, close, high, low - from 
	 * 'datasetKey' (GBP_USD_HOUR, GBP_EUR_DAY, etc..).
	 * @param datasetKey
	 * @param attributeKey
	 * @return value
	 */
	public static BigDecimal getValue(String datasetKey, String attributeKey) {
		return localDataHashmap.get(datasetKey).get(attributeKey).getRecord();
	}
	
	/**
	 * Returns the value for 'attributeKey' - open, close, high, low - from 
	 * 'datasetKey' (GBP_USD_HOUR, GBP_EUR_DAY, etc..) at 'periodsAgo'.<br><br>
	 * 
	 * If periodsAgo = 0, sends back latest value.<br>
	 * If periodsAgo = 1, sends back value requested from 1 period ago.<br>
	 * If periodsAgo = 10, sends back value requested from 10 period ago.<br>
	 * 
	 * @param datasetKey
	 * @param attributeKey
	 * @param periodsAgo
	 * @return
	 */
	public static BigDecimal getValue(String datasetKey, String attributeKey, int periodsAgo) {
		return localDataHashmap.get(datasetKey).get(attributeKey).getRecord(periodsAgo);
	}
	
	/**
	 * Creates a new LocalDataSet.
	 * @param key
	 */
	private static void addNewLocalDataSet(String key) {
		HashMap<String, LocalDataSet> dataStoreHashMap = new HashMap<String, LocalDataSet>();
		
		dataStoreHashMap.put( RecordKeys.OPEN, new LocalDataSet() );
		dataStoreHashMap.put( RecordKeys.HIGH, new LocalDataSet() );
		dataStoreHashMap.put( RecordKeys.LOW, new LocalDataSet() );
		dataStoreHashMap.put( RecordKeys.CLOSE, new LocalDataSet() );
		
		localDataHashmap.put(key, dataStoreHashMap);
	}
}
