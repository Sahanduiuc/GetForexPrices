package financialData.feed;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import financialDataKeys.RecordKeys;

class Z_GetPricesFromCSV_Test {

	@Test
	void test() {
		HashMap <String, ArrayList <String> > rawData = GetPricesFromCSV.getPrices("TEST_DAY");
		
		String expectedString = "01.01.2004";
		
		assertEquals( expectedString, rawData.get(RecordKeys.DATE) );
	}

}
