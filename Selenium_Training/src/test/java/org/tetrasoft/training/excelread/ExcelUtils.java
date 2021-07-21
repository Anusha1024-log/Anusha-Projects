package org.tetrasoft.training.excelread;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static String projectPath;
	static XSSFWorkbook workbook;

	static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}

	}

	public static void main(String[] args) {
		getRowCount();
		getCellDataString(0, 0);
		getCellDatNumber(1, 1);
	}

	public static int getRowCount() {
		int rowCount = 0;
		try {

			rowCount = sheet.getPhysicalNumberOfRows();

			System.out.println("No of rows:" + rowCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}
		return rowCount;
	}

	public static int getColCount() {
		int colCount = 0;
		try {

			colCount = sheet.getRow(0).getPhysicalNumberOfCells();

			System.out.println("No of cols:" + colCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}
		return colCount;
	}

	public static String getCellDataString(int rowNum, int colNum) {
		String cellData = null;
		try {
			projectPath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projectPath + "/TestData/Module1/test.xlsx");

			sheet = workbook.getSheet("LoginData");

			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();

			System.out.println("cell Data is:" + cellData);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}
		return cellData;
	}

	public static void getCellDatNumber(int rowNum, int colNum) {

		try {

			double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();

			System.out.println("cell Data is:" + cellData);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}
	}

}
