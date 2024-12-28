package com.qa.practiceautomation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.practiceautomation.base.BaseTest;
import com.qa.practiceautomation.constrants.AppConstrants;

public class LoginPageTest extends BaseTest {

@Test(priority=1)
public void logInPageUrlTest() {
String url=	lg.getLogInPageUrl();
Assert.assertTrue(url.contains(AppConstrants.LOG_IN_PAGE_URL_FRACTION));
}
@Test(priority=2)
public void logInPageTitleTest() {
String title=	 lg.getLogInPageTitle();
Assert.assertEquals(title,AppConstrants.LOG_IN_PAGE_TITLE );
}
@Test(priority=3)
 public void  logInPageVisibiltyOfTextTest() {
	 Assert.assertTrue(lg.logInPageTextVisibilty());
 }
@Test(priority=4)
 public void logInPageTest() {
	 
	acc=lg.logInPage(prop.getProperty("username"),prop.getProperty("password"));
	
	 Assert.assertTrue(acc.logoutLinkIsVisible());
	 }
	
}
