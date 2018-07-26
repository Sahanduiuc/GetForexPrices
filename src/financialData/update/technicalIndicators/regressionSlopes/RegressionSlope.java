package financialData.update.technicalIndicators.regressionSlopes;

import java.math.BigDecimal;
import java.util.ArrayList;

class RegressionSlope {
	private ArrayList<BigDecimal> valuesToRegress;
	
	RegressionSlope(ArrayList<BigDecimal> valuesToRegress){
		this.valuesToRegress = valuesToRegress;
	}
	
	void update(BigDecimal latestValue) {
		valuesToRegress.remove(0);
		valuesToRegress.add(latestValue);
	}
	
	BigDecimal getLatestValue() {
		return GetSlopeFromLinearRegression.getRegressionSlope(valuesToRegress.toArray(new BigDecimal[valuesToRegress.size()]));
	}
	
}
