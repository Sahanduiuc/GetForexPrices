package financialData.update.technicalIndicators.interfaces;

import java.math.BigDecimal;

public interface TechnicalIndicators {
	
	/**
	 * Sets up this technical indicator.<br><br>
	 * 
	 * <b> Please note: </b><br>
	 * To use this, GetLocalData() MUST have 200 values stored first.
	 * 
	 * @param datasetKey
	 * @param attributeKey
	 */
	public void setup(String datasetKey, String attributeKey);
	
	/**
	 * Updates this technical indicator.<br><br>
	 * 
	 * <b> Please note: </b><br>
	 * To use this you MUST use setup first. 
	 */
	public void update();

	/**
	 * Returns the latest value for the 3-period of this technical indicator.
	 * @return Technical indicator value
	 */
	public BigDecimal get3Period();
	
	/**
	 * Returns the latest value for the 5-period of this technical indicator.
	 * @return Technical indicator value
	 */
	public BigDecimal get5Period();
	
	/**
	 * Returns the latest value for the 10-period of this technical indicator.
	 * @return Technical indicator value
	 */
	public BigDecimal get10Period();
	
	/**
	 * Returns the latest value for the 20-period of this technical indicator.
	 * @return Technical indicator value
	 */
	public BigDecimal get20Period();
	
	/**
	 * Returns the latest value for the 50-period of this technical indicator.
	 * @return Technical indicator value
	 */
	public BigDecimal get50Period();
	
	/**
	 * Returns the latest value for the 100-period of this technical indicator.
	 * @return Technical indicator value
	 */
	public BigDecimal get100Period();
	
	/**
	 * Returns the latest value for the 200-period of this technical indicator.
	 * @return Technical indicator value
	 */
	public BigDecimal get200Period();
	
}
