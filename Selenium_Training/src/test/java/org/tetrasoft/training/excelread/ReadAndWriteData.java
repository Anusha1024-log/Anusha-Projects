package org.tetrasoft.training.excelread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReadAndWriteData {

	WebDriver driver;
    
	@BeforeTest
	public void setUp() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "/Drivers/Chrome91/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
    @Test
	public void test() {
		
		try {
		
		File file = new File("C:\\Users\\Anusha\\Desktop\\Selenium_Training\\Selenium_Training\\TestData\\Module1\\test2.xlsx");
		
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet("LoginData");
		
		XSSFCell cell;
		
		for(int i=1; i<=sheet.getLastRowNum();i++) {
			
			cell = sheet.getRow(i).getCell(0);
			 
			driver.findElement(By.xpath("//input[@type='text'][@name='email']")).clear();
			driver.findElement(By.xpath("//input[@type='text'][@name='email']")).sendKeys(cell.getStringCellValue());
			
			cell = sheet.getRow(i).getCell(1);
			
			driver.findElement(By.xpath("//input[@type='password'][@name='pass']")).clear();
			driver.findElement(By.xpath("//input[@type='password'][@name='pass']")).sendKeys(cell.getStringCellValue());
			
			//driver.findElement(By.xpath("//button[@type='submit'][@name='login']")).click();
			
			//To write data into excel
			
			FileOutputStream fos = new FileOutputStream(file);
			
			String message = "pass";
			
			sheet.getRow(i).getCell(2).setCellValue(message);
			
			workbook.write(fos);
			
		}
		
		}catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
    @AfterTest
	public void tearDown() {
       driver.quit();
	}

}
