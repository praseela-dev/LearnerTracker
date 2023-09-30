package org.ictak.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static XSSFWorkbook excelwbook;
	public static XSSFSheet excelsheet;

	public static String getData(int rowNum, int colNum) throws IOException {

		// String returnText = "";
		FileInputStream input = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx");
		excelwbook = new XSSFWorkbook(input);
		excelsheet = excelwbook.getSheetAt(0);
		return excelsheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	}

	public static String getTestData(int workSheet, String testcaseId, int colNum) throws IOException {
		String returnText = "";
		FileInputStream input = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx");
		excelwbook = new XSSFWorkbook(input);
		excelsheet = excelwbook.getSheetAt(workSheet);
		for (Row row : excelsheet) {
			String value = row.getCell(0).getStringCellValue();
			if (testcaseId.equalsIgnoreCase(value.trim())) {
				Cell cell = row.getCell(colNum);
				if (cell != null) {
					DataFormatter formatter = new DataFormatter();
					returnText = formatter.formatCellValue(cell);
					System.out.println("getData:" + returnText);
					break;
				}
			}
		}
		return returnText;
	}

//
//	public static String getData(int workBook, int rowNum, int ColNum) throws IOException {
//		String returnValue = "";
//		FileInputStream inp = new FileInputStream(
//				System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx");
//		excelwbook = new XSSFWorkbook(inp);
//		excelsheet = excelwbook.getSheetAt(workBook);
//
//		XSSFCell cell = excelsheet.getRow(rowNum).getCell(ColNum);
//
//		if (cell != null) {
//			returnValue = cell.getStringCellValue();
//		}
//		return returnValue;
//
//	}
//	public static String getPostData(int rowNum, int ColNum) throws IOException {
//		String returnValue = "";
//		FileInputStream inp = new FileInputStream(
//				System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx");
//		excelwbook = new XSSFWorkbook(inp);
//		excelsheet = excelwbook.getSheetAt(1);
//
//		XSSFCell cell = excelsheet.getRow(rowNum).getCell(ColNum);
//
//		if (cell != null) {
//			returnValue = cell.getStringCellValue();
//		}
//		return returnValue;
//
//	}
//	
}
