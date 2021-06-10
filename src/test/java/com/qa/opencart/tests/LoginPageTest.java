package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.util.ConstantsUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginPageTest extends BaseTest {

	@Description("Verify the LoginPage Title is Displayed")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=1)
	public void verifyPageTitle() {

		String titleName = loginPage.pageTitleExists();
		Assert.assertEquals(titleName, ConstantsUtil.LOGIN_PAGE_TITLE,
				"Page title is not displayed or it is incorrect");

	}

	@Description("Verify the LoginBtn is displayed and Enabled in loginPage ")
	@Severity(SeverityLevel.NORMAL)

	@Test(priority=2)
	public void verifyLoginBtnstatus() {

		boolean value = loginPage.loginBtnDisabled();
		Assert.assertEquals(value, true, "Login button is enabled.. ");
	}
	

	@Description("Verify the Resgitser button link exist ")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=3)
	public void verifyNewRegistration() {

		boolean value = loginPage.isSignupLinkexist();
		Assert.assertEquals(value, true, "Continue button is not present.. ");

	}

	@Description("Verify the Login is working")
	@Severity(SeverityLevel.CRITICAL)

	@Test(priority=5)

	public void verifyLogin() {

		loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
	}

//	@Test(priority=4,dependsOnMethods="verifyLogin")
//
//	public void verifyErrormessage() {
//		String errormessage = loginPage.errorTxtLogin();
//		Assert.assertEquals(errormessage, ConstantsUtil.LOGIN_ERROR_MESSAGE);
//	}
	@Description("Verify the Login menu options are displayed")
	@Severity(SeverityLevel.CRITICAL)

	@Test(priority=4)
	public void verifymenuOption() {
    Assert.assertEquals(loginPage.doverifyMenuoption(), ConstantsUtil.expMenyoptions());

	}
	
	@Description("Verify the Login menu options are displayed")
	@Severity(SeverityLevel.TRIVIAL)
	@Test(priority=-1)
	public void selectCurrentDropdown() {
		loginPage.currentSelection();

	}

}
