package financialData.update.technicalIndicators.highsAndLows;

import java.math.BigDecimal;

public final class GetLows extends GetHighs {
	
	@Override
	protected boolean isNum1BiggerThanNum2(BigDecimal num1, BigDecimal num2) {
		if( num2.compareTo(num1) > 0) {
			return true;
		} 
		return false;
	}
	
	@Override
	protected String getAttribute() {
		return keys.RecordKeys.LOW;
	}
}
