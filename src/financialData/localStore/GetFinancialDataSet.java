package financialData.localStore;

import java.util.HashMap;

public final class GetFinancialDataSet {
	private static HashMap <String, FinancialDataSet> financialDataSets = 
			new HashMap <String, FinancialDataSet> (); 
	
	public FinancialDataSet getFinancialDataSet(String key) {
		return financialDataSets.get(key);
	}
	public boolean containsKey(String key) {
		return financialDataSets.containsKey(key);
	}
}
