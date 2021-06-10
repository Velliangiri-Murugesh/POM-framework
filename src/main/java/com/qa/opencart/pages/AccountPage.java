package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.util.ConstantsUtil;
import com.qa.opencart.util.ElementUtil;

public class AccountPage extends BasePage {

	WebDriver driver;
	private ElementUtil elementUtil;

//By Locator

	private By accountHeaderTitles = By.cssSelector("div#content h2");
	private By accountHeaderSubmenus = By.cssSelector("#content ul li");
	private By homeMenubtn = By.xpath("//i[contains(@class,'fa-home')]");

	// Constuctor

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

	public void getAccountPageTitle() {
		elementUtil.waitForTitleTobePresent(ConstantsUtil.ACCOUNT_PAGE_TITLE, 30);
		elementUtil.getPageTitle();

	}

	public List<String> getAccountHeaders() {
		List<String> HeaderTitle = elementUtil.doGettextofElements(accountHeaderTitles);
		return HeaderTitle;

	}

	public List<String> getAccounSubMenus() {
		List<String> HeaderSubmenuTitle = elementUtil.doGettextofElements(accountHeaderSubmenus);
		return HeaderSubmenuTitle;

	}

	public HomePage clickHomeBtn() {
		elementUtil.doClick(homeMenubtn);
		return new HomePage(driver);
	}

}
