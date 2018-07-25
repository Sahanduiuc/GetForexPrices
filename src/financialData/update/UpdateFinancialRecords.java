package financialData.update;

import java.math.BigDecimal;
import java.util.HashMap;

import financialData.localStore.GetFinancialDataSet;
import financialData.update.technicalIndicators.GetTechnicalIndicators;

public final class UpdateFinancialRecords {
	private static HashMap<String, GetTechnicalIndicators> getTechnicalIndicators = 
			new HashMap<String, GetTechnicalIndicators>();
	
	public static void setup(String key, String[] open, String[] high, 
									String[] low, String[] close) {
		if(!getTechnicalIndicators.containsKey(key)) {
			getTechnicalIndicators.put(key, new GetTechnicalIndicators());
		}
		
		getTechnicalIndicators.get(key).setup(key, open, high, low, close);
	}
	public static void update(String key, String date, String time, 
			String open, String high, String low, String close, String volume) {
		update(key, date, time, new BigDecimal(open), new BigDecimal(close), 
				new BigDecimal(low), new BigDecimal(close), new BigDecimal(volume));
	}
	
	public static void update(String key, String date, String time, 
			BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, BigDecimal volume) {
		if(getTechnicalIndicators.containsKey(key)) {
			GetFinancialDataSet.update(key, date, time, open, high, low, close);
		}
		else {
			System.out.println(key + " has not been setup");
		}
	}

}
