package financialData.update.technicalIndicators.data;

import java.math.BigDecimal;

import settings.Settings;

/**
 * This class stores the latest 201 values sent to it. Designed to store open, close, high or low 
 * values for technical indicators.
 * @author James
 * @version 1.0
 * @since 28/07/2018
 */
final class LocalDataSet {
	/** The size of this set */
	private static final int sizeOfThisSet = Settings.LARGESTTECHNICALINDICATOR + 1;
	/** The store for the values*/
	private BigDecimal[] values = new BigDecimal[Settings.LARGESTTECHNICALINDICATOR + 1];
	/** The current location*/
	private int currentLocation = -1;
	
	/**
	 * Returns the record stored from 'periodsAgo'.
	 * @param periodsAgo
	 * @return value
	 */
	BigDecimal getRecord(int periodsAgo){
		int temp = currentLocation - periodsAgo;
		
		if( temp < 0 ) {
			temp = sizeOfThisSet + temp;
		}
		
		return values[temp];
	}
	
	/**
	 * Returns the latest value stored.
	 * @return
	 */
	BigDecimal getRecord(){
		return getRecord(0);
	}
	
	/**
	 * Adds 'newValue' to the store.
	 * @param newValue
	 */
	void add(BigDecimal newValue) {
		incrementLocation();
		values[currentLocation] = newValue;
	}
	
	/**
	 * Increments currentLocation
	 */
	private void incrementLocation(){
		if( currentLocation == (sizeOfThisSet - 1) ) {
			currentLocation = 0;
		}
		else {
			currentLocation++;
		}
	}
}
