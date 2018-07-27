package financialData;

import java.math.BigDecimal;

import keys.*;

class Z_Manual_Test {
	public static void main(String [] args) {
		int sizeOfSet = GetFinancialData.getSizeOfSet(AssetKeys.GBPUSD, AssetKeys.DAY);
		
		System.out.println("Size of " + AssetKeys.GBPUSD + " " + AssetKeys.DAY + ": " + sizeOfSet + "\n");
		
		for(int j = 0; j < sizeOfSet; j++) {
			BigDecimal open = GetFinancialData.getFinancialRecord(AssetKeys.GBPUSD, AssetKeys.DAY, RecordKeys.CLOSE, j);
			String date = GetFinancialData.getDate(AssetKeys.GBPUSD, AssetKeys.DAY, j);
			System.out.println(date + " " + open);
		}
	}
}
