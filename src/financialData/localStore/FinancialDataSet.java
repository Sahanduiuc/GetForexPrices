package financialData.localStore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import keys.RecordKeys;

/**
 * Stores a complete FinancialDataSet. If the data-set was GBPUSD_HOUR, then this would store 
 * all the attributes for that data-set.<br><br>
 * 
 * A complete financial record consists of:<br>
 * <b>Raw Data</b> Date, time, open, high, low, close, volume.<br>
 * <b>Indicators</b> Moving average, RSI, Stochastic Oscillators, previous highs, previous lows, 
 * Regression.<br>
 * <b> All the indicators come as 3,5,10,20,50,100,200 period indicators.</b><br><br>
 * 
 * Dates and times are stored separate to all other records, as these are stored as Strings whereas
 * the records are stored as BigDecimals.<br><br>
 * 
 * This means there are 3 methods to extract data from this object:<br> 
 * getRecord() - to get anything other than time and date<br>
 * getDate(), getTime() - to get date and time<br><br>
 * 
 * @author James
 * @version 1.0
 * @since 27/07/2018
 *
 */
public final class FinancialDataSet {
	/** Stores all records other than date and time */
	private HashMap < String, ArrayList<BigDecimal> > values;
	/** Stores dates and times */
	private ArrayList <String> dates, times;
	/** Stores size of set */
	private int sizeOfSet = 0;
	
	/** On initialisation, object creates the HashMap and ArrayLists */
	public FinancialDataSet() {
		setup();
	}

	/**
	 * Returns the 'attribute' at 'location'<br><br>
	 * 
	 * <b>Example:</b><br>
	 * <i>attribute: </i> open<br>
	 * <i>location: </i> 0<br>
	 * Would return the open price of the first record stored.
	 * @param attribute
	 * @param location
	 * @return price
	 */
	public BigDecimal getRecord( String attribute, int location ) {
		return values.get(attribute).get(location);
	}
	
	/**
	 * Returns the date at 'location'<br><br>
	 * 
	 * <b>Example:</b><br>
	 * <i>location: </i> 0<br>
	 * Would return the date of the first record stored.
	 * 
	 * @param attribute
	 * @param location
	 * @return price
	 */
	public String getDate( int location ) {
		return dates.get(location);
	}
	
	/**
	 * Returns the time at 'location'<br><br>
	 * 
	 * <b>Example:</b><br>
	 * <i>location: </i> 0<br>
	 * Would return the time of the first record stored.
	 * 
	 * @param attribute
	 * @param location
	 * @return price
	 */
	public String getTime( int location ) {
		return times.get(location);
	}
	
	/**
	 * Returns the set of 'attribute' between 'startLocation' and 'endLocation'. <br><br>
	 * 
	 * <b>Example:</b><br>
	 * <i>attribute: </i> open<br>
	 * <i>startLocation: </i> 0<br>
	 * <i>endLocation: </i> 1000<br>
	 * Would return all the open prices between the 1st and 1000th record.
	 * 
	 * @param attribute
	 * @param startLocation
	 * @param endLocation
	 * @return The set of 'attribute' between 'startLocation' and 'endLocation'
	 */
	public BigDecimal[] getRecord( String attribute, int startLocation, int endLocation ) {
		int sizeOfSet = endLocation - startLocation;
		BigDecimal[] returnValues = new BigDecimal[sizeOfSet];
		
		for (int j = 0; j < sizeOfSet; j++) {
			returnValues[j] = values.get(attribute).get(j);
		}
		
		return returnValues;
	}

	/**
	 * Returns the set of dates between 'startLocation' and 'endLocation'. <br><br>
	 * 
	 * <b>Example:</b><br>
	 * <i>startLocation: </i> 0<br>
	 * <i>endLocation: </i> 1000<br>
	 * Would return all the dates between the 1st and 1000th record.
	 * 
	 * @param startlocation
	 * @param endLocation
	 * @return The set of dates between 'startLocation' and 'endLocation'
	 */
	public BigDecimal[] getDate( int startlocation, int endLocation ) {
		return null;
	}
	
	/**
	 * Returns the set of times between 'startLocation' and 'endLocation'. <br><br>
	 * 
	 * <b>Example:</b><br>
	 * <i>startLocation: </i> 0<br>
	 * <i>endLocation: </i> 1000<br>
	 * Would return all the times between the 1st and 1000th record.
	 * 
	 * @param startlocation
	 * @param endLocation
	 * @return The set of times between 'startLocation' and 'endLocation'
	 */
	public BigDecimal[] getTime( int startlocation, int endLocation ) {
		return null;
	}
	
	/**
	 * Returns all dates stored in this set
	 * @return
	 */
	public String[] getAllDates() {
		return dates.toArray(new String[dates.size()]);
	}
	
	/**
	 * Returns the number of records held in this set
	 * @return
	 */
	public int sizeOfSet() {
		return sizeOfSet;
	}
	/**
	 * Adds a new record to this financial data set. This is set to package only visibility. The 
	 * reason being is this object will be sent to the end user, and update should be an internal 
	 * operation. You update via GetFinancialDataSetFromLocalStore().
	 * @param date
	 * @param time
	 * @param open
	 * @param high
	 * @param low
	 * @param close
	 * @param ma3
	 * @param ma5
	 * @param ma10
	 * @param ma20
	 * @param ma50
	 * @param ma100
	 * @param ma200
	 * @param high3
	 * @param high5
	 * @param high10
	 * @param high20
	 * @param high50
	 * @param high100
	 * @param high200
	 * @param low3
	 * @param low5
	 * @param low10
	 * @param low20
	 * @param low50
	 * @param low100
	 * @param low200
	 * @param so3
	 * @param so5
	 * @param so10
	 * @param so20
	 * @param so50
	 * @param so100
	 * @param so200
	 * @param rsi3
	 * @param rsi5
	 * @param rsi10
	 * @param rsi20
	 * @param rsi50
	 * @param rsi100
	 * @param rsi200
	 * @param rs3
	 * @param rs5
	 * @param rs10
	 * @param rs20
	 * @param rs50
	 * @param rs100
	 * @param rs200
	 * @param volume
	 */
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
		
		sizeOfSet++;
	}
	
	/** Sets up the HashMap and all the ArrayLists needed. */
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
