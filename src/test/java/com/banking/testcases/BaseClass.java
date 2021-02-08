package com.banking.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.banking.utilities.ReadConfige;



public class BaseClass {
	
	ReadConfige readconfige =new ReadConfige();
	
	public String baseURL= readconfige.getapplictionurl();
	public String username=readconfige.getusername();
	public String password =readconfige.getuserpass();
	public static WebDriver driver;
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		  
		if(br.equals("chrome"))
		{
			
System.setProperty("webdriver.chrome.driver",readconfige.getchrome());
			
			driver = new ChromeDriver();
		}
		else if (br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfige.getfire());
			driver = new FirefoxDriver();
			
			
		}
		else if (br.equals("ie"))
		{
			
			System.setProperty("webdriver.ie.driver", readconfige.getie());
			
			driver = new InternetExplorerDriver();
			
		}
		   
		
		Logger logger = Logger.getLogger("banking_v1");
			
			PropertyConfigurator.configure("Log4j.properties");
			
			System.setProperty("webdriver.chrome.driver",readconfige.getchrome());
			
			//driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
			driver.get(baseURL);
		
		
		logger.info("Before class end");
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		logger.info("After class");
		
	
			
		}
	
	public void captureScreen(WebDriver diver,String tname)throws IOException{
		TakesScreenshot ts =(TakesScreenshot) diver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
		
		
	}
	
	

}
