package com.qa.practiceautomation.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.practiceautomation.exception.FrameworkException;

public class DriverFactory {
  WebDriver driver;
  Properties prop;
  
  public WebDriver initbrowser(Properties prop) {
	  String BrowserName=prop.getProperty("browser");
	  System.out.println("Browser name is: "  +BrowserName);
	  
	  switch (BrowserName.toLowerCase().trim()) {
	case "chrome":
		driver=new ChromeDriver();
		
		break;
	case "firefox":
		driver=new FirefoxDriver();
		
		break;
	case "Edge":
		driver=new EdgeDriver();
		
		break;


	default:
		System.out.println("Plese pass the Right browser:"   +BrowserName);
		throw new FrameworkException("Browser is invalid");
		
		
		
		
		
		
	}
	  driver.manage().deleteAllCookies();
	  driver.manage().window().maximize();
	  driver.get(prop.getProperty("url"));
	  return driver;
  }
  
  public Properties initProp(){
	  prop=new Properties();
	  try {
		FileInputStream ip=new FileInputStream("./src/test/resource/config/config.properties");
		try {
			prop.load(ip);
		} catch (IOException e) {
						e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
				e.printStackTrace();
	}
	  return prop;
	  
	  
	  
	  
	  
	  
	  
  }
	
	
}
