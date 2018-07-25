package financialData;

import financialData.feed.FeedRawData;
import financialData.hardStore.GetDataFromDatabase;
import financialData.hardStore.csv.GetPricesFromCSV;
import financialData.localStore.FinancialDataSet;
import financialData.localStore.GetFinancialDataSet;

class SetupFinancialData {
	static FinancialDataSet getFinancialDataSet(String key) {
		if( GetFinancialDataSet.containsKey(key) ) {
			return GetFinancialDataSet.getFinancialDataSet(key);
		}
		else if( GetDataFromDatabase.containsKey(key) ) {
			
		}
		else {
			FeedRawData feed = new FeedRawData();
			feed.feedInRawData(key, GetPricesFromCSV.getPrices(key));
		}
		return GetFinancialDataSet.getFinancialDataSet(key);
	}
}
