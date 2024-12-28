package com.qa.practiceautomation.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.practiceautomation.constrants.AppConstrants;
import com.qa.practiceautomation.utils.ElementUtil;

public class AccountPages {
private WebDriver driver;
	
	ElementUtil ele;
 
	private By logout=By.xpath("//a[text()='Log out']");
	
	private By headerlink=By.xpath("//ul[@id='menu-primary-items']/li");
	
	public AccountPages(WebDriver driver) {
		this.driver=driver;
		ele=new ElementUtil(driver);
	}
	
	public String accPageUrl() {
	String url=	driver.getCurrentUrl();
	System.out.println(url);
	return url;
	}
	
	public String accPageTitle() {
	String title=	ele.WaitForTitleContains(AppConstrants.ACCOUNT_PAGE_TITLE_FRACTION,AppConstrants.SHORT_DEAFAULT_TIME);
	System.out.println(title);
	return title;
	}
	public boolean logoutLinkIsVisible() {
		return ele.waitforVisibilityOfElement(logout, 5).isDisplayed();
		
		}
	public void logout() {
		if(logoutLinkIsVisible()) {
			ele.getclick(logout);
		}
		
		
			
		}
    	public List<String> accPageHeaderLinkVisible() {
    List<WebElement>header=	ele.waitforVisibilityOfElements(headerlink,AppConstrants.SHORT_DEAFAULT_TIME);
    List<String>headerlist=new ArrayList<String>(); 
    
    for(WebElement e:header) {
   String text= e.getText();
    headerlist.add(text);
    }
    return headerlist;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
