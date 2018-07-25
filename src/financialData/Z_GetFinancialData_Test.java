package financialData;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import financialDataKeys.RecordKeys;

class Z_GetFinancialData_Test {
	private String asset = "TEST";
	private String timeFrame = "DAY";
	@Test
	void test() {
		BigDecimal expectedOutput, actualOutput;
		String expectedOutputString, actualOutputString;
		
		// Test First Row
		System.out.println("Testing first row...\n");
		
		expectedOutputString = "22.08.2004";
		actualOutputString = GetFinancialData.getDate(asset, timeFrame, 0);
		assertEquals(expectedOutputString, actualOutputString);
		System.out.println("Tested date");
		
		expectedOutputString = "01:00:00";
		actualOutputString = GetFinancialData.getTime(asset, timeFrame, 0);
		assertEquals(expectedOutputString, actualOutputString);
		System.out.println("Tested time");
		
		expectedOutput = new BigDecimal("0.72270");
		actualOutput = GetFinancialData.getFinancialRecord(asset, timeFrame, RecordKeys.OPEN, 0);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Tested open");
		
		expectedOutput = new BigDecimal("0.72360");
		actualOutput = GetFinancialData.getFinancialRecord(asset, timeFrame, RecordKeys.HIGH, 0);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Tested high");
		
		expectedOutput = new BigDecimal("0.72156");
		actualOutput = GetFinancialData.getFinancialRecord(asset, timeFrame, RecordKeys.LOW, 0);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Tested low");
		
		expectedOutput = new BigDecimal("0.72234");
		actualOutput = GetFinancialData.getFinancialRecord(asset, timeFrame, RecordKeys.CLOSE, 0);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Tested close");
		
		expectedOutput = new BigDecimal("220978.8594");
		actualOutput = GetFinancialData.getFinancialRecord(asset, timeFrame, RecordKeys.VOLUME, 0);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Tested volume");
		
		expectedOutput = new BigDecimal("0.7204533333");
		actualOutput = GetFinancialData.getFinancialRecord(asset, timeFrame, RecordKeys.THREEMOVAVG, 0);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Tested 3 Period Moving Average");
		
		expectedOutput = new BigDecimal("0.71885");
		actualOutput = GetFinancialData.getFinancialRecord(asset, timeFrame, RecordKeys.FIVEMOVAVG, 0);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Tested 5 Period Moving Average");
		
		expectedOutput = new BigDecimal("0.716308");
		actualOutput = GetFinancialData.getFinancialRecord(asset, timeFrame, RecordKeys.TENMOVAVG, 0);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Tested 10 Period Moving Average");
		
		expectedOutput = new BigDecimal("0.710952");
		actualOutput = GetFinancialData.getFinancialRecord(asset, timeFrame, RecordKeys.TWENTYMOVAVG, 0);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Tested 20 Period Moving Average");
		
		expectedOutput = new BigDecimal("0.7125524");
		actualOutput = GetFinancialData.getFinancialRecord(asset, timeFrame, RecordKeys.FIFTYMOVAVG, 0);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Tested 50 Period Moving Average");
		
		expectedOutput = new BigDecimal("0.7071045");
		actualOutput = GetFinancialData.getFinancialRecord(asset, timeFrame, RecordKeys.ONEHUNMOVAVG, 0);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Tested 100 Period Moving Average");
		
		expectedOutput = new BigDecimal("0.7339579");
		actualOutput = GetFinancialData.getFinancialRecord(asset, timeFrame, RecordKeys.TWOHUNMOVAVG, 0);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Tested 200 Period Moving Average");
		
		
		
		
		
		
		// Test Final Row
		System.out.println("\nTesting final row...\n");
		
		expectedOutputString = "15.12.2004";
		actualOutputString = GetFinancialData.getDate(asset, timeFrame, 99);
		assertEquals(expectedOutputString, actualOutputString);
		System.out.println("Tested date");
		
		expectedOutputString = "00:00:00";
		actualOutputString = GetFinancialData.getTime(asset, timeFrame, 99);
		assertEquals(expectedOutputString, actualOutputString);
		System.out.println("Tested time");
		
		expectedOutput = new BigDecimal("0.75482");
		actualOutput = GetFinancialData.getFinancialRecord(asset, timeFrame, RecordKeys.OPEN, 99);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Tested open");
		
		expectedOutput = new BigDecimal("0.76510");
		actualOutput = GetFinancialData.getFinancialRecord(asset, timeFrame, RecordKeys.HIGH, 99);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Tested high");
		
		expectedOutput = new BigDecimal("0.75354");
		actualOutput = GetFinancialData.getFinancialRecord(asset, timeFrame, RecordKeys.LOW, 99);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Tested low");
		
		expectedOutput = new BigDecimal("0.76302");
		actualOutput = GetFinancialData.getFinancialRecord(asset, timeFrame, RecordKeys.CLOSE, 99);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Tested close");
		
		expectedOutput = new BigDecimal("2771895.75");
		actualOutput = GetFinancialData.getFinancialRecord(asset, timeFrame, RecordKeys.VOLUME, 99);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Tested volume");
			
	}

}
