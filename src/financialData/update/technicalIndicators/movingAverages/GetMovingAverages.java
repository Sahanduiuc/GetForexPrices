package financialData.update.technicalIndicators.movingAverages;

import java.math.BigDecimal;

import financialData.update.technicalIndicators.data.GetLocalData;
import financialData.update.technicalIndicators.interfaces.TechnicalIndicators;

public class GetMovingAverages implements TechnicalIndicators {
	private MovingAverage ma3, ma5, ma10, ma20, ma50, ma100, ma200;
	
	@Override
	public void setup(String datasetKey, String attributeKey) {
		int largestMovingAverage = settings.Settings.LARGESTTECHNICALINDICATOR;
		BigDecimal combinedTotal = new BigDecimal(0);
		
		for(int j = 0; j < largestMovingAverage; j++) {
			BigDecimal latestValue = GetLocalData.getValue(datasetKey, attributeKey, j);
			combinedTotal = combinedTotal.add(latestValue);
			
			switch(j) {
				case 2:
					ma3 = new MovingAverage(datasetKey, attributeKey, 3, combinedTotal);
					break;
				case 4:
					ma5 = new MovingAverage(datasetKey, attributeKey, 5, combinedTotal);
					break;
				case 9:
					ma10 = new MovingAverage(datasetKey, attributeKey, 10, combinedTotal);
					break;
				case 19:
					ma20 = new MovingAverage(datasetKey, attributeKey, 20, combinedTotal);
					break;
				case 49:
					ma50 = new MovingAverage(datasetKey, attributeKey, 50, combinedTotal);
					break;
				case 99:
					ma100 = new MovingAverage(datasetKey, attributeKey, 100, combinedTotal);
					break;
				case 199:
					ma200 = new MovingAverage(datasetKey, attributeKey, 200, combinedTotal);
					break;
			}
			
		}
	}
	
	@Override
	public void update() {
		ma3.update();
		ma5.update();
		ma10.update();
		ma20.update();
		ma50.update();
		ma100.update();
		ma200.update();		
	}

	@Override
	public BigDecimal get3Period() {
		return ma3.getLatestValue();
	}

	@Override
	public BigDecimal get5Period() {
		return ma5.getLatestValue();
	}

	@Override
	public BigDecimal get10Period() {
		return ma10.getLatestValue();
	}

	@Override
	public BigDecimal get20Period() {
		return ma20.getLatestValue();
	}

	@Override
	public BigDecimal get50Period() {
		return ma50.getLatestValue();
	}

	@Override
	public BigDecimal get100Period() {
		return ma100.getLatestValue();
	}

	@Override
	public BigDecimal get200Period() {
		return ma200.getLatestValue();
	}
}
