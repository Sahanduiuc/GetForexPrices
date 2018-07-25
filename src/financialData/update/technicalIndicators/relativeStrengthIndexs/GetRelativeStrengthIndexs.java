package financialData.update.technicalIndicators.relativeStrengthIndexs;

import java.math.BigDecimal;

import financialData.update.technicalIndicators.data.GetLocalData;
import financialData.update.technicalIndicators.interfaces.TechnicalIndicators;

public class GetRelativeStrengthIndexs implements TechnicalIndicators {
	private RelativeStrengthIndex rsi3, rsi5, rsi10, rsi20, rsi50, rsi100, rsi200;
	
	
	@Override
	public void setup(String datasetKey, String attributeKey) {
		int largestMovingAverage = settings.Settings.LARGESTTECHNICALINDICATOR;
		
		BigDecimal combinedGains = new BigDecimal(0);
		BigDecimal combinedLosses = new BigDecimal(0);
		
		for(int j = 0; j < largestMovingAverage; j++) {
			BigDecimal openValue = GetLocalData.getValue(datasetKey, financialDataKeys.RecordKeys.OPEN, j);
			BigDecimal closeValue = GetLocalData.getValue(datasetKey, financialDataKeys.RecordKeys.CLOSE, j);
			
			BigDecimal gain = closeValue.subtract(openValue);
			
			if( gain.compareTo( new BigDecimal(0) ) > 0) {
				combinedGains = combinedGains.add(gain);
			}
			else {
				combinedLosses = combinedLosses.subtract(gain);
			}
			
			switch(j) {
				case 2:
					rsi3 = new RelativeStrengthIndex(datasetKey, 3, combinedGains, combinedLosses);
					break;
				case 4:
					rsi5 = new RelativeStrengthIndex(datasetKey, 5, combinedGains, combinedLosses);
					break;
				case 9:
					rsi10 = new RelativeStrengthIndex(datasetKey, 10, combinedGains, combinedLosses);
					break;
				case 19:
					rsi20 = new RelativeStrengthIndex(datasetKey, 20, combinedGains, combinedLosses);
					break;
				case 49:
					rsi50 = new RelativeStrengthIndex(datasetKey, 50, combinedGains, combinedLosses);
					break;
				case 99:
					rsi100 = new RelativeStrengthIndex(datasetKey, 100, combinedGains, combinedLosses);
					break;
				case 199:
					rsi200 = new RelativeStrengthIndex(datasetKey, 200, combinedGains, combinedLosses);
					break;
			}
		}
	}
	@Override
	public void update() {
		rsi3.update();
		rsi5.update();
		rsi10.update();
		rsi20.update();
		rsi50.update();
		rsi100.update();
		rsi200.update();
	}

	@Override
	public BigDecimal get3Period() {
		return rsi3.getLatestValue();
	}

	@Override
	public BigDecimal get5Period() {
		return rsi5.getLatestValue();
	}

	@Override
	public BigDecimal get10Period() {
		return rsi10.getLatestValue();
	}

	@Override
	public BigDecimal get20Period() {
		return rsi20.getLatestValue();
	}

	@Override
	public BigDecimal get50Period() {
		return rsi50.getLatestValue();
	}

	@Override
	public BigDecimal get100Period() {
		return rsi100.getLatestValue();
	}

	@Override
	public BigDecimal get200Period() {
		return rsi200.getLatestValue();
	}
}
