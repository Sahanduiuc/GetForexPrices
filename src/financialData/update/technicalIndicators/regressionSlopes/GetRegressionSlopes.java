package financialData.update.technicalIndicators.regressionSlopes;

import java.math.BigDecimal;
import java.util.ArrayList;

import financialData.update.technicalIndicators.data.GetLocalData;
import financialData.update.technicalIndicators.interfaces.TechnicalIndicators;

public class GetRegressionSlopes implements TechnicalIndicators {
	private RegressionSlope rs3, rs5, rs10, rs20, rs50, rs100, rs200;
	private ArrayList <BigDecimal> valuesToRegress;
	private String datasetKey, attributeKey;
	
	@SuppressWarnings("unchecked")
	@Override
	public void setup(String datasetKey, String attributeKey) {
		this.datasetKey = datasetKey;
		this.attributeKey = attributeKey;
		
		ArrayList<BigDecimal> theList = new ArrayList<BigDecimal> ();
		
		for(int j = 0; j < 200; j++) {
			theList.add(GetLocalData.getValue(datasetKey, attributeKey, j));
			
			switch(j) {
				case 2:
					rs3 = new RegressionSlope( (ArrayList<BigDecimal>) theList.clone() );
					break;
				case 4:
					rs5 = new RegressionSlope( (ArrayList<BigDecimal>) theList.clone() );
					break;
				case 9:
					rs10 = new RegressionSlope( (ArrayList<BigDecimal>) theList.clone() );
					break;
				case 19:
					rs20 = new RegressionSlope( (ArrayList<BigDecimal>) theList.clone() );
					break;
				case 49:
					rs50 = new RegressionSlope( (ArrayList<BigDecimal>) theList.clone() );
					break;
				case 99:
					rs100 = new RegressionSlope( (ArrayList<BigDecimal>) theList.clone() );
					break;
				case 199:
					rs200 = new RegressionSlope( (ArrayList<BigDecimal>) theList.clone() );
					break;
			}	
		}
		valuesToRegress = theList;
		regression3 = addDataAndRegress(0, 3);
	}
	
	@Override
	public void update() {
		valuesToRegress.add(GetLocalData.getValue(datasetKey, attributeKey));
		valuesToRegress.remove(0);
		
		regression3 = addDataAndRegress(0, 3);
		regression5 = addDataAndRegress(3, 5);
		
	}
	BigDecimal regression3, regression5, regression10, regression20, regression50;
	BigDecimal regression100, regression200;
	
	private BigDecimal addDataAndRegress(int startLocation, int endLocation) {
		int size = endLocation - startLocation;
		BigDecimal[] dataToAdd = new BigDecimal[size];
		/*
		startLocation = ( valuesToRegress.size() - 1 - startLocation );
		endLocation = ( valuesToRegress.size() - 1 - endLocation );
		*/
	//	System.out.println("size: " + size + " start " + startLocation + " end " + endLocation + " valuesSize " + valuesToRegress.size());
		for(int j = startLocation, cnt = 0; j < endLocation; j++, cnt++) {
			dataToAdd[cnt] = valuesToRegress.get(j);
		//	System.out.println(valuesToRegress.get(j));
		}
		
		return GetSlopeFromLinearRegression.getRegressionSlope(dataToAdd);
	}
	
	@Override
	public BigDecimal get3Period() {
		return regression3;
	}

	@Override
	public BigDecimal get5Period() {
		return rs5.getLatestValue();
	}

	@Override
	public BigDecimal get10Period() {
		return rs10.getLatestValue();
	}

	@Override
	public BigDecimal get20Period() {
		return BigDecimal.ZERO;
	}

	@Override
	public BigDecimal get50Period() {
		return rs50.getLatestValue();
	}

	@Override
	public BigDecimal get100Period() {
		return rs100.getLatestValue();
	}

	@Override
	public BigDecimal get200Period() {
		return rs200.getLatestValue();
	}

}
