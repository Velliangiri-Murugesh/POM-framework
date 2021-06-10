package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.util.ConstantsUtil;
import com.qa.opencart.util.ElementUtil;

public class RegisterPage extends BasePage {

	WebDriver driver;
	public ElementUtil elementUtil;

	// By Locators

	private By registerHeader = By.xpath("//h1[contains(text(),'Register')]");
	private By firstnametxtBox = By.cssSelector("#input-firstname");
	private By lastnametxtBox = By.cssSelector("#input-lastname");
	private By emailtxtBox = By.cssSelector("#input-email");
	private By telephonetxtBox = By.cssSelector("#input-telephone");
	private By passwordtxtBox = By.cssSelector("#input-password");
	private By confirmpasswordtxtBox = By.cssSelector("#input-confirm");
	private By newsLetterYesBtn = By.cssSelector(".radio-inline:nth-of-type(1) input");
	private By newsLetterNoBtn = By.cssSelector(".radio-inline:nth-of-type(2) input");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
	private By privacyLink = By.cssSelector(".buttons b");
	private By privacyChkBox = By.xpath("//input[@type='checkbox' and @name='agree']");
	private By privacycloseBtn = By.cssSelector(".close");
	private By accountSuccessheader = By.xpath("//h1[contains(text(),'Your Account')]");
	private By logout = By.xpath("/html/body/div[2]/div/aside/div/a[13]");
	private By logoutHeader = By.xpath("(//h1[contains(text(),'Logout')])[1]");
	private By registerlink = By.xpath("(//a[contains(text(),'Register')])[2]");

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public void fillform(String fname, String lname, String email, String telephone, String password, String YesNo) {

		elementUtil.getElement(registerHeader).isDisplayed();
		elementUtil.getElement(firstnametxtBox).sendKeys(fname);
		elementUtil.getElement(lastnametxtBox).sendKeys(lname);
		elementUtil.getElement(emailtxtBox).sendKeys(email);
		elementUtil.getElement(telephonetxtBox).sendKeys(telephone);
		elementUtil.getElement(passwordtxtBox).sendKeys(password);
		elementUtil.getElement(confirmpasswordtxtBox).sendKeys(password);
		if (YesNo.equals("Yes")) {
			elementUtil.doClick(newsLetterYesBtn);

		} else if (YesNo.equals("No")) {
			elementUtil.doClick(newsLetterNoBtn);

		}
		elementUtil.doClick(privacyLink);
		elementUtil.doClick(privacycloseBtn);
		elementUtil.doClick(privacyChkBox);
		elementUtil.doClick(continueButton);
		String Actual = elementUtil.doGettext(accountSuccessheader);
		if (Actual.equals(ConstantsUtil.ACCOUNT_CREATION_SUCESS_FILE)) {
			System.out.println("Account is created");
			elementUtil.doClick(logout);
			String Logoutheader = elementUtil.doGettext(logoutHeader);
			if (Logoutheader.equals(ConstantsUtil.ACCOUNT_LOGOUT_HEADER_TITLE)) {
				
				elementUtil.doClick(registerlink);
				
			}

		} else {
			System.out.println("Account is not created");
		}

	}
}