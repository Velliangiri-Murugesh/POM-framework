package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.util.ConstantsUtil;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accountPageSetup() {
		// As per POM design the calling method will return the object of home page.So
		// we need to save the Object
		// Or when you call the do login method it is returing object so we are storing
		// here as homePage=
		// homePage=loginPage.doLogin(properties.getProperty("username"),
		// properties.getProperty("password"));
		accountPage = loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
		
	}
	
	@Test(priority=-1)
	
	public void verifyAccountPageTitle() {
		
		accountPage.getAccountPageTitle();
	}
	
	
	@Test(priority=1)
	public void verifyAccountPageheaders() {
		
		
		Assert.assertEquals(accountPage.getAccountHeaders(), ConstantsUtil.accountHeaderTitles());
	}
	
	@Test(priority=2)
	public void verifyAccountHeadersubmenu() {
		
		Assert.assertEquals(accountPage.getAccounSubMenus(), ConstantsUtil.accountHeaderSubmenuTitles());
		
		
	}

}
