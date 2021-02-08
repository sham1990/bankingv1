package com.banking.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.pageobjects.LoginPage;
import com.banking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	@Test(dataProvider ="LoginData")
	public void loginDDt()
	{
		LoginPage lp =new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		if(isAlertpresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertFalse(false);
		}
		else
			
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
			
		}
		
	}

	
	public boolean isAlertpresent()
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	 @DataProvider(name ="LoginData")
	 String [][] getData() throws IOException
	 {
		 
		 String path=System.getProperty("user.dir")+"";
		 
		 int rownum=XLUtils.getrowCount(path, "Sheet1");
		 int cocount=XLUtils.getCellCount(path, "Sheet", 1);
		 String logindata[][]=new String [rownum][cocount];
		 for (int i=1;i<=rownum;i++)
		 {
			 for (int j=0;j<cocount;j++)
			 {
				 logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			 }
		 }
		 
		 return logindata;
		 
	 }
	 
}
