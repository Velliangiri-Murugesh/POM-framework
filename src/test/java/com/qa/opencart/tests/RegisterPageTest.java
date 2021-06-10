package com.qa.opencart.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.listeners.ExtentReportListener;
import com.qa.opencart.util.ConstantsUtil;
import com.qa.opencart.util.ExcelUtil;

@Listeners(ExtentReportListener.class)
public class RegisterPageTest extends BaseTest {

	@BeforeClass
	public void RegisterPageSetup() {

		registerPage = loginPage.navigateToRegsiterPage();

	}

	@DataProvider
	public Object[][] getTestDatafromexcel() {

		Object Testdata[][] = ExcelUtil.getTestData(ConstantsUtil.REGISTER_ACCOUNT_DATA);
		return Testdata;
	}

	@Test(dataProvider ="getTestDatafromexcel" )
	public void userRegistration(String FirstName, String LastName, String Email, String Telephone, String Password,
			String Newsletter) {

		// registerPage.fillform("ABC", "ABCDE", "Abc2025@yui.com", "4512541010",
		// "Pass123", "Yes");
		registerPage.fillform(FirstName,LastName,Email,Telephone,Password,Newsletter);

	}
}
