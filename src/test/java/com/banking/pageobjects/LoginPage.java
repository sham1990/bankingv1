package com.banking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	 WebDriver ldriver;
	 
	 public LoginPage(WebDriver rdriver)
	 {
		 ldriver=rdriver;
		 PageFactory.initElements(rdriver, this);
	 	 	 
	 }
	 
	 @FindBy(name="uid")
	 WebElement txtUserName;
	 
	 @FindBy(name="password")
	 WebElement txtpassword;
	 
	 @FindBy(name="btnlogin")
	 WebElement btnLogin;
	 
	 @FindBy(xpath="/html/body/div[3]")
	 WebElement lnkLogout;
	 
	 
	 public void setUserName(String uname)
	 {
		 txtUserName.sendKeys(uname);
	 }
	 
	 public void setPassword(String pwd)
	 {
		 txtpassword.sendKeys(pwd);
	 }
	 
	 public void clickSubmit()
	 {
		 btnLogin.click();
	 }
	 
	 public void clickLogout()
	 {
		 lnkLogout.click();
	 }
	
	 
}
