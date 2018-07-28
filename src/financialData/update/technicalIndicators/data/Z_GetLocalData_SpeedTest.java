package financialData.update.technicalIndicators.data;

import java.math.BigDecimal;

/**
 * Simple class that determines the speed that LocalDataSet is running at.
 * 
 * @author James
 * @version 1.0
 * @since 28/07/2018
 */
class Z_GetLocalData_SpeedTest {
	public static void main(String [] args) {
		String key = "dataset";
		
		System.out.println("Testing speed to place 80000 records in local data");
		
		final long startTime =  System.currentTimeMillis();
		
		for(int j = 0; j < 8000000; j++) {
			GetLocalData.update(key, new BigDecimal(j), new BigDecimal(j), new BigDecimal(j), new BigDecimal(j));
		}
		
		final long endTime = System.currentTimeMillis();
		
		System.out.println("Total execution time: " + (endTime - startTime) );
	}
}
