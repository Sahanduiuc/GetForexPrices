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
		
		System.out.println("Checking first row...\n");
		
		String expectedString = "01.01.2004";
		assertEquals( expectedString, rawData.get(RecordKeys.DATE).get(0) );
		System.out.println("Checked Date");
		
		expectedString = "00:00:00";
		assertEquals( expectedString, rawData.get(RecordKeys.TIME).get(0) );
		System.out.println("Checked Time");
		
		expectedString = "0.75147";
		assertEquals( expectedString, rawData.get(RecordKeys.OPEN).get(0) );
		System.out.println("Checked Open");
		
		expectedString = "0.75305";
		assertEquals( expectedString, rawData.get(RecordKeys.HIGH).get(0) );
		System.out.println("Checked High");
		
		expectedString = "0.74963";
		assertEquals( expectedString, rawData.get(RecordKeys.LOW).get(0) );
		System.out.println("Checked Low");
		
		expectedString = "0.75168";
		assertEquals( expectedString, rawData.get(RecordKeys.CLOSE).get(0) );
		System.out.println("Checked Close");
		
		expectedString = "14452.5703";
		assertEquals( expectedString, rawData.get(RecordKeys.VOLUME).get(0) );
		System.out.println("Checked Volume");
		
		
		
		System.out.println("\nChecking Second row...\n");
		
		expectedString = "02.01.2004";
		assertEquals( expectedString, rawData.get(RecordKeys.DATE).get(1) );
		System.out.println("Checked Date");
		
		expectedString = "00:00:00";
		assertEquals( expectedString, rawData.get(RecordKeys.TIME).get(1) );
		System.out.println("Checked Time");
		
		expectedString = "0.75169";
		assertEquals( expectedString, rawData.get(RecordKeys.OPEN).get(1) );
		System.out.println("Checked Open");
		
		expectedString = "0.75915";
		assertEquals( expectedString, rawData.get(RecordKeys.HIGH).get(1) );
		System.out.println("Checked High");
		
		expectedString = "0.74939";
		assertEquals( expectedString, rawData.get(RecordKeys.LOW).get(1) );
		System.out.println("Checked Low");
		
		expectedString = "0.75737";
		assertEquals( expectedString, rawData.get(RecordKeys.CLOSE).get(1) );
		System.out.println("Checked Close");
		
		expectedString = "130765.6797";
		assertEquals( expectedString, rawData.get(RecordKeys.VOLUME).get(1) );
		System.out.println("Checked Volume");
		
		
		
		System.out.println("\nChecking Final row...\n");
		
		expectedString = "15.12.2004";
		assertEquals( expectedString, rawData.get(RecordKeys.DATE).get(298) );
		System.out.println("Checked Date");
		
		expectedString = "00:00:00";
		assertEquals( expectedString, rawData.get(RecordKeys.TIME).get(298) );
		System.out.println("Checked Time");
		
		expectedString = "0.75482";
		assertEquals( expectedString, rawData.get(RecordKeys.OPEN).get(298) );
		System.out.println("Checked Open");
		
		expectedString = "0.76510";
		assertEquals( expectedString, rawData.get(RecordKeys.HIGH).get(298) );
		System.out.println("Checked High");
		
		expectedString = "0.75354";
		assertEquals( expectedString, rawData.get(RecordKeys.LOW).get(298) );
		System.out.println("Checked Low");
		
		expectedString = "0.76302";
		assertEquals( expectedString, rawData.get(RecordKeys.CLOSE).get(298) );
		System.out.println("Checked Close");
		
		expectedString = "2771895.75";
		assertEquals( expectedString, rawData.get(RecordKeys.VOLUME).get(298) );
		System.out.println("Checked Volume");
		
		
	}

}
