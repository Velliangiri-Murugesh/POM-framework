package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.util.ConstantsUtil;

public class HomePageTest extends BaseTest {

	@BeforeClass
	public void homePageSetup() {
		// As per POM design the calling method will return the object of home page.So
		// we need to save the Object
		// Or when you call the do login method it is returing object so we are storing
		// here as homePage=
	//homePage=loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
		homePage=accountPage.clickHomeBtn();


	}

	@Test(priority = 1)
	public void verifyHomePageTitle() {
		String homePageTitle = homePage.getHomePageTitle();
		Assert.assertEquals(homePageTitle, ConstantsUtil.HOME_PAGE_TITLE, "Home page Title is not as expected");

	}

	@Test(priority = 2)

	public void verifyUrl() {
		boolean value = homePage.getUrl("home");
		Assert.assertEquals(value, true);

	}

	@Test(priority = 3)
	public void docheckStoreheader() {
		String value = homePage.storeHeadercheck();
		Assert.assertEquals(value, "Your Store");
	}

	@Test(priority = 6,enabled=true)
	public void doSearch() {

		homePage.searchProduct("Mac");
	}

	@Test(priority = 4)
	public void verifyCartdisplay() {

		boolean value = homePage.CartBtndisplay();
		Assert.assertEquals(value, "true");

	}

	@Test(priority = 5)
	public void verifyfeatureText() {
		boolean value = homePage.featureTxtdisplay();
		Assert.assertEquals(value, "true");

	}
	
	
	
	

}
