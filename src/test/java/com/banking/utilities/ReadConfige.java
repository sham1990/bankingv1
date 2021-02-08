package com.banking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfige {
	
	Properties pro = new Properties() ;
	
	public ReadConfige()
	{
		
		
		File src  = new File("./configuration/config.properties");
		
		try {
			
			FileInputStream fis = new FileInputStream(src);
			pro.load(fis);			
			
		}catch(Exception e) {
			
			System.out.println("Exception is "+e.getMessage());
			
		}
	}
	
	public String getapplictionurl()
	{
		String url = pro.getProperty("baseURL");
		return url;
		
	}
	
	public String getusername() {
		
		String user =pro.getProperty("username");
		return user;
		
	}
	
	public String getuserpass()
	{
		
		String pass = pro.getProperty("password");
		return pass;
		
	}
	
	public String getchrome()
	{
		String chrome = pro.getProperty("chromepath");
		return chrome;
	}
	
	public String getie()
	{
		String ie =pro.getProperty("iepath");
		return ie;
	}
	
	public String getfire()
	{
		String fire = pro.getProperty("firefoxpath");
		
		return fire;
		
	}
	
	
	}


