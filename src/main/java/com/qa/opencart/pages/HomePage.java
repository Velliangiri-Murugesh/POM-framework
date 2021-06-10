package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.util.ConstantsUtil;
import com.qa.opencart.util.ElementUtil;

public class HomePage extends BasePage {

	// WebDriver Reference
	private WebDriver driver;
	private ElementUtil elementUtil;

	// By Locator
	private By yourStore = By.xpath("//a[text()='Your Store']");
	private By searchTxtbox = By.xpath("//input[@name='search']");
	private By searchBtn = By.xpath("//input[@name='search']/../child::span/button");
	private By cartBt = By.xpath("//div[@id='cart']");
	private By featuredHeaderTxt = By.xpath("//h3[text()='Featured']");
	private By productSearchList=By.cssSelector(".product-layout div h4 a");
	private By messageCart=By.cssSelector("#product-product .alert");
	private By cartButton=By.cssSelector("#cart-total");
	
	// constructor

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil=new ElementUtil(driver);

	}

	// Test Method

	public String getHomePageTitle() {
		//return driver.getTitle();
		elementUtil.waitForTitleTobePresent(ConstantsUtil.HOME_PAGE_TITLE, 20);
		return elementUtil.getPageTitle();
	}

	public boolean getUrl(String word) {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Url in the page is:"+currentUrl);
		if (currentUrl.contains(word)) {
			System.out.println("Home Page url");
			return true;
		} else {
			System.out.println("This is not home page URL");
		}
		return false;
	}

	public String storeHeadercheck() {
		return elementUtil.doGettext(yourStore);
		
		
	}

	public ProductInfoPage searchProduct(String value) {

		elementUtil.doSendkeys(searchTxtbox, value);
		elementUtil.doClick(searchBtn);
		clickontheSearch(value);
		return new ProductInfoPage(driver);

	}
	
	public void clickontheSearch(String value) {
		List<WebElement> list=elementUtil.getElements(productSearchList);
		for (WebElement webElement : list) {
			if(webElement.getText().equals(value)) {
				webElement.click();
				break;
			}
			
			else {
				System.out.println("Product is not displayed");
			}
			
		}
	}

	public boolean CartBtndisplay() {
		return elementUtil.getElementStatus(cartBt, "Is displayed");
	}

	public boolean featureTxtdisplay() {
		
		return elementUtil.getElementStatus(featuredHeaderTxt, "Is displayed");
	}
	
}
