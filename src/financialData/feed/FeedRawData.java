package financialData.feed;

import java.util.ArrayList;
import java.util.HashMap;

import financialData.update.UpdateFinancialRecords;
import keys.RecordKeys;
public class FeedRawData {
	private int sizeOfSetup = settings.Settings.LARGESTTECHNICALINDICATOR - 1;
	
	public void feedInRawData(String key, HashMap<String, ArrayList<String>> rawData) {
		setupUpdate(key, rawData);
		feed(key, rawData);
	}
	
	private void setupUpdate(String key, HashMap<String, ArrayList<String>> rawData) {
		String[] open = new String[sizeOfSetup]; 
		String[] high = new String[sizeOfSetup]; 
		String[] low = new String[sizeOfSetup]; 
		String[] close = new String[sizeOfSetup]; 
				
		for(int j = 0; j < sizeOfSetup; j++) {
			open[j] = rawData.get(RecordKeys.OPEN).get(j);
			high[j] = rawData.get(RecordKeys.HIGH).get(j);
			low[j] = rawData.get(RecordKeys.LOW).get(j);
			close[j] = rawData.get(RecordKeys.CLOSE).get(j);
		}
		
		UpdateFinancialRecords.setup(key, open, high, low, close);
	}
	
	private void feed(String key, HashMap<String, ArrayList<String>> rawData) {
		int sizeOfSet = rawData.get(keys.RecordKeys.OPEN).size();
		for(int j = sizeOfSetup; j < sizeOfSet; j++) {
			UpdateFinancialRecords.update(
					key,
					rawData.get(RecordKeys.DATE).get(j), 
					rawData.get(RecordKeys.TIME).get(j), 
					rawData.get(RecordKeys.OPEN).get(j), 
					rawData.get(RecordKeys.HIGH).get(j), 
					rawData.get(RecordKeys.LOW).get(j), 
					rawData.get(RecordKeys.CLOSE).get(j), 
					rawData.get(RecordKeys.VOLUME).get(j) );
		}
	}
}
