package financialData.update.technicalIndicators;

import financialData.update.technicalIndicators.data.GetLocalData;
import financialData.update.technicalIndicators.movingAverages.GetMovingAverages;
import financialData.update.technicalIndicators.relativeStrengthIndexs.GetRelativeStrengthIndexs;
import financialData.update.technicalIndicators.stochasticOscillators.GetStochasticOscillators;

public class GetTechnicalIndicators {
	private GetMovingAverages movingAverages;
	private GetRelativeStrengthIndexs rsis;
	private GetStochasticOscillators stochasticOscillators;
	
	public void setup(String key, String[] open, String[] high, 
												String[] low,  String[] close) {
		for(int j = 0; j < open.length; j++) {
			GetLocalData.update(key, open[j], high[j], low[j], close[j]);
		}
	}
	
	public void update() {
		
	}
	
	public GetMovingAverages getMovingAverages() {
		return movingAverages;
	}
	public GetRelativeStrengthIndexs getRSIs() {
		return rsis;
	}
	public GetStochasticOscillators getStochasticOscillators() {
		return stochasticOscillators;
	}
}
