package financialData.update.technicalIndicators.highsAndLows;

import java.math.BigDecimal;

import financialData.update.technicalIndicators.data.GetLocalData;
import financialData.update.technicalIndicators.interfaces.TechnicalIndicators;

public class GetHighs implements TechnicalIndicators {
	private HighestNumber high3, high5, high10, high20, high50;
	private HighestNumber high100, high200;
	
	@Override
	public void setup(String datasetKey, String attributeKey) {
		BigDecimal highestNumber = GetLocalData.getValue(datasetKey, getAttribute());
		int location = 0;
		
		int finishingPoint = settings.Settings.LARGESTTECHNICALINDICATOR - 1;
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
					break;
				case 9:
					high10 = new HighestNumber(highestNumber, location);
					break;
				case 19:
					high20 = new HighestNumber(highestNumber, location);
					break;
				case 49:
					high50 = new HighestNumber(highestNumber, location);
					break;
				case 99:
					high100 = new HighestNumber(highestNumber, location);
					break;
				case 199:
					high200 = new HighestNumber(highestNumber, location);
					break;
			}
		}
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	
	
	protected boolean isNum1BiggerThanNum2(BigDecimal num1, BigDecimal num2) {
		if( num1.compareTo(num2) > 0) {
			return true;
		} 
		return false;
	}
	
	protected String getAttribute() {
		return financialDataKeys.RecordKeys.HIGH;
	}

	@Override
	public BigDecimal get3Period() {
		return high3.getHighestNumber();
	}

	@Override
	public BigDecimal get5Period() {
		return high5.getHighestNumber();
	}

	@Override
	public BigDecimal get10Period() {
		return high10.getHighestNumber();
	}

	@Override
	public BigDecimal get20Period() {
		return high20.getHighestNumber();
	}

	@Override
	public BigDecimal get50Period() {
		return high50.getHighestNumber();
	}

	@Override
	public BigDecimal get100Period() {
		return high100.getHighestNumber();
	}

	@Override
	public BigDecimal get200Period() {
		return high200.getHighestNumber();
	}
	
	private class HighestNumber {
		private BigDecimal valueOfHighestNumber;
		private int locationOfHighestNumber;
		
		HighestNumber(BigDecimal valueOfHighestNumber, 
						    	int locationOfHighestNumber) {
			this.valueOfHighestNumber = valueOfHighestNumber;
			this.locationOfHighestNumber = locationOfHighestNumber;
		}
		
		BigDecimal getHighestNumber() {
			return valueOfHighestNumber;
		}
		
		int getLocationOfNum() {
			return locationOfHighestNumber;
		}
	}

}
