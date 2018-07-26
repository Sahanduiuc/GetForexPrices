package financialData.update.technicalIndicators;

import java.math.BigDecimal;

import financialData.update.technicalIndicators.data.GetLocalData;
import financialData.update.technicalIndicators.highsAndLows.GetHighs;
import financialData.update.technicalIndicators.highsAndLows.GetLows;
import financialData.update.technicalIndicators.movingAverages.GetMovingAverages;
import financialData.update.technicalIndicators.relativeStrengthIndexs.GetRelativeStrengthIndexs;
import financialData.update.technicalIndicators.stochasticOscillators.GetStochasticOscillators;

public class GetTechnicalIndicators {
	private GetMovingAverages movingAverages = new GetMovingAverages();
	private GetRelativeStrengthIndexs rsis = new GetRelativeStrengthIndexs();
	private GetStochasticOscillators stochasticOscillators = new GetStochasticOscillators();
	private GetHighs highs = new GetHighs();
	private GetLows lows = new GetLows();
	
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
			highs.update();
			lows.update();
		}
	}
	
	private void setup(String key) {
		movingAverages.setup(key, keys.RecordKeys.OPEN);
		rsis.setup(key, keys.RecordKeys.OPEN);
		stochasticOscillators.setup(key, keys.RecordKeys.OPEN);
		highs.setup(key, keys.RecordKeys.OPEN);
		lows.setup(key, keys.RecordKeys.OPEN);
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
	public GetHighs getHighs() {
		return highs;
	}
	public GetLows getLows() {
		return lows;
	}
}
