package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.util.ConstantsUtil;
import com.qa.opencart.util.ElementUtil;
import com.qa.opencart.util.JavascriptUtils;

public class LoginPage extends BasePage {

	private WebDriver driver;
	public ElementUtil elementUtil;
	public JavascriptUtils javaScriptUtils;

	// 1. Page Locators : By locators

	private By regicontinueButton = By.xpath("//a[text()='Continue']");
	private By usernameTxtbox = By.xpath("//input[@id='input-email']");
	private By passwordTxtbox = By.xpath("//input[@id='input-password']");
	// private By forgotpwdLink = By.xpath("//a[text()='Forgotten Password']");
	private By loginBtn = By.xpath("//input[@type='submit']");
	// private By privacypolicyLink = By.xpath("//a[text()='Privacy Policy']");
	private By loginerrorTxt = By.xpath("//div[contains(text(),'Warning')]");
	private By menutable = By.xpath("//div[@class='list-group']/a");
	private By currencyDropdown = By.xpath("(//button/i)[1]");
	private By currencyEurovalue = By.xpath("(//button/i/../../ul/li)[1]");
//	private By homeMenubtn = By.xpath("//i[contains(@class,'fa-home')]");
	private By registerLink = By.xpath("(//a[text()='Register'])[2]");

	// 2. Constructor

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

	// 3. Page Actions/ Page Methods

	public String pageTitleExists() {
		elementUtil.waitForTitleTobePresent(ConstantsUtil.LOGIN_PAGE_TITLE, 10);
		String pageTitle = elementUtil.getPageTitle();
		return pageTitle;

	}

	public boolean loginBtnDisabled() {

		return elementUtil.getElementStatus(loginBtn, "Is Enabled");

	}

	public boolean isSignupLinkexist() {

		return elementUtil.getElementStatus(regicontinueButton, "Is Displayed");

	}

	public AccountPage doLogin(String username, String password) {

		elementUtil.doSendkeys(usernameTxtbox, username);
		elementUtil.doSendkeys(passwordTxtbox, password);
		elementUtil.doClick(loginBtn);
		return new AccountPage(driver);

	}

	public String errorTxtLogin() {	

		return elementUtil.doGettext(loginerrorTxt);
	}

	public List<String> doverifyMenuoption() {

		return elementUtil.doGettextofElements(menutable);
	}

	public void currentSelection() {

		elementUtil.doClick(currencyDropdown);
		elementUtil.doClick(currencyEurovalue);
	}

	public RegisterPage navigateToRegsiterPage() {

		elementUtil.doClick(registerLink);
		return new RegisterPage(driver);

	}
}
