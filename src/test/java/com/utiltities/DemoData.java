package com.utiltities;

public class DemoData {

	public static void main(String[] args) {
		 
		
		dataInfo("C:\\Users\\Karthick\\eclipse-workspace\\com.ultimatix.automation\\Excel\\Inform.xlsx","Sheet1");
	}
	
public static void dataInfo(String excelPath, String sheetName) {
		
		ExcelData data = new ExcelData(excelPath, sheetName);
		int totalRows = data.getRowDetails();
		int totalCols = data.getColumnDetails();
		
		for(int i=1; i<totalRows;i++) {
			for(int j=0;j<totalCols;j++) {
				
				String stringData = data.getStringData(i, j);
				System.out.print(stringData + " | ");
			}
			System.out.println();
		}
		
		
	}

}
