package financialData.update.technicalIndicators.movingAverages;

import java.math.BigDecimal;

import financialData.update.technicalIndicators.data.GetLocalData;
import financialData.update.technicalIndicators.interfaces.TechnicalIndicator;

class MovingAverage implements TechnicalIndicator {
	private int sizeOfThisIndicator;
	
	private BigDecimal combinedTotal;
	
	private String datasetKey;
	private String attributeKey;
	
	MovingAverage( String datasetKey, String attributeKey, 
					int sizeOfThisIndicator, BigDecimal combinedTotal){
		this.combinedTotal = combinedTotal;
		this.sizeOfThisIndicator = sizeOfThisIndicator;
		this.datasetKey = datasetKey;
		this.attributeKey = attributeKey;
	}

	@Override
	public void update() {
		BigDecimal latestValue = GetLocalData.getValue(datasetKey, attributeKey);
		BigDecimal previousValue = GetLocalData.getValue(datasetKey, attributeKey, sizeOfThisIndicator);
		
		combinedTotal = combinedTotal.add(latestValue);
		combinedTotal = combinedTotal.subtract(previousValue);
	}

	@Override
	public BigDecimal getLatestValue() {
		return combinedTotal.divide( new BigDecimal(sizeOfThisIndicator), settings.Settings.MC );
	}

}
