package financialData.update.technicalIndicators.data;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class Z_GetLocalData_Test {
	private String dataset1 = Z_SetupLocalDataForText.DATASET1;
	private String lowKey = financialDataKeys.RecordKeys.LOW;
	private String openKey = financialDataKeys.RecordKeys.OPEN;
	private String closeKey = financialDataKeys.RecordKeys.CLOSE;
	private String highKey = financialDataKeys.RecordKeys.HIGH;
	
	private BigDecimal expectedOutput, actualOutput;
	@Test
	void test() {	
		Z_SetupLocalDataForText.setupDataSet1();
		
		System.out.println("Checking position 0 for dataset 1\n");
		
		expectedOutput = new BigDecimal("201");
		actualOutput = GetLocalData.getValue(dataset1, lowKey);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Checked low at position 0");
		
		expectedOutput = new BigDecimal("202");
		actualOutput = GetLocalData.getValue(dataset1, openKey);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Checked open at position 0");
		
		expectedOutput = new BigDecimal("203");
		actualOutput = GetLocalData.getValue(dataset1, closeKey);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Checked close at position 0");
		
		expectedOutput = new BigDecimal("204");
		actualOutput = GetLocalData.getValue(dataset1, highKey);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Checked high at position 0");
		
		
		
		System.out.println("\nChecking position 1 for dataset 1\n");
		
		expectedOutput = new BigDecimal("200");
		actualOutput = GetLocalData.getValue(dataset1, lowKey, 1);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Checked low at position 1");
		
		expectedOutput = new BigDecimal("201");
		actualOutput = GetLocalData.getValue(dataset1, openKey, 1);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Checked open at position 1");
		
		expectedOutput = new BigDecimal("202");
		actualOutput = GetLocalData.getValue(dataset1, closeKey, 1);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Checked close at position 1");
		
		expectedOutput = new BigDecimal("203");
		actualOutput = GetLocalData.getValue(dataset1, highKey, 1);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Checked high at position 1");
		
		
		
		System.out.println("\nChecking position 200 for dataset 1\n");
		
		expectedOutput = new BigDecimal("1");
		actualOutput = GetLocalData.getValue(dataset1, lowKey, 200);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Checked low at position 200");
		
		expectedOutput = new BigDecimal("2");
		actualOutput = GetLocalData.getValue(dataset1, openKey, 200);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Checked open at position 200");
		
		expectedOutput = new BigDecimal("3");
		actualOutput = GetLocalData.getValue(dataset1, closeKey, 200);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Checked close at position 200");
		
		expectedOutput = new BigDecimal("4");
		actualOutput = GetLocalData.getValue(dataset1, highKey, 200);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Checked high at position 200");
		
		
		
		System.out.println("\nAdding new values\n");
		GetLocalData.update(dataset1, "203", "205", "202", "204");
		
		
		
		System.out.println("Checking position 0 in dataset1 after update\n");
		
		expectedOutput = new BigDecimal("202");
		actualOutput = GetLocalData.getValue(dataset1, lowKey, 0);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Checked low at position 0");
		
		expectedOutput = new BigDecimal("203");
		actualOutput = GetLocalData.getValue(dataset1, openKey, 0);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Checked open at position 0");
		
		expectedOutput = new BigDecimal("204");
		actualOutput = GetLocalData.getValue(dataset1, closeKey, 0);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Checked close at position 0");
		
		expectedOutput = new BigDecimal("205");
		actualOutput = GetLocalData.getValue(dataset1, highKey, 0);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Checked high at position 0");
		
		
		
		System.out.println("\nChecking position 200 for dataset1\n");
		
		expectedOutput = new BigDecimal("2");
		actualOutput = GetLocalData.getValue(dataset1, lowKey, 200);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Checked low at position 200");
		
		expectedOutput = new BigDecimal("3");
		actualOutput = GetLocalData.getValue(dataset1, openKey, 200);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Checked open at position 200");
		
		expectedOutput = new BigDecimal("4");
		actualOutput = GetLocalData.getValue(dataset1, closeKey, 200);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Checked close at position 200");
		
		expectedOutput = new BigDecimal("5");
		actualOutput = GetLocalData.getValue(dataset1, highKey, 200);
		assertEquals(expectedOutput, actualOutput);
		System.out.println("Checked high at position 200");
	}
}
