package com.qa.opencart.util;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.base.BasePage;

public class ElementUtil {

	WebDriver driver;
	JavascriptUtils jsutil;

	public ElementUtil(WebDriver driver) {

		this.driver = driver;
	 jsutil=new JavascriptUtils(driver);
	}

	public WebElement getElement(By Locator) {
		
		WebElement ele=driver.findElement(Locator);
		if (BasePage.highlight.equals("true")) {
			jsutil.flash(ele);
			
			
		}

		return ele;
	}

	public void doClick(By Locator) {
		getElement(Locator).click();
	}

//	public void doSendKeys(By Locator, String Values) {
//		getElement(Locator).sendKeys(Values);
//
//	}

	public void doClear(By Locator) {
		getElement(Locator).clear();
	}

	public String getPageTitle() {
		String Title = driver.getTitle();
		return Title;
	}

	public void doCompare(By Locator, String ActualValue) {
		String ExpValue = getElement(Locator).getText();
		if (ExpValue.equals(ActualValue)) {
			System.out.println("Actual value and Expected Value are same");
		}

	}

	public void doSelectByIndex(By Locator, int indexvalue) {
		WebElement element = getElement(Locator);
		Select byIndex = new Select(element);
		byIndex.selectByIndex(indexvalue);

	}

	public void doSelectByValue(By Locator, String Value) {
		WebElement element = getElement(Locator);
		Select byValue = new Select(element);
		byValue.selectByValue(Value);
		byValue.selectByVisibleText(Value);

	}

	public void doSelectbyVisibleText(By Locator, String Value) {
		WebElement element = getElement(Locator);
		Select byVisibleText = new Select(element);
		byVisibleText.selectByVisibleText(Value);

	}

	public void jsAlertPopup(By Locator, String Value) throws InterruptedException {
		WebElement element = getElement(Locator);
		element.click();
		Alert alert = driver.switchTo().alert();
		String Text = alert.getText();
		if (Text.equalsIgnoreCase(Value)) {
			alert.accept();
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} else {
			driver.switchTo().defaultContent();

		}
	}

	public void jQueryDropdown(By Locator, String... Value) {

		List<WebElement> elements = getElements(Locator);
		for (int i = 0; i <= elements.size(); i++) {
			String dropDownText = elements.get(i).getText();

			for (int j = 0; j < Value.length; j++) {
				if (dropDownText.equals(Value[j])) {
					elements.get(i).click();
					break;
				}
			}
		}

	}

	public List<WebElement> getElements(By Locator) {
		List<WebElement> ElementList = driver.findElements(Locator);
		return ElementList;

	}

	public void dragAndDrop(By SourceLocator, By TargetLocator) {

		WebElement Source = getElement(SourceLocator);
		WebElement Target = getElement(TargetLocator);
		Actions action = new Actions(driver);
		action.clickAndHold(Source).moveToElement(Target).release().build().perform();

	}

	public void mouseMovement(By Locator) {

		Actions action = new Actions(driver);
		WebElement element = getElement(Locator);
		action.moveToElement(element).perform();

	}

	public void doSendkeys(By Locator, String value) {

		WebElement element = getElement(Locator);
		doClick(Locator);
		element.sendKeys(value);
	}

	public boolean checkWebElementPresent(By Locator) {
		int count = getElements(Locator).size();
		if (count > 0) {
			return true;

		} else {
			return false;
		}

	}

	public WebElement waitForElementTobbeLocated(By Locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(Locator));

	}

	public Boolean waitForTitleTobePresent(String Title, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.titleIs(Title));

	}

	public void clickWhenReady(By Locator, int Waittime) {
		WebElement element = getElement(Locator);

		WebDriverWait wait = new WebDriverWait(driver, Waittime);
		WebElement Wb = wait.until(ExpectedConditions.elementToBeClickable(element));
		Wb.click();

	}

	public boolean checkUrltext(String urltext, int Waittime) {

		WebDriverWait wait = new WebDriverWait(driver, Waittime);
		boolean value = wait.until(ExpectedConditions.urlContains(urltext));
		if (value = true) {
			System.out.println("Url is Present");
		} else {
			System.out.println("Url is not present");
		}
		return value;

	}

	public WebElement FluentWait(By Locator, int timeout, int pollingtime) {

		Wait<WebDriver> waitingfor = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(pollingtime)).ignoring(NoSuchElementException.class);
		return waitingfor.until(ExpectedConditions.presenceOfElementLocated(Locator));

	}

	public WebElement retryElement(By Locator) {

		WebElement element = null;
		int attempt = 0;

		while (attempt < 20) {
			try {

				element = driver.findElement(Locator);
				break;

			} catch (StaleElementReferenceException e) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {

				}
			}

			catch (NoSuchElementException e) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {

				}
				System.out.println("Attempted to find the element:" + attempt);
			}
			attempt++;

		}
		return element;

	}

	public String doGettext(By Locator) {

		String text = getElement(Locator).getText();
		return text;
	}

//	public boolean getElementStatus(By Locator, String elementStatus) {
//		
//		switch (elementStatus) {
//		case "is Displayed":
//			boolean value=getElement(Locator).isDisplayed();
//			break;
//		case "is Enabled":
//			boolean value1=getElement(Locator).isEnabled();
//			break;
//		case "is Selected":
//			boolean value2=getElement(Locator).isSelected();
//			break;
//		default:
//			break;
//		}
//		return false;
//		
//}

	public boolean getElementStatus(By Locator, String elementStatus) {

		if (elementStatus.equalsIgnoreCase("Is Displayed")) {
			boolean value = getElement(Locator).isDisplayed();
			return value;
		} else if (elementStatus.equalsIgnoreCase("Is Selected")) {
			boolean value = getElement(Locator).isSelected();
			return value;
		} else if (elementStatus.equalsIgnoreCase("Is Enabled")) {
			boolean value = getElement(Locator).isEnabled();
			return value;
		}
		return false;

	}

	public List<String> doGettextofElements(By Locators) {

		List<String> text = new ArrayList<String>();
		List<WebElement> elements = getElements(Locators);
		for (WebElement e : elements) {
			text.add(e.getText());

		}
		return text;

	}
}
