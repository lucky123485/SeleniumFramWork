package com.qa.practiceautomation.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.practiceautomation.base.BaseTest;
import com.qa.practiceautomation.constrants.AppConstrants;

public class AccountPageTest extends BaseTest {
	
	@BeforeClass
	
	public void accountPageSetup() {
	acc=lg.logInPage(prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test
	public void accPageUrlTest() {
	String url=	acc.accPageUrl();
	Assert.assertTrue(url.contains(AppConstrants.ACCOUNT_PAGE_URL_FRACTION));
	}
	@Test
	public void accPageTitleTest() {
		String title=acc.accPageTitle();
		Assert.assertTrue(title.contains(AppConstrants.ACCOUNT_PAGE_TITLE_FRACTION));
	}
	@Test
	public void accPageLogoutLinkExistTest() {
		Assert.assertTrue(acc.logoutLinkIsVisible());
	}
	@Test
	public void accPageHeaderTest() {
	List<String> header=	acc.accPageHeaderLinkVisible();
	System.out.println(header.size());
	Assert.assertEquals(header,AppConstrants.ACCOUNT_PAGE_HEADER_LIST);
	}
	
	
	
}
