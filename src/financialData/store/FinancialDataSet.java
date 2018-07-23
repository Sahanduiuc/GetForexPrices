package financialData.store;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import financialDataKeys.RecordKeys;

public class FinancialDataSet {
	private HashMap < String, ArrayList<BigDecimal> > values;
	private ArrayList <String> dates;
	private ArrayList <String> times;
	
	public FinancialDataSet() {
		setup();
	}

	public BigDecimal getRecord( String recordKey, int location ) {
		return values.get(recordKey).get(location);
	}
	public BigDecimal getDate( String recordKey, int location ) {
		return values.get(recordKey).get(location);
	}
	public BigDecimal getTime( String recordKey, int location ) {
		return values.get(recordKey).get(location);
	}
	public BigDecimal[] getDate( String recordKey, int startlocation, int endLocation ) {
		return null;
	}
	public BigDecimal[] getTime( String recordKey, int startlocation, int endLocation ) {
		return null;
	}
	public BigDecimal[] getRecord( String recordKey, int startlocation, int endLocation) {
		return null;
	}
	
	public void addNewRecord() {
		
	}
	
	private void setup() {
		values = new HashMap < String, ArrayList<BigDecimal> > ();
		dates = new ArrayList  <String> ();
		times = new ArrayList <String> ();
		
		values.put( RecordKeys.OPEN,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.HIGH,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.LOW,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.CLOSE,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.VOLUME,  new ArrayList <BigDecimal> () );
		
		values.put( RecordKeys.THREEMOVAVG,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.FIVEMOVAVG,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.TENMOVAVG,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.TWENTYMOVAVG,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.FIFTYMOVAVG,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.ONEHUNMOVAVG,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.TWOHUNMOVAVG,  new ArrayList <BigDecimal> () );
	}
	
	
}
