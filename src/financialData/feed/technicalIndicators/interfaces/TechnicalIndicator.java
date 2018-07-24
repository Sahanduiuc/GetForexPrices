package financialData.feed.technicalIndicators.interfaces;

import java.math.BigDecimal;

public interface TechnicalIndicator {
	public void update();
	public BigDecimal getLatestValue();
}
