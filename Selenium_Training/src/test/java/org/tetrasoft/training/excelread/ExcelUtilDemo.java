package org.tetrasoft.training.excelread;


public class ExcelUtilDemo{
	
	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		
		ExcelUtils excel = new ExcelUtils(projectPath+"/TestData/Module1/test.xlsx", "LoginData");
		
		excel.getRowCount();
		excel.getColCount();
		excel.getCellDataString(0, 0);
		excel.getCellDatNumber(1, 1);
	  

	}
		
}
