package financialData.update.technicalIndicators.stochasticOscillators;

import java.math.BigDecimal;

import financialData.update.technicalIndicators.data.GetLocalData;
import financialData.update.technicalIndicators.interfaces.TechnicalIndicators;

public class GetStochasticOscillators implements TechnicalIndicators {
	private BigDecimal so3, so5, so10, so20, so50, so100, so200;
	private String datasetKey;
	private String attributeKey;
	
	@Override
	public void setup(String datasetKey, String attributeKey) {
		this.datasetKey = datasetKey;
		this.attributeKey = attributeKey;
		update();
	}
	
	@Override
	public void update() {
		BigDecimal currentClose = GetLocalData.getValue(datasetKey, attributeKey);
		
		so3 = claculate(currentClose, HighAndLowData.get3High(), HighAndLowData.get3Low());
		so5 = claculate(currentClose, HighAndLowData.get5High(), HighAndLowData.get5Low());
		so10 = claculate(currentClose, HighAndLowData.get10High(), HighAndLowData.get10Low());
		so20 = claculate(currentClose, HighAndLowData.get20High(), HighAndLowData.get20Low());
		so50 = claculate(currentClose, HighAndLowData.get50High(), HighAndLowData.get50Low());
		so100 = claculate(currentClose, HighAndLowData.get100High(), HighAndLowData.get100Low());
		so200 = claculate(currentClose, HighAndLowData.get200High(), HighAndLowData.get200Low());
	}

	@Override
	public BigDecimal get3Period() {
		return so3;
	}

	@Override
	public BigDecimal get5Period() {
		return so5;
	}

	@Override
	public BigDecimal get10Period() {
		return so10;
	}

	@Override
	public BigDecimal get20Period() {
		return so20;
	}

	@Override
	public BigDecimal get50Period() {
		return so50;
	}

	@Override
	public BigDecimal get100Period() {
		return so100;
	}

	@Override
	public BigDecimal get200Period() {
		return so200;
	}
	
	private static BigDecimal claculate(BigDecimal currentClose, BigDecimal highestHigh, BigDecimal lowestlow) {
		BigDecimal top = currentClose.subtract(lowestlow);
		BigDecimal bottom = highestHigh.subtract(lowestlow);
		BigDecimal division = top.divide(bottom, settings.Settings.MC);
		return division.multiply(new BigDecimal(100));
	}
}
