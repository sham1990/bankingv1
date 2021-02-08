package com.banking.utilities;


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
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
 public ExtentSparkReporter htmlReporter;
 public ExtentReports extent;
 public ExtentTest logger;

 public void onStart(ITestContext testcontext )
  {
	 String timeStamp = new SimpleDateFormat("yyy.MM.HH.mm.ss").format(new Date());
	 String reportName = "Test-Report-"+timeStamp+".html";
	 
	 htmlReporter =new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+reportName);
	 
	 try {
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 extent =new ExtentReports();
	 
	 extent.attachReporter(htmlReporter);
	 extent.setSystemInfo("Host name", "localhost");
	 extent.setSystemInfo("Environment", "QA");
	 extent.setSystemInfo("user", "sham");
	 
	 htmlReporter.config().setDocumentTitle("banking test project");
	 htmlReporter.config().setReportName("Functional Test Report");
	 htmlReporter.config().setTheme(Theme.DARK);
	 
  }
	
 public void onTestSuccess(ITestResult tr)
 {
	
	 logger =extent.createTest(tr.getName());
	 logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	 	 
 }
 
 public void onTestFail(ITestResult tr)
 {
	
	 logger =extent.createTest(tr.getName());
	 logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	 
	 String screenshotpath =System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
	 
	 File f = new File(screenshotpath);
	 if (f.exists())
	 {
		 
		 logger.fail("screenshot is below"+logger.addScreenCaptureFromPath(screenshotpath));
	 }
	 
	/* public void  onTestSkipped(ITestResult tr)
	 {
		 
	 }
	 
	 public void  onFinish(ITestResult tr)
	 {
		 
	 }*/
	 
	 
	 
	 	 
 }
 
}
