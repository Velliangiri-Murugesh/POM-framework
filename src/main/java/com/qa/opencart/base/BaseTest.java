package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;

public class BaseTest {

	// 1. create Obj and make modifiers as public so that it can be accessed anyy
	// where in the project
	public BasePage basePage;
	public Properties properties;
	public LoginPage loginPage; // Login page class Object
	public HomePage homePage;
	public AccountPage accountPage;
	public ProductInfoPage productInfoPage;
	public RegisterPage registerPage;
	
	// 2. create webdriver reference
	public WebDriver driver;

	// 1. Initialize the browser
	// 2. Call the test methods
	// 3. Create WebDriver reference
	@BeforeTest
	public void Setup() {
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browser = properties.getProperty("browser");
		driver = basePage.init_driver(browser);
        loginPage=new LoginPage(driver); //When we call the obj of loginPage then the LoginPage constructor will be called
		driver.get(properties.getProperty("url"));

	}

	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
