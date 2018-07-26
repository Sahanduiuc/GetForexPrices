package financialData.update.technicalIndicators.relativeStrengthIndexs;

import java.math.BigDecimal;

import financialData.update.technicalIndicators.data.GetLocalData;
import financialData.update.technicalIndicators.interfaces.TechnicalIndicator;

class RelativeStrengthIndex implements TechnicalIndicator{
	private BigDecimal combinedGains, combinedLosses;
	private int sizeOfThisIndicator;
	private String datasetKey;
	
	RelativeStrengthIndex(String datasetKey, int sizeOfThisIndicator,
							BigDecimal combinedGains, BigDecimal combinedLosses){
		this.datasetKey = datasetKey;
		this.sizeOfThisIndicator = sizeOfThisIndicator;
		this.combinedGains = combinedGains;
		this.combinedLosses = combinedLosses;
	}

	@Override
	public void update() {
		BigDecimal latestOpenValue = GetLocalData.getValue(datasetKey, keys.RecordKeys.OPEN);
		BigDecimal latestCloseValue = GetLocalData.getValue(datasetKey, keys.RecordKeys.CLOSE);
		BigDecimal latestGain = latestCloseValue.subtract(latestOpenValue);
		
		if( latestGain.compareTo( BigDecimal.ZERO ) > 0) {
			combinedGains = combinedGains.add(latestGain);
		}
		else {
			combinedLosses = combinedLosses.subtract(latestGain);
		}
		
		BigDecimal previousOpenValue = GetLocalData.getValue(datasetKey, keys.RecordKeys.OPEN, sizeOfThisIndicator);
		BigDecimal previousCloseValue = GetLocalData.getValue(datasetKey, keys.RecordKeys.CLOSE, sizeOfThisIndicator);
		BigDecimal previousGain = previousCloseValue.subtract(previousOpenValue);
		
		if( previousGain.compareTo( BigDecimal.ZERO ) > 0) {
			combinedGains = combinedGains.add(previousGain);
		}
		else {
			combinedLosses = combinedLosses.subtract(previousGain);
		}
	}

	@Override
	public BigDecimal getLatestValue() {
		BigDecimal oneHundred = new BigDecimal(100);
		BigDecimal bottom = new BigDecimal(1).add( getRelativeStrength() );
		BigDecimal answer = oneHundred.divide(bottom, settings.Settings.MC);
		return oneHundred.subtract(answer);
	}
	
	private BigDecimal getRelativeStrength() {
		if (combinedLosses.compareTo(BigDecimal.ZERO) == 0) {
			return new BigDecimal("0.00001");
		}
		if (combinedGains.compareTo(BigDecimal.ZERO) == 0) {
			return new BigDecimal("49");
		}
		
		return getAverageGains().divide(getAverageLosses(), settings.Settings.MC);
	}
	private BigDecimal getAverageGains() {
		return combinedGains.divide( new BigDecimal(sizeOfThisIndicator), settings.Settings.MC );
	}
	private BigDecimal getAverageLosses() {
		return combinedLosses.divide( new BigDecimal(sizeOfThisIndicator), settings.Settings.MC );
	}
	
}
