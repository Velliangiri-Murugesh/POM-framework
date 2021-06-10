package com.qa.opencart.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.opencart.util.OptionsManagerUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver; // All the class will direct access to it So modifier is used as Public

	public Properties prop;
	public static String highlight;
	OptionsManagerUtil options = new OptionsManagerUtil(prop);
	public static ThreadLocal<WebDriver> tlocal = new ThreadLocal<WebDriver>();
	

	/*
	 * To initialize the driver
	 * 
	 * @param Pass the BrowserName from config.properties files
	 * 
	 * @return - Once the driver is initialize the driver will be returned
	 */
	public WebDriver init_driver(String browserName) {


		System.out.println("Browser used to test the test case is:" + browserName);
		highlight=prop.getProperty("highlight");
		options = new OptionsManagerUtil(prop);

		if (browserName.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver(browserOptionUtil.getChromeOptions());
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remotedriver(browserName);

			} else {
				tlocal.set(new ChromeDriver(options.getChromeOptions()));// Set method is used to pass the
																						// webdriver.
			}

		}

		else if (browserName.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver(browserOptionUtil.getFirefoxOptions());
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remotedriver(browserName);

			} else {
				tlocal.set(new FirefoxDriver(options.getFirefoxOptions()));
			}
		}

		else {

			System.out.println("Provided browser" + " " + browserName + " " + "is not valid. Please check one...!");
		}

		// temporary

		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// return driver;
		return getDriver();

	}

	public void init_remotedriver(String browserName) {

		if (browserName.equals("chrome")) {

			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, options.getChromeOptions());
			try {
				tlocal.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), cap));
			} catch (MalformedURLException e) {

				e.printStackTrace();
			}
		} else if (browserName.equals("firefox")) {
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.getFirefoxOptions());
			try {
				tlocal.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), cap));
			} catch (MalformedURLException e) {

				e.printStackTrace();
			}

		}
	}

	/*
	 * Whenever we create a copy of the driver , we should ake the driver in sync.
	 * We are using Synchronization
	 */
	public static synchronized WebDriver getDriver() {
		return tlocal.get();

	}

	/*
	 * Method: Used to intialize the properties from config file
	 * 
	 * @return properties
	 */

	public Properties init_properties() {

		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream("./src/main/java/com/qa/opencart/config/config.properties"); // Object
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}
	
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}



}
