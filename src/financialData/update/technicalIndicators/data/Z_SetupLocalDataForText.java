package financialData.update.technicalIndicators.data;

/**
 * This class sets up data to store in LocalDataSet. This is used for testing the different technical indicators.
 * @author James
 *
 */
public final class Z_SetupLocalDataForText {
	public static final String DATASET1 = "DATASET1";
	
	public static void setupDataSet1(){
		for( int low = 1, open = 2, close = 3, high = 4; low <= 201;
				low++, open++, close++, high++) {
			GetLocalData.update(DATASET1, ""+open, ""+high, ""+low, ""+close);
		}
	}
}
