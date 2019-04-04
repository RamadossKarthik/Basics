package com.utiltities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	// Method to get the total no of rows
	public static int getRowDetails() {

		int totalRows = sheet.getPhysicalNumberOfRows();
		//System.out.println("Total no of rows is :" + totalRows);
		return totalRows;
	}


	// Method to get the total no of columns 
	public static int getColumnDetails() {

		int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();
		//System.out.println("Total no of columns is :" + totalCols);
		return totalCols;
	}


	// Method to get the String data in the cell
	public static String getStringData(int rowNum, int colNum) {
		
		DataFormatter fmt = new DataFormatter();
		Cell values = sheet.getRow(rowNum).getCell(colNum);
		String stringData = fmt.formatCellValue(values);
		//System.out.println("The string data in cell is :" + stringData);
		return stringData;
		
	}

	// Method to get the Numeric data in the cell
	public static void getNumericData(int rowNum, int colNum) {

		double numericData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		//System.out.println("The numeric data in cell is :" + numericData);

	}

	public static void main(String[] args) {
		getRowDetails();
		getColumnDetails();
	}

	public ExcelData(String excelPath , String sheetName) {

		try {
			workbook = new XSSFWorkbook("C:\\Users\\Karthick\\eclipse-workspace\\com.ultimatix.automation\\Excel\\Inform.xlsx");
			sheet = workbook.getSheet("Sheet1");
		} catch (IOException e) {
			e.getCause();
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		}


	}

}
