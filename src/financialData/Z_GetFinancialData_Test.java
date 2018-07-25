package financialData;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class Z_GetFinancialData_Test {

	@Test
	void test() {
		BigDecimal expectedOutput, actualOutput;
		
		expectedOutput = new BigDecimal("0.72270");
		actualOutput = GetFinancialData.getFinancialRecord("TEST", "DAY", financialDataKeys.RecordKeys.OPEN, 0);
		assertEquals(expectedOutput, actualOutput);
		//fail("Not yet implemented");
	}

}
