package financialData.update.technicalIndicators.interfaces;

import java.math.BigDecimal;

public interface TechnicalIndicators {
	public void update();

	public BigDecimal get3Period();
	public BigDecimal get5Period();
	public BigDecimal get10Period();
	public BigDecimal get20Period();
	public BigDecimal get50Period();
	public BigDecimal get100Period();
	public BigDecimal get200Period();
	
}
