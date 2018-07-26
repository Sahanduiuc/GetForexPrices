package financialData.update.technicalIndicators.data;

import java.math.BigDecimal;
import java.util.HashMap;

import keys.RecordKeys;

public class GetLocalData {
	private static HashMap <String, HashMap<String, LocalDataSet>> localDataHashmap
			= new  HashMap<String, HashMap<String, LocalDataSet>>() ;
	
	public static void update(String key, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close) {
		if( !localDataHashmap.containsKey(key) ) {
			addNewDataSet(key);
		}
		
		HashMap<String, LocalDataSet> dataStoreHashMap = localDataHashmap.get(key);
		
		dataStoreHashMap.get(RecordKeys.OPEN).add(open);
		dataStoreHashMap.get(RecordKeys.HIGH).add(high);
		dataStoreHashMap.get(RecordKeys.LOW).add(low);
		dataStoreHashMap.get(RecordKeys.CLOSE).add(close);
	}
	
	public static void update(String key, String open, String high, String low, String close) {
		update(key, new BigDecimal(open), new BigDecimal(high),
					new BigDecimal(low), new BigDecimal(close));		
	}
	
	public static BigDecimal getValue(String datasetKey, String attributeKey) {
		return localDataHashmap.get(datasetKey).get(attributeKey).getRecord();
	}
	
	public static BigDecimal getValue(String datasetKey, String attributeKey, int location) {
		return localDataHashmap.get(datasetKey).get(attributeKey).getRecord(location);
	}
	
	private static void addNewDataSet(String key) {
		HashMap<String, LocalDataSet> dataStoreHashMap = new HashMap<String, LocalDataSet>();
		
		dataStoreHashMap.put( RecordKeys.OPEN, new LocalDataSet() );
		dataStoreHashMap.put( RecordKeys.HIGH, new LocalDataSet() );
		dataStoreHashMap.put( RecordKeys.LOW, new LocalDataSet() );
		dataStoreHashMap.put( RecordKeys.CLOSE, new LocalDataSet() );
		
		localDataHashmap.put(key, dataStoreHashMap);
	}
	

	
}
