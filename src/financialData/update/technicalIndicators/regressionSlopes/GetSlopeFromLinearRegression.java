package financialData.update.technicalIndicators.regressionSlopes;
import java.math.BigDecimal;
import java.math.MathContext;

import org.apache.commons.math3.stat.regression.SimpleRegression;


public class GetSlopeFromLinearRegression {
	private static MathContext mc = new MathContext(5);
	private static SimpleRegression regression = new SimpleRegression();
	/**
	 * Send in BigDecimal values and get the regression slope.<br><br>
	 *
	 * <i>Input :</i><br>
	 * <b>&emsp; BigDecimal[]</b>  y-Value <br>
	 * <i>Returns : </i> <br>
	 * <b>&emsp; BigDecimal</b> RegressionAnalysisSlope<br><br>
	 * 
	 * y-Value is usually the close price, <br>
	 * RegressionAnalysisSlope x value is in increments of 0.001.
	 * @param yValue
	 */
	public static BigDecimal getSignificance() {
		BigDecimal significance = new BigDecimal( regression.getSignificance(), mc );
		
		return significance.multiply( new BigDecimal (1000000));
	}
	public static BigDecimal getErrorRate() {
		BigDecimal error = new BigDecimal( regression.getSignificance(), mc );
		
		return error.multiply( new BigDecimal (100) );
	}
	public static BigDecimal getIntercept() {
		return new BigDecimal( regression.getIntercept(), mc );
	}
	public static BigDecimal getPrediction() {
		return new BigDecimal( regression.predict( 0.0001 ), mc );
	}
	
	public static void clear() {
		regression.clear();
	}
	public static BigDecimal getRegressionSlope(BigDecimal[] yValue) {	
		regression.clear();
		regression.addData( getInputLinearRegression( yValue ) );
	
		return new BigDecimal(  regression.getSlope(), mc );
	}
	
	private static double[][]getInputLinearRegression(BigDecimal[] yValueBigDecimal){
		double[][] outputData = new double[ yValueBigDecimal.length ][ 2 ];
		
		BigDecimal number = new BigDecimal("0.001");
		BigDecimal additionNumber = number;
	
		for (int j = 0, y = (yValueBigDecimal.length - 1); j < yValueBigDecimal.length; j++, y--) {
			outputData[j][0] = number.doubleValue();
			outputData[y][1] = yValueBigDecimal[j].doubleValue();
			System.out.print(yValueBigDecimal[y] + " ");
			number = number.add(additionNumber);
		}
		System.out.println("");
		return outputData;
	}

}
