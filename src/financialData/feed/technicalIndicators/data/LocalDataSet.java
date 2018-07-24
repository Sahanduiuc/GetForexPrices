package financialData.feed.technicalIndicators.data;

import java.math.BigDecimal;

import settings.Settings;

class LocalDataSet {
	private BigDecimal[] values;
	private int currentLocation = -1;
	private int sizeOfThisSet;
	
	LocalDataSet(){
		sizeOfThisSet = Settings.LARGESTTECHNICALINDICATOR + 1;
		values = new BigDecimal[sizeOfThisSet];
	}
	
	BigDecimal getRecord(int location){
		int temp = currentLocation - location;
		
		if( temp < 0 ) {
			temp = sizeOfThisSet + temp;
		}
		
		return values[temp];
	}
	BigDecimal getRecord(){
		return getRecord(0);
	}
	private void incrementLocation(){
		if( currentLocation == (sizeOfThisSet - 1) ) {
			currentLocation = 0;
		}
		else {
			currentLocation++;
		}
	}
	void add(BigDecimal newValue) {
		incrementLocation();
		values[currentLocation] = newValue;
	}
}
