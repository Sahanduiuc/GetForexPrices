package financialData.update.technicalIndicators;

import java.math.BigDecimal;

import financialData.update.technicalIndicators.data.GetLocalData;
import financialData.update.technicalIndicators.movingAverages.GetMovingAverages;
import financialData.update.technicalIndicators.relativeStrengthIndexs.GetRelativeStrengthIndexs;
import financialData.update.technicalIndicators.stochasticOscillators.GetStochasticOscillators;

public class GetTechnicalIndicators {
	private GetMovingAverages movingAverages = new GetMovingAverages();
	private GetRelativeStrengthIndexs rsis = new GetRelativeStrengthIndexs();
	private GetStochasticOscillators stochasticOscillators;
	
	private boolean isSetup = false;
	
	public void setup(String key, String[] open, String[] high, 
												String[] low,  String[] close) {
		for(int j = 0; j < open.length; j++) {
			GetLocalData.update(key, open[j], high[j], low[j], close[j]);
		}
	}
	
	public void update(String key, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close) {
		GetLocalData.update(key, open, high, low, close);
		
		if(!isSetup) {
			setup(key);
		}
		else {
			movingAverages.update();
			rsis.update();
			stochasticOscillators.update();
		}
	}
	
	private void setup(String key) {
		movingAverages.setup(key, financialDataKeys.RecordKeys.OPEN);
		rsis.setup(key, financialDataKeys.RecordKeys.OPEN);
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
