package org.tetrasoft.training.excelread;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	WebDriver driver = null;
	@BeforeTest
	public 	void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anusha\\Desktop\\Selenium_Training\\Selenium_Training\\Drivers\\Chrome91\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	@Test(dataProvider = "testData")
	public void testExcel(String username, String password) throws InterruptedException {
      
		//System.out.println(username + "|" + password);
        driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Thread.sleep(2000);
		
		
		

	}

	@DataProvider(name = "testData")
	public Object[][] getData() {
		String excelPath = "C:\\Users\\Anusha\\Desktop\\Selenium_Training\\Selenium_Training\\TestData\\Module1\\test.xlsx";
		Object data[][] = testData(excelPath, "LoginData");
		return data;
	}

	public Object[][] testData(String excelPath, String sheetName) {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();

		Object data[][] = new Object[rowCount-1][colCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				String cellData = excel.getCellDataString(i, j);
				// System.out.println(cellData+" | ");
				data[i - 1][j] = cellData;
			}
		}

		return data;

	}

}
