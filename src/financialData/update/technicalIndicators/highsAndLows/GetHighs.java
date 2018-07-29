package financialData.update.technicalIndicators.highsAndLows;

import java.math.BigDecimal;

import financialData.update.technicalIndicators.data.GetLocalData;
import financialData.update.technicalIndicators.interfaces.TechnicalIndicators;

/**
 * This object finds the highest number from 3, 5, 10, 20, 50, 100 and 200 
 * periods ago.<br><br>
 * 
 * It works this way.<br>
 * 1) On setup it finds the highest number for all the periods and stores 
 * these details.<br>
 * 2) After that when a new value is added to GetLocalData(), it checks 
 * whether the new value is higher than the current high number stored. If
 * so it stores this as the new high number. If not it checks how many periods 
 * ago the current high number is stored. <br>
 * So for 50-period high, if the location of the high after the  new value is added, 
 * is now 51 periods ago this object will have to refind the highest high. <br>
 * 3) To speed this process up, we store previous high numbers. So for example if
 * we need to research for the ten day high, we can take the latest 5-period high, 
 * and the 5-period high from 5 periods ago and see which is larger to store in the 
 * 10 period high. Rather than having to search over all of the 10 period highs.<br>
 * 
 * @author James
 * @version 1.0
 * @since 28/07/2018
 *
 */
public class GetHighs implements TechnicalIndicators {
	/** Current highest values */
	private HighestNumber high3, high5, high10, high20, high50, high100, high200;
	/** Previous high numbers - stored to speed up high value search */
	private PreviousHighNumbers previous5, previous10, previous50, previous100;
	/** Key to get the correct data-set from GetLocalData() */
	private String datasetKey;
	
	@Override
	public void setup(String datasetKey, String attributeKey) {
		this.datasetKey = datasetKey;
		
		BigDecimal currentHighestNumber = GetLocalData.getValue(datasetKey, getAttribute());
		int currentLocationOfHigh = 0;

		for( int cnt = 1; cnt < settings.Settings.LARGESTTECHNICALINDICATOR ; cnt++) {
			BigDecimal latestValue = GetLocalData.getValue(datasetKey, getAttribute(), cnt);
			
			if( isNum1BiggerThanNum2(latestValue, currentHighestNumber) ) {
				currentHighestNumber = latestValue;
				currentLocationOfHigh = cnt;
			}
			
			switch(cnt) {
				case 2:
					high3 = new HighestNumber(currentHighestNumber, currentLocationOfHigh);
					break;
				case 4:
					high5 = new HighestNumber(currentHighestNumber, currentLocationOfHigh);
					previous5 = new PreviousHighNumbers(5);
					previous5.addRecord(high5);
					break;
				case 9:
					high10 = new HighestNumber(currentHighestNumber, currentLocationOfHigh);
					previous10 = new PreviousHighNumbers(10);
					previous10.addRecord(high10);
					break;
				case 19:
					high20 = new HighestNumber(currentHighestNumber, currentLocationOfHigh);
					break;
				case 49:
					high50 = new HighestNumber(currentHighestNumber, currentLocationOfHigh);
					previous50 = new PreviousHighNumbers(50);
					previous50.addRecord(high50);
					break;
				case 99:
					high100 = new HighestNumber(currentHighestNumber, currentLocationOfHigh);
					previous100 = new PreviousHighNumbers(100);
					previous100.addRecord(high100);
					break;
				case 199:
					high200 = new HighestNumber(currentHighestNumber, currentLocationOfHigh);
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
		high10 = checkHighNumber(high10, latestValue, 10, high5, previous5);
		high20 = checkHighNumber(high20, latestValue, 20, high10, previous10);
		high50 = checkHighNumber(high50, latestValue, 50);
		high100 = checkHighNumber(high100, latestValue, 100, high50, previous50);
		high200 = checkHighNumber(high200, latestValue, 200, high100, previous100);
		
		/** Previous records do need to be added here... DO NOT TOUCH. */
		previous5.addRecord(high5);
		previous10.addRecord(high10);
		previous50.addRecord(high50);
		previous100.addRecord(high100);		
	}
	
	/**
	 * Checks whether the highest number needs to be changed, without the use of 
	 * previous highs from a denominator.<br><br>
	 *
	 * Send in the currentHigh, latestValue and the sizeOfTheIndicator.<br>
	 * This will check if the latestValue is higher than the highestHigh, and
	 * if so will set this to the highestHigh.<br>
	 * If not, will check if the current high is further away than the size of this 
	 * indicator, i.e. if this is for the 5 period high and the location of the high 
	 * stored is now 6 periods away it will then call findHighestHigh to find the
	 * highest number and return that.<br>
	 * If none of the conditions are met, i.e. the highest high isn't too far away, 
	 * and the latestValue isn't higher than the highestHigh, than it simply returns
	 * the highestHigh sent in.
	 * 
	 * @param currentHigh
	 * @param latestValue
	 * @param sizeOfIndicator
	 * @return highestHigh
	 */
	private HighestNumber checkHighNumber(HighestNumber currentHigh, BigDecimal latestValue, int sizeOfIndicator) {
		if( isNum1BiggerThanNum2(latestValue, currentHigh.valueOfHighestNumber) ) {
			return new HighestNumber(latestValue, 0);
		}
		else if( currentHigh.locationOfHighestNumber >= sizeOfIndicator ) {
			return findHighestNumber(latestValue, sizeOfIndicator);
		}
		
		return currentHigh;
	}
	
	/**
	 * Checks for the highestHigh and makes use of a denominator to speed up the search process.<br><br>
	 * 
	 * If the previous denominator is setup, it calls checkHighNumber with previous denominator setup.
	 * Else it calls the stand checkHighNumber.
	 * 
	 * @param currentHigh
	 * @param latestValue
	 * @param sizeOfIndicator
	 * @param latestDenominatorHigh
	 * @param previousDenominatorHighs
	 * @return highestHigh
	 */
	private HighestNumber checkHighNumber(HighestNumber currentHigh, BigDecimal latestValue, int sizeOfIndicator,
							HighestNumber latestDenominatorHigh, PreviousHighNumbers previousDenominatorHighs ) {
		if(previousDenominatorHighs.isSetup) {
			return checkHighNumber(currentHigh, latestValue, sizeOfIndicator, latestDenominatorHigh, previousDenominatorHighs.getLastRecord());
		}
	
		return checkHighNumber(currentHigh, latestValue, sizeOfIndicator);
	}
	
	/**
	 * Checks for the highestHigh when using a lower denominator to speed up the search process.<br><br>
	 * 
	 * Firstly, will check if the latestValue is higher than the highestHigh, and
	 * if so will set this to the highestHigh.<br><br>
	 * If not, will check if the current high is further away than the size of this 
	 * indicator, i.e. if this is for the 5 period high and the location of the high 
	 * stored is now 6 periods away.<br>
	 * If it is will check which number is higher out of the latestDenominatorHigh, and the previousDenominatorHigh
	 * and return that.<br>
	 * If not it will return the currentHighestHigh. 
	 * 
	 * @param currentHigh
	 * @param latestNumber
	 * @param sizeOfIndicator
	 * @param latestDenominatorHigh
	 * @param previousDenominatorHigh
	 * @return highestHigh
	 */
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
	
	/**
	 * Iterates through previous high values to find the highestHigh.<br><br>
	 * 
	 * <b>Brute-force method.</b>
	 * 
	 * @param highestNumber
	 * @param sizeOfIndicator
	 * @return highestHigh
	 */
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

	/** 
	 * This just increments the location of stored highestHigh. When a new time-period is added 
	 * the current highest highs are now 1 period further away.
	 * */
	private void incrementLocations() {
		high3.locationOfHighestNumber++;
		high5.locationOfHighestNumber++;
		high10.locationOfHighestNumber++;
		high20.locationOfHighestNumber++;
		high50.locationOfHighestNumber++;
		high100.locationOfHighestNumber++;
		high200.locationOfHighestNumber++;
	}
	
	/**
	 * <b>This method is designed to be OVERRIDED.</b><br>
	 * When searching for lower number change the order so it returns true when num2 
	 * is higher than num1.
	 * 
	 * @param num1
	 * @param num2
	 * @return boolean
	 */
	protected boolean isNum1BiggerThanNum2(BigDecimal num1, BigDecimal num2) {
		if( num1.compareTo(num2) > 0) {
			return true;
		} 
		return false;
	}
	
	/**
	 * <b>This method is designed to be OVERRIDED.</b><br>
	 * When searching for lower number change the attribute to low as
	 * opposed to high. 
	 * @return attribute
	 */
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
	
	/**
	 * Method to store the highest high, as its a multi-parameter result (location + value).
	 */
	private class HighestNumber {
		private BigDecimal valueOfHighestNumber;
		private int locationOfHighestNumber;
		
		HighestNumber(BigDecimal valueOfHighestNumber, 
						    	int locationOfHighestNumber) {
			this.valueOfHighestNumber = valueOfHighestNumber;
			this.locationOfHighestNumber = locationOfHighestNumber;
		}	
	}
	
	/**
	 * Method to store the previous high values.<br> 
	 * Two caveats, firstly previous highs 
	 * does not start setup, it needs to fill first. So it has a isSetup parameter which
	 * gets switched to true when this method is full.<br>
	 * Secondly the user is primarily interested in the last value stored. For the comparisons,
	 * to get the ten-period high, if you check the current 5-period high + the 5-period high from 
	 * 5 periods ago you can get the ten period high with just two searchs.So the method to extract 
	 * data from this is called getLastRecord().
	 */
	private class PreviousHighNumbers{
		private int sizeOfIndicator;
		private HighestNumber[] previousNumbers;
		private boolean isSetup = false;
		private int currentLocation = -1;
		
		PreviousHighNumbers(int sizeOfIndicator){
			this.sizeOfIndicator = sizeOfIndicator;
			previousNumbers = new HighestNumber[sizeOfIndicator];
		}
		
		/**
		 * Returns the last record stored.
		 * @return
		 */
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
		
		/**
		 * Adds a new record.
		 * @param newRecord
		 */
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
