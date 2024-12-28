package com.qa.practiceautomation.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.practiceautomation.factory.DriverFactory;
import com.qa.practiceautomation.pages.AccountPages;
import com.qa.practiceautomation.pages.LoginPage;

public class BaseTest {
   
	WebDriver driver ;
	protected	Properties prop;
	DriverFactory df;

	protected LoginPage lg;
	protected AccountPages acc;
	
	@BeforeTest
	public void setup() {
	df=new DriverFactory();
	 prop=  df.initProp();
    driver=	df.initbrowser(prop);

	lg=new LoginPage(driver);
		
	
	
		
	}
	@AfterTest
	public void teardown() {
		driver.quit();
	}
		
	}

