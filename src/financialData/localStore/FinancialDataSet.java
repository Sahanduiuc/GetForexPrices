package financialData.localStore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import keys.RecordKeys;

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
	public String getDate( int location ) {
		return dates.get(location);
	}
	public String getTime( int location ) {
		return times.get(location);
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
	
	void addNewRecord( String date, String time, BigDecimal open, BigDecimal high, 
					   BigDecimal low, BigDecimal close, 
					   BigDecimal ma3, BigDecimal ma5, BigDecimal ma10, BigDecimal ma20, 
					   BigDecimal ma50, BigDecimal ma100, BigDecimal ma200,
					   BigDecimal high3, BigDecimal high5, BigDecimal high10,
					   BigDecimal high20, BigDecimal high50, BigDecimal high100,
					   BigDecimal high200,
					   BigDecimal low3, BigDecimal low5, BigDecimal low10,
					   BigDecimal low20, BigDecimal low50, BigDecimal low100,
					   BigDecimal low200,
					   BigDecimal so3, BigDecimal so5, BigDecimal so10,
					   BigDecimal so20, BigDecimal so50, BigDecimal so100,
					   BigDecimal so200,
					   BigDecimal rsi3, BigDecimal rsi5, BigDecimal rsi10,
					   BigDecimal rsi20, BigDecimal rsi50, BigDecimal rsi100,
					   BigDecimal rsi200,
					   BigDecimal rs3, BigDecimal rs5, BigDecimal rs10,
					   BigDecimal rs20, BigDecimal rs50, BigDecimal rs100,
					   BigDecimal rs200,
					   BigDecimal volume ) {
		dates.add(date);
		times.add(time);
		
		values.get(RecordKeys.OPEN).add(open);
		values.get(RecordKeys.HIGH).add(high);
		values.get(RecordKeys.LOW).add(low);
		values.get(RecordKeys.CLOSE).add(close);
		values.get(RecordKeys.VOLUME).add(volume);
		
		values.get(RecordKeys.THREEMOVAVG).add(ma3);
		values.get(RecordKeys.FIVEMOVAVG).add(ma5);
		values.get(RecordKeys.TENMOVAVG).add(ma10);
		values.get(RecordKeys.TWENTYMOVAVG).add(ma20);
		values.get(RecordKeys.FIFTYMOVAVG).add(ma50);
		values.get(RecordKeys.ONEHUNMOVAVG).add(ma100);
		values.get(RecordKeys.TWOHUNMOVAVG).add(ma200);
		
		values.get(RecordKeys.THREEHIGH).add(high3);
		values.get(RecordKeys.FIVEHIGH).add(high5);
		values.get(RecordKeys.TENHIGH).add(high10);
		values.get(RecordKeys.TWENTYHIGH).add(high20);
		values.get(RecordKeys.FIFTYHIGH).add(high50);
		values.get(RecordKeys.ONEHUNHIGH).add(high100);
		values.get(RecordKeys.TWOHUNHIGH).add(high200);
		
		values.get(RecordKeys.THREELOW).add(low3);
		values.get(RecordKeys.FIVELOW).add(low5);
		values.get(RecordKeys.TENLOW).add(low10);
		values.get(RecordKeys.TWENTYLOW).add(low20);
		values.get(RecordKeys.FIFTYLOW).add(low50);
		values.get(RecordKeys.ONEHUNLOW).add(low100);
		values.get(RecordKeys.TWOHUNLOW).add(low200);
		
		values.get(RecordKeys.THREERSI).add(rsi3);
		values.get(RecordKeys.FIVERSI).add(rsi5);
		values.get(RecordKeys.TENRSI).add(rsi10);
		values.get(RecordKeys.TWENTYRSI).add(rsi20);
		values.get(RecordKeys.FIFTYRSI).add(rsi50);
		values.get(RecordKeys.ONEHUNRSI).add(rsi100);
		values.get(RecordKeys.TWOHUNRSI).add(rsi200);
		
		values.get(RecordKeys.THREESTOCHASTIC).add(so3);
		values.get(RecordKeys.FIVESTOCHASTIC).add(so5);
		values.get(RecordKeys.TENSTOCHASTIC).add(so10);
		values.get(RecordKeys.TWENTYSTOCHASTIC).add(so20);
		values.get(RecordKeys.FIFTYSTOCHASTIC).add(so50);
		values.get(RecordKeys.ONEHUNSTOCHASTIC).add(so100);
		values.get(RecordKeys.TWOHUNSTOCHASTIC).add(so200);
		
		values.get(RecordKeys.THREEREGRESSION).add(rs3);
		values.get(RecordKeys.FIVEREGRESSION).add(rs5);
		values.get(RecordKeys.TENREGRESSION).add(rs10);
		values.get(RecordKeys.TWENTYREGRESSION).add(rs20);
		values.get(RecordKeys.FIFTYREGRESSION).add(rs50);
		values.get(RecordKeys.ONEHUNREGRESSION).add(rs100);
		values.get(RecordKeys.TWOHUNREGRESSION).add(rs200);
		
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
		
		values.put( RecordKeys.THREEHIGH,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.FIVEHIGH,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.TENHIGH,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.TWENTYHIGH,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.FIFTYHIGH,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.ONEHUNHIGH,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.TWOHUNHIGH,  new ArrayList <BigDecimal> () );
		
		values.put( RecordKeys.THREELOW,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.FIVELOW,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.TENLOW,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.TWENTYLOW,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.FIFTYLOW,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.ONEHUNLOW,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.TWOHUNLOW,  new ArrayList <BigDecimal> () );
		
		values.put( RecordKeys.THREERSI,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.FIVERSI,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.TENRSI,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.TWENTYRSI,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.FIFTYRSI,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.ONEHUNRSI,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.TWOHUNRSI,  new ArrayList <BigDecimal> () );
		
		values.put( RecordKeys.THREESTOCHASTIC,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.FIVESTOCHASTIC,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.TENSTOCHASTIC,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.TWENTYSTOCHASTIC,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.FIFTYSTOCHASTIC,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.ONEHUNSTOCHASTIC,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.TWOHUNSTOCHASTIC,  new ArrayList <BigDecimal> () );
		
		values.put( RecordKeys.THREEREGRESSION,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.FIVEREGRESSION,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.TENREGRESSION,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.TWENTYREGRESSION,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.FIFTYREGRESSION,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.ONEHUNREGRESSION,  new ArrayList <BigDecimal> () );
		values.put( RecordKeys.TWOHUNREGRESSION,  new ArrayList <BigDecimal> () );
		

	}
	
	
}
