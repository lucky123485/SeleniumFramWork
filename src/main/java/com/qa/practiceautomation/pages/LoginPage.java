package com.qa.practiceautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.practiceautomation.constrants.AppConstrants;
import com.qa.practiceautomation.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	ElementUtil ele; 
	
	   private	By username=By.id("username");
	   private	By password=By.id("password");
		private By submit=By.id("submit");
		private By textvisibilty=By.xpath("//h5[text()='Test case 1: Positive LogIn test']");
		
		
	    public LoginPage(WebDriver driver) {
		this.driver=driver;
		ele=new ElementUtil(this.driver);
		

	}
	
	public String  getLogInPageUrl() {
	String url=	driver.getCurrentUrl();
	System.out.println(url);
	return url;
	}
	public String getLogInPageTitle() {
    String title=		ele.WaitForTitleIs(AppConstrants.LOG_IN_PAGE_TITLE, AppConstrants.SHORT_DEAFAULT_TIME);
     return title;
	}
	public boolean logInPageTextVisibilty() {
	return	ele.waitforVisibilityOfElement(textvisibilty,AppConstrants.SHORT_DEAFAULT_TIME).isDisplayed();
	}
	
	public AccountPages logInPage(String userName,String passWord) {
		ele.waitforVisibilityOfElement(username, AppConstrants.SHORT_DEAFAULT_TIME).sendKeys(userName);
		ele.dosendKeys(password, passWord);
		ele.getclick(submit);
		System.out.println("user looged in");
		return new AccountPages(driver);
		
	}

}
