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
		update(key, date, time, new BigDecimal(open), new BigDecimal(high), 
				new BigDecimal(low), new BigDecimal(close), new BigDecimal(volume));
	}
	
	public static void update(String key, String date, String time, 
			BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, BigDecimal volume) {
		if( getTechnicalIndicators.containsKey(key) ) {
			GetTechnicalIndicators technicalIndicators = getTechnicalIndicators.get(key); 
			
			technicalIndicators.update(key, open, high, low, close);
			
			GetFinancialDataSet.update(
					key, 
					date, 
					time, 
					open, 
					high, 
					low, 
					close,
					technicalIndicators.getMovingAverages().get3Period(),
					technicalIndicators.getMovingAverages().get5Period(),
					technicalIndicators.getMovingAverages().get10Period(),
					technicalIndicators.getMovingAverages().get20Period(),
					technicalIndicators.getMovingAverages().get50Period(),
					technicalIndicators.getMovingAverages().get100Period(),
					technicalIndicators.getMovingAverages().get200Period(),
					technicalIndicators.getHighs().get3Period(),
					technicalIndicators.getHighs().get5Period(),
					technicalIndicators.getHighs().get10Period(),
					technicalIndicators.getHighs().get20Period(),
					technicalIndicators.getHighs().get50Period(),
					technicalIndicators.getHighs().get100Period(),
					technicalIndicators.getHighs().get200Period(),
					technicalIndicators.getLows().get3Period(),
					technicalIndicators.getLows().get5Period(),
					technicalIndicators.getLows().get10Period(),
					technicalIndicators.getLows().get20Period(),
					technicalIndicators.getLows().get50Period(),
					technicalIndicators.getLows().get100Period(),
					technicalIndicators.getLows().get200Period(),
					technicalIndicators.getStochasticOscillators().get3Period(),
					technicalIndicators.getStochasticOscillators().get5Period(),
					technicalIndicators.getStochasticOscillators().get10Period(),
					technicalIndicators.getStochasticOscillators().get20Period(),
					technicalIndicators.getStochasticOscillators().get50Period(),
					technicalIndicators.getStochasticOscillators().get100Period(),
					technicalIndicators.getStochasticOscillators().get200Period(),
					technicalIndicators.getRSIs().get3Period(),
					technicalIndicators.getRSIs().get5Period(),
					technicalIndicators.getRSIs().get10Period(),
					technicalIndicators.getRSIs().get20Period(),
					technicalIndicators.getRSIs().get50Period(),
					technicalIndicators.getRSIs().get100Period(),
					technicalIndicators.getRSIs().get200Period(),
					technicalIndicators.getRegressionSlopes().get3Period(),
					technicalIndicators.getRegressionSlopes().get5Period(),
					technicalIndicators.getRegressionSlopes().get10Period(),
					technicalIndicators.getRegressionSlopes().get20Period(),
					technicalIndicators.getRegressionSlopes().get50Period(),
					technicalIndicators.getRegressionSlopes().get100Period(),
					technicalIndicators.getRegressionSlopes().get200Period(),
					volume);
			
			System.out.println("RSI3 " + technicalIndicators.getRSIs().get3Period() +
					" SO3 " + technicalIndicators.getStochasticOscillators().get3Period() +
					" RS3 " + technicalIndicators.getRegressionSlopes().get3Period());
		}
		else {
			System.out.println(key + " has not been setup");
		}
	}

}
