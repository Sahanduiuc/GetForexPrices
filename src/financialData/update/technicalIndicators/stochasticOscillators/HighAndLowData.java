package financialData.update.technicalIndicators.stochasticOscillators;

import java.math.BigDecimal;

public class HighAndLowData {
	private static BigDecimal high3, high5, high10, high20, high50, high100, high200;
	private static BigDecimal low3, low5, low10, low20, low50, low100, low200;
	
	public static void updateHighs(BigDecimal high3In, BigDecimal high5In, BigDecimal high10In, BigDecimal high20In,
							BigDecimal high50In, BigDecimal high100In, BigDecimal high200In) {
		high3 = high3In;
		high5 = high5In;
		high10 = high10In;
		high20 = high20In;
		high50 = high50In;
		high100 = high100In;
		high200 = high200In;
	}
	
	public static void updateLows(BigDecimal low3In, BigDecimal low5In, BigDecimal low10In, BigDecimal low20In,
									BigDecimal low50In, BigDecimal low100In, BigDecimal low200In) {
		low3 = low3In;
		low5 = low5In;
		low10 = low10In;
		low20 = low20In;
		low50 = low50In;
		low100 = low100In;
		low200 = low200In;
	}
	
	static BigDecimal get3High() {
		return high3;
	}
	static BigDecimal get5High() {
		return high5;
	}
	static BigDecimal get10High() {
		return high10;
	}
	static BigDecimal get20High() {
		return high20;
	}
	static BigDecimal get50High() {
		return high50;
	}
	static BigDecimal get100High() {
		return high100;
	}
	static BigDecimal get200High() {
		return high200;
	}
	
	static BigDecimal get3Low() {
		return low3;
	}
	static BigDecimal get5Low() {
		return low5;
	}
	static BigDecimal get10Low() {
		return low10;
	}
	static BigDecimal get20Low() {
		return low20;
	}
	static BigDecimal get50Low() {
		return low50;
	}
	static BigDecimal get100Low() {
		return low100;
	}
	static BigDecimal get200Low() {
		return low200;
	}

	
}
