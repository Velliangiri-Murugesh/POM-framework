package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void ProductInfoPageTestSetup() {

		accountPage = loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
		homePage = accountPage.clickHomeBtn();

	}

	@Test(priority = 1)

	public void searchAndSelectProduct() {
		String productName = "MacBook Pro";
		productInfoPage = homePage.searchProduct(productName);

	}

	@Test(priority = 2)
	public void verifyProductImg() {

		productInfoPage.getTotalnoImg();
		Assert.assertEquals(productInfoPage.getTotalnoImg(), 4);
	}

	@Test(priority = 3)
	public void getproductInformationData() {
		Map<String, String> productinfoMap = productInfoPage.productInformationData();
		System.out.println(productinfoMap);
		Assert.assertEquals(productinfoMap.get("Brand"), "Apple");
		Assert.assertEquals(productinfoMap.get("Availability"), "Out Of Stock");
		Assert.assertEquals(productinfoMap.get("EXTaxPrice"), "$2,000.00");
		Assert.assertEquals(productinfoMap.get("Price"), "$2,000.00");
		Assert.assertEquals(productinfoMap.get("Product Code"), "Product 18");
		Assert.assertEquals(productinfoMap.get("Reward Points"), "800");
	}

	@Test(priority = 4)
	public void selectQuantity() {
		productInfoPage.selectQuantity("2");
	}

	@Test(priority = 5)
	public void verifyaddtoCart() {
		productInfoPage.addtoCart();
	}

	@Test(priority = 6)
	public void verifyAddreview() {
		productInfoPage.addReview("Product deliverd on time and the quality of packing is very good and tidy");
	}

	@Test(priority = 7)
	public void verifyAddecCart() {
		productInfoPage.addCartverify();
	}

}
