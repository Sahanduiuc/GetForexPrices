package financialData.update.technicalIndicators.regressionSlopes;

import java.math.BigDecimal;
import java.util.ArrayList;

import financialData.update.technicalIndicators.data.GetLocalData;
import financialData.update.technicalIndicators.interfaces.TechnicalIndicators;

public class GetRegressionSlopes implements TechnicalIndicators {
	private RegressionSlope rs3, rs5, rs10, rs20, rs50, rs100, rs200;
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
		
	}
	
	@Override
	public void update() {
		BigDecimal latestValue = GetLocalData.getValue(datasetKey, attributeKey);
		rs3.update(latestValue);
		rs5.update(latestValue);
		rs10.update(latestValue);
		rs20.update(latestValue);
		rs50.update(latestValue);
		rs100.update(latestValue);
		rs200.update(latestValue);
	}
	
	@Override
	public BigDecimal get3Period() {
		return rs3.getLatestValue();
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
		return rs20.getLatestValue();
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
