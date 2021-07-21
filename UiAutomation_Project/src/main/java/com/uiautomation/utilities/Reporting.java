package com.uiautomation.utilities;

//listener class used to generate extent reports

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter 
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext) {
		
		String timeStamp =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName ="Test-Report-"+timeStamp+".html";
		
		htmlReporter =new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);//specify location
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		//htmlReporter.loadXMLConfig(System.getProperty("C:/Users/Anusha/eclipse-workspace/InetBankingV1/extent-config.xml"));
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environement", "QA");
		extent.setSystemInfo("user", "Anusha");
		
		htmlReporter.config().setDocumentTitle("InetBanking Test Project"); //title of report
		htmlReporter.config().setReportName("Functional Test automation report"); //Name of report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //Location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
	
	public void onTestSuccess(ITestResult tr) {
		
		logger=extent.createTest(tr.getName());//create new entry in the report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); //send the passed information
		
	}
	
	public void onTestFailure(ITestResult tr) {
		
		logger=extent.createTest(tr.getName());//create new entry in the report
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));//send the passed information
		
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots"+tr.getName()+".png";
		
		File f=new File(screenshotPath);
		
		if(f.exists())
		{
		try {
			logger.fail("screenshot is below: "+logger.addScreenCaptureFromPath(screenshotPath));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	    }
		
     }
	public void onTestSkipped(ITestResult tr) {
		logger=extent.createTest(tr.getName());//create new entry in the report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));//send the passew information
	}
	public void onfinish(ITestContext testContext) {
		extent.flush();
		
	}

}
