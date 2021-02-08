package com.banking.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;
import com.banking.pageobjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass

{
	
	
	@Test
	public void loginTest()
	
	{
		
		driver.get(baseURL);
		
		logger.info("URL is open");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("usernae entered");
		lp.setPassword(password);
		logger.info("password entered");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manger Homepage"))
		{
			
			Assert.assertTrue(true);
			logger.info("login success");
		}
		else
		{
			try {
				captureScreen(driver,"logintest");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false);
			logger.info("login failed");
		}
		
		
	}
	
	
}
