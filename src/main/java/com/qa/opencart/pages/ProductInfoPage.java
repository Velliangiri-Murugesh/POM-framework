package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.base.BasePage;
import com.qa.opencart.util.ElementUtil;

public class ProductInfoPage extends BasePage {

	WebDriver driver;
	public ElementUtil elementUtil;

	// By locator

	private By productTitle = By.cssSelector("#content h1");
	private By productMetaData = By.cssSelector("#content  .list-unstyled:nth-of-type(1) li");
	private By productPrice = By.cssSelector("#content  .list-unstyled:nth-of-type(2) li");
	private By productquantity = By.cssSelector("#input-quantity");
	private By addtoCartBtn = By.cssSelector("#button-cart");
	private By productTotalnoimages = By.cssSelector(".thumbnails li img");
	private By writeaReview = By.xpath("//a[text()='Write a review']");
	private By yourName = By.cssSelector("#input-name");
	private By yourReview = By.cssSelector("#input-review");
	private By Rating = By.xpath("//input[@name='rating' and @value='4']");
	private By continueBtn = By.cssSelector("#button-review");
	private By addCartmetadata = By.cssSelector(".dropdown-menu tbody tr td");

	// Constractor
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

	// Method

	public Map<String, String> productInformationData() {

		Map<String, String> productInfoList = new HashMap<>();
		List<WebElement> productMetadataList = elementUtil.getElements(productMetaData);
		for (WebElement webElement : productMetadataList) {
			productInfoList.put(webElement.getText().split(":")[0].trim(), webElement.getText().split(":")[1].trim());
		}
		List<WebElement> productPriceList = elementUtil.getElements(productPrice);
		productInfoList.put("Price", productPriceList.get(0).getText().trim());
		productInfoList.put("EXTaxPrice", productPriceList.get(1).getText().split(":")[1].trim());
		return productInfoList;
	}

	public void selectQuantity(String qty) {

		elementUtil.doSendkeys(productquantity, qty);
	}

	public void addtoCart() {
		elementUtil.doClick(addtoCartBtn);
	}

	public int getTotalnoImg() {
		int totalimages = elementUtil.getElements(productTotalnoimages).size();
		System.out.println("Total no of Images displayed for the Product:" + totalimages);
		return totalimages;
	}

	public void addReview(String reviewValue) {

		elementUtil.doClick(writeaReview);
		elementUtil.doSendkeys(yourReview, reviewValue);
		elementUtil.doClick(Rating);
		elementUtil.doClick(continueBtn);

	}

	
	public void addCartverify() {

		
		List<WebElement> cartList = elementUtil.getElements(addCartmetadata);
		for (WebElement webElement : cartList) {
			System.out.println("sample"+webElement.getText());
			
		}
		
		
	}
}
