package financialData.update.technicalIndicators.highsAndLows;

import java.math.BigDecimal;

import financialData.update.technicalIndicators.data.GetLocalData;
import financialData.update.technicalIndicators.interfaces.TechnicalIndicators;

public class GetHighs implements TechnicalIndicators {
	private HighestNumber high3, high5, high10, high20, high50;
	private HighestNumber high100, high200;
	private String datasetKey;
	private PreviousHighNumbers previous5, previous10, previous50, previous100;
	
	@Override
	public void setup(String datasetKey, String attributeKey) {
		this.datasetKey = datasetKey;
		BigDecimal highestNumber = GetLocalData.getValue(datasetKey, getAttribute());
		int location = 0;
		
		int finishingPoint = settings.Settings.LARGESTTECHNICALINDICATOR ;
		for( int cnt = 1; cnt < finishingPoint; cnt++) {
			BigDecimal latestValue = GetLocalData.getValue(datasetKey, getAttribute(), cnt);
			
			if( isNum1BiggerThanNum2(latestValue, highestNumber) ) {
				highestNumber = latestValue;
				location = cnt;
			}
			
			switch(cnt) {
				case 2:
					high3 = new HighestNumber(highestNumber, location);
					break;
				case 4:
					high5 = new HighestNumber(highestNumber, location);
					previous5 = new PreviousHighNumbers(5);
					previous5.addRecord(high5);
					break;
				case 9:
					high10 = new HighestNumber(highestNumber, location);
					previous10 = new PreviousHighNumbers(10);
					previous10.addRecord(high10);
					break;
				case 19:
					high20 = new HighestNumber(highestNumber, location);
					break;
				case 49:
					high50 = new HighestNumber(highestNumber, location);
					previous50 = new PreviousHighNumbers(50);
					previous50.addRecord(high50);
					break;
				case 99:
					high100 = new HighestNumber(highestNumber, location);
					previous100 = new PreviousHighNumbers(100);
					previous100.addRecord(high100);
					break;
				case 199:
					high200 = new HighestNumber(highestNumber, location);
					break;
			}
		}
		
	}
	
	@Override
	public void update() {
		incrementLocations();
		
		BigDecimal latestValue = GetLocalData.getValue(datasetKey, getAttribute());
		
		high3 = checkHighNumber(high3, latestValue, 3);
		high5 = checkHighNumber(high5, latestValue, 5);
		
		if(previous5.isSetup) {
			high10 = checkHighNumber(high10, latestValue, 10, high5, previous5.getLastRecord());
		}
		else {
			high10 = checkHighNumber(high10, latestValue, 10);
		}
		
		if(previous10.isSetup) {
			high20 = checkHighNumber(high20, latestValue, 20, high10, previous10.getLastRecord());
		}
		else {
			high20 = checkHighNumber(high20, latestValue, 20);
		}
		
		high50 = checkHighNumber(high50, latestValue, 50);
		
		if(previous50.isSetup) {
			high100 = checkHighNumber(high100, latestValue, 100, high50, previous50.getLastRecord());
		}
		else {
			high100 = checkHighNumber(high100, latestValue, 100);
		}
		
		if(previous100.isSetup) {
			high200 = checkHighNumber(high200, latestValue, 200, high100, previous100.getLastRecord());
		}
		else {
			high200 = checkHighNumber(high200, latestValue, 200);
		}
		
		
		
		previous5.addRecord(high5);
		previous10.addRecord(high10);
		previous50.addRecord(high50);
		previous100.addRecord(high100);		
	}
	
	private HighestNumber checkHighNumber(HighestNumber currentHigh, BigDecimal latestNumber, int sizeOfIndicator) {
		if(isNum1BiggerThanNum2(latestNumber, currentHigh.valueOfHighestNumber)) {
			return new HighestNumber(latestNumber, 0);
		}
		else if(currentHigh.locationOfHighestNumber >= sizeOfIndicator) {
			return findHighestNumber(currentHigh.valueOfHighestNumber, sizeOfIndicator);
		}
		return currentHigh;
	}
	
	private HighestNumber checkHighNumber(HighestNumber currentHigh, BigDecimal latestNumber, int sizeOfIndicator,
											HighestNumber latestDenominatorHigh, HighestNumber previousDenominatorHigh) {
		if(isNum1BiggerThanNum2(latestNumber, currentHigh.valueOfHighestNumber)) {
			return new HighestNumber(latestNumber, 0);
		}
		else if(currentHigh.locationOfHighestNumber >= sizeOfIndicator) {
			if( isNum1BiggerThanNum2(latestDenominatorHigh.valueOfHighestNumber, 
									 previousDenominatorHigh.valueOfHighestNumber) ){
				return latestDenominatorHigh;
			}
			else {
				return previousDenominatorHigh;
			}
		}
		return currentHigh;
	}
	
	private HighestNumber findHighestNumber(BigDecimal highestNumber, int sizeOfIndicator) {
		int location = 0;
		
		for(int j = 1; j < sizeOfIndicator; j++) {
			BigDecimal latestValue = GetLocalData.getValue(datasetKey, getAttribute(), j);
			if(isNum1BiggerThanNum2(latestValue, highestNumber)) {
				highestNumber = latestValue;
				location = j;
			}
		}
		
		return new HighestNumber(highestNumber, location);
	}

	private void incrementLocations() {
		high3.locationOfHighestNumber++;
		high5.locationOfHighestNumber++;
		high10.locationOfHighestNumber++;
		high20.locationOfHighestNumber++;
		high50.locationOfHighestNumber++;
		high100.locationOfHighestNumber++;
		high200.locationOfHighestNumber++;
	}
	
	protected boolean isNum1BiggerThanNum2(BigDecimal num1, BigDecimal num2) {
		if( num1.compareTo(num2) > 0) {
			return true;
		} 
		return false;
	}
	
	protected String getAttribute() {
		return keys.RecordKeys.HIGH;
	}

	@Override
	public BigDecimal get3Period() {
		return high3.valueOfHighestNumber;
	}

	@Override
	public BigDecimal get5Period() {
		return high5.valueOfHighestNumber;
	}

	@Override
	public BigDecimal get10Period() {
		return high10.valueOfHighestNumber;
	}

	@Override
	public BigDecimal get20Period() {
		return high20.valueOfHighestNumber;
	}

	@Override
	public BigDecimal get50Period() {
		return high50.valueOfHighestNumber;
	}

	@Override
	public BigDecimal get100Period() {
		return high100.valueOfHighestNumber;
	}

	@Override
	public BigDecimal get200Period() {
		return high200.valueOfHighestNumber;
	}
	
	private class HighestNumber {
		private BigDecimal valueOfHighestNumber;
		private int locationOfHighestNumber;
		
		HighestNumber(BigDecimal valueOfHighestNumber, 
						    	int locationOfHighestNumber) {
			this.valueOfHighestNumber = valueOfHighestNumber;
			this.locationOfHighestNumber = locationOfHighestNumber;
		}	
	}
	
	private class PreviousHighNumbers{
		private int sizeOfIndicator;
		private HighestNumber[] previousNumbers;
		private boolean isSetup = false;
		private int currentLocation = -1;
		
		PreviousHighNumbers(int sizeOfIndicator){
			this.sizeOfIndicator = sizeOfIndicator;
			previousNumbers = new HighestNumber[sizeOfIndicator];
		}
		
		HighestNumber getLastRecord() {
			int location = currentLocation;
			if(location == ( sizeOfIndicator-1) ) {
				location = 0;
			}
			else {
				location++;
			}
			HighestNumber recordToReturn = previousNumbers[location];
			recordToReturn.locationOfHighestNumber += sizeOfIndicator;
			return recordToReturn;
		}
		
		void addRecord(HighestNumber newRecord) {
			currentLocation++;
			
			if(currentLocation == sizeOfIndicator) {
				if(!isSetup) {
					isSetup = true;
				}
				currentLocation = 0;
			}
			previousNumbers[currentLocation] = newRecord;
		}
	}

}
