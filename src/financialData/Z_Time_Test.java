package financialData;

import java.math.BigDecimal;

import keys.*;

class Z_Time_Test {
	public static void main(String [] args) {
		System.out.println("Testing time to calcualte technical indicators and "
				+ "store records in the local store\n");
		
	//	testTime(AssetKeys.GBPUSD, AssetKeys.WEEK);
		testTime(AssetKeys.GBPUSD, AssetKeys.DAY);
	//	testTime(AssetKeys.GBPUSD, AssetKeys.HOUR);
		
		System.out.println("\nTesting time now records are in local store\n");
		
	//	testTime(AssetKeys.GBPUSD, AssetKeys.WEEK);
	//	testTime(AssetKeys.GBPUSD, AssetKeys.DAY);
	//	testTime(AssetKeys.GBPUSD, AssetKeys.HOUR);
		printRS(0);
		printRS(1);
		printRS(2);
		printRS(3);
		printRS(4);
		printRS(5);
		
	}
	
	private static void testTime(String asset, String timeFrame) {
		System.out.println("Testing time to get " + asset + "_" + timeFrame);
		
		final long startTime =  System.currentTimeMillis();
		GetFinancialData.getDate(asset, timeFrame, 0);
		final long endTime = System.currentTimeMillis();
		
		System.out.println("Total execution time: " + (endTime - startTime) );
	}
	
	private static void printRS(int location) {
		BigDecimal rs3, rs5, rs10, rs20, rs50, rs100, rs200;
		
		rs3 = GetFinancialData.getFinancialRecord(AssetKeys.GBPUSD, AssetKeys.DAY, RecordKeys.THREEREGRESSION, location);
		rs5 = GetFinancialData.getFinancialRecord(AssetKeys.GBPUSD, AssetKeys.DAY, RecordKeys.FIVEREGRESSION, location);
		rs10 = GetFinancialData.getFinancialRecord(AssetKeys.GBPUSD, AssetKeys.DAY, RecordKeys.TENREGRESSION, location);
		rs20 = GetFinancialData.getFinancialRecord(AssetKeys.GBPUSD, AssetKeys.DAY, RecordKeys.TWENTYREGRESSION, location);
		rs50 = GetFinancialData.getFinancialRecord(AssetKeys.GBPUSD, AssetKeys.DAY, RecordKeys.FIFTYREGRESSION, location);
		rs100 = GetFinancialData.getFinancialRecord(AssetKeys.GBPUSD, AssetKeys.DAY, RecordKeys.ONEHUNREGRESSION, location);
		rs200 = GetFinancialData.getFinancialRecord(AssetKeys.GBPUSD, AssetKeys.DAY, RecordKeys.TWOHUNREGRESSION, location);
		
		System.out.println(rs3 + " " + rs5 + " " + rs10 + " " + rs20 + " " + rs50 + " " + rs100 + " " + rs200);
	}
}

/**
 * TIMES FOR GBPUSD HOUR
 * 
 * - Initial time:   9120
 * - With regression taken out: 5939
 * 
 * 
-7.1000 -2.8500 -1.8275 0.095586 -0.25292 0.63547 -0.028123
-5.0000 -4.2440 -2.8435 -0.36132 -0.34281 0.61056 -0.036919
-12.990 -9.0360 -5.2013 -1.0055 -0.47464 0.56091 -0.047118
-6.3600 -7.1420 -5.4852 -1.4973 -0.58244 0.51556 -0.056359
2.3250 -5.5380 -5.1894 -1.9657 -0.74438 0.47431 -0.063823
-2.9600 -3.2630 -4.9134 -2.4495 -0.88130 0.42963 -0.070075
 * */
