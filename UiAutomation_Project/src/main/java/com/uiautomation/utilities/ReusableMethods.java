package com.uiautomation.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class ReusableMethods {

	static Logger log = Logger.getLogger(ReusableMethods.class);
	private static WebDriver driver;

	@SuppressWarnings("static-access")
	public ReusableMethods(WebDriver driver) {
		super();
		log.info("ElementUtil WebDriver WeInitiated");
		this.driver = driver;
	}

	public static boolean insertText(By locator, String value) {

		boolean flag = false;
		log.info("insertText is Initiated");

		try {
			WebElement field = driver.findElement(locator);
			field.clear();
			field.sendKeys(value);
			flag = true;
			log.info("insertText functions is executed with locator:" + locator + "Keys: " + value);
			return flag;
		} catch (Exception Ex) {
			log.info("insertText is has exception could be due to loctor issue please check");
			return flag;
		}
	}

	public static boolean toClick(By locator) {

		boolean flag = false;
		log.info("toClick is Initiated");

		try {
			WebElement field = driver.findElement(locator);
			field.click();
			flag = true;
			log.info("toClick functions is executed:");
			return flag;
		} catch (Exception Ex) {
			log.info("toClick is has exception could be due to loctor issue please check");
			return flag;
		}
	}

	public static boolean isDisplayed(By locator) {

		boolean flag = false;
		log.info("isDisplayed is Initiated");

		try {
			WebElement field = driver.findElement(locator);
			field.isDisplayed();
			flag = true;
			log.info("isDisplayed functions is executed:");
			return flag;
		} catch (Exception Ex) {
			log.info("isDisplayed is has exception could be due to loctor issue please check");
			return flag;
		}
	}

	public static boolean isSelected(String locator, String locvalue) {
		boolean flag = false;
		log.info("isSelected is Initiated");

		try {
			WebElement field = ReusableMethods.LocateElementBy(locator, locvalue);
			flag = field.isSelected();
			log.info("isSelected functions is executed:");
			return flag;
		} catch (Exception Ex) {
			log.info("isSelected is has exception could be due to loctor issue please check");
			return flag;
		}
	}

	public boolean isEnabled(By locator) {
		boolean flag = false;
		log.info("isEnabled is Initiated");

		try {
			WebElement field = driver.findElement(locator);
			flag = field.isEnabled();
			log.info("isEnabled functions is executed:");
			return flag;
		} catch (Exception Ex) {
			log.info("isEnabled is has exception could be due to loctor issue please check");
			return flag;
		}
	}

	public int rowAndColCount(String locator, String locvalue) {
		log.info("rowAndColCount is Initiated");
		int count = 0;
		try {
			List<WebElement> value = ReusableMethods.LocateElementsBy(locator, locvalue);
			count = value.size();
			log.info("rowAndColCount functions is executed:");
			return count;
		} catch (Exception Ex) {
			log.info("rowAndColCount is has exception could be due to loctor issue please check");
			return 0;
		}
	}

	public String getCellValue(String locator, String locvalue) {

		log.info("getCellValue is Initiated");

		try {
			WebElement field = ReusableMethods.LocateElementBy(locator, locvalue);
			String cellValue = field.getText();
			log.info("getCellValue functions is executed:");
			return cellValue;
		} catch (Exception Ex) {
			log.info("getCellValue is has exception could be due to loctor issue please check");
			return null;
		}
	}

	public void selectDropDownValue(String locator, String locvalue, String type, String value) {

		log.info("selectDropDownValue is Initiated");

		try {
			Select select = new Select(ReusableMethods.LocateElementBy(locator, locvalue));
			switch (type) {
			case "index":
				select.selectByIndex(Integer.parseInt(value));
				break;
			case "value":
				select.selectByValue(value);
				break;
			case "visibletext":
				select.selectByVisibleText(value);
				;
				break;

			default:
				break;
			}
			log.info("selectDropDownValue functions is executed:");
		} catch (Exception Ex) {
			log.info("selectDropDownValue is has exception could be due to loctor issue please check");
		}
	}

	public boolean deSelectAll(String locator, String locvalue) {

		boolean flag = false;
		log.info("deSelectAll  is Initiated");

		try {
			Select select = new Select(ReusableMethods.LocateElementBy(locator, locvalue));
			select.deselectAll();
			flag = true;
			log.info("deSelectAll functions is executed:");
			return flag;
		} catch (Exception Ex) {
			log.info("deSelectAll is has exception could be due to loctor issue please check");
			return flag;
		}
	}

	public boolean selectMultiDropDownValue(String locator, String locvalue, String type, String[] array) {

		boolean flag = false;
		log.info("selectMultiDropDownValue is Initiated");

		Select select = new Select(LocateElementBy(locator, locvalue));
		try {
			if (type == "visibletext") {
				for (int i = 0; i < array.length; i++) {
					select.selectByVisibleText(array[i]);
					log.info("selectMultiDropDownValue functions is executed:");
				}
				flag = true;
				return flag;
			} else if (type == "value") {
				for (int i = 0; i < array.length; i++) {
					select.selectByValue(array[i]);
					log.info("selectMultiDropDownValue functions is executed:");
				}
				flag = true;
				return flag;
			} else if (type == "index") {
				for (int i = 0; i < array.length; i++) {
					select.selectByIndex(Integer.parseInt(array[i]));
					log.info("selectMultiDropDownValue functions is executed:");
				}
				flag = true;
				return flag;
			}
			log.info("selectMultiDropDownValue functions is executed:");
			return flag;
		} catch (Exception Ex) {
			log.info("selectMultiDropDownValue is has exception could be due to loctor issue please check");
			return flag;
		}
	}

	public boolean deselectMultipleByValues(String locator, String locvalue, String type, String[] array) {
		boolean flag = false;
		log.info("DeselectDropDownValue is Initiated");
		Select select = new Select(ReusableMethods.LocateElementBy(locator, locvalue));
		try {
			if (type == "visibletext") {
				for (int i = 0; i < array.length; i++) {
					select.deselectByVisibleText(array[i]);
					log.info("deSelectByvisibletext functions is executed:");
				}
				flag = true;
				return flag;
			} else if (type == "value") {
				for (int i = 0; i < array.length; i++) {
					select.deselectByValue(array[i]);
					log.info("deSelectByvalue functions is executed:");
				}
				flag = true;
				return flag;
			} else if (type == "index") {
				for (int i = 0; i < array.length; i++) {
					select.deselectByIndex(Integer.parseInt(array[i]));
					log.info("deSelectByindex functions is executed:");
				}
				flag = true;
				return flag;
			}
		} catch (Exception Ex) {
			log.info("DeselectDropDownValue is has exception could be due to loctor issue please check");

			return flag;
		}
		return flag;
	}

	public void selectAllCheckBoxes(String locator, String locvalue) {

		log.info("selectAllCheckBoxes function Initiated");

		try {
			List<WebElement> list = ReusableMethods.LocateElementsBy(locator, locvalue);
			for (WebElement e : list) {
				if (!e.isSelected()) {
					e.click();
					Thread.sleep(2000);
				}
			}
			log.info("selectAllCheckBoxes functions is executed");
		} catch (Exception Ex) {
			log.info("selectAllCheckBoxes is has exception could be due to loctor issue please check");
		}
	}

	public boolean checkAndUncheck(String locator, String locvalue) {

		boolean flag = false;
		log.info("checkAndUncheck is Initiated");

		try {
			WebElement field = LocateElementBy(locator, locvalue);
			if (field.isSelected() == true) {
				field.click();
			} else {
				field.click();
			}
			flag = true;
			log.info("checkAndUncheck functions is executed:");
			return flag;
		} catch (Exception Ex) {
			log.info("checkAndUncheck is has exception could be due to loctor issue please check");
			return flag;
		}
	}

	public boolean selectRadioButton(String locator, String locvalue) {

		boolean flag = false;
		log.info("SelectRadio Button Initiated");

		try {
			WebElement radio = LocateElementBy(locator, locvalue);
			radio.click();
			flag = true;
			log.info("SelectRadiobutton functions is executed");
			return flag;
		} catch (Exception Ex) {
			log.info("SelectRadio button is has exception could be due to loctor issue please check");
			return flag;
		}
	}

	public static WebElement LocateElementBy(String type, String value) {
		log.info("LocateElementBy functions is Initiated");
		try {
			if (type == "name") {
				WebElement element = driver.findElement(By.name(value));
				log.info("LocateElementBy name functions is executed");
				return element;
			} else if (type == "id") {
				WebElement element = driver.findElement(By.id(value));
				log.info("LocateElementBy id functions is executed");
				return element;
			} else if (type == "className") {
				WebElement element = driver.findElement(By.className(value));
				log.info("LocateElementBy classname functions is executed");
				return element;
			} else if (type == "tagName") {
				WebElement element = driver.findElement(By.tagName(value));
				log.info("LocateElementBy tagName functions is executed");
				return element;
			} else if (type == "linkText") {
				WebElement element = driver.findElement(By.linkText(value));
				log.info("LocateElementBy linkText functions is executed");
				return element;
			} else if (type == "partialLinkText") {
				WebElement element = driver.findElement(By.partialLinkText(value));
				log.info("LocateElementBy partialLinkText functions is executed");
				return element;
			} else if (type == "xpath") {
				WebElement element = driver.findElement(By.xpath(value));
				log.info("LocateElementBy xpath functions is executed");
				return element;
			} else if (type == "cssSelector") {
				WebElement element = driver.findElement(By.cssSelector(value));
				log.info("LocateElementBy cssSelector functions is executed");
				return element;
			}
		} catch (Exception Ex) {
			log.info("LocateElementBy is has exception could be due to loctor issue please check");

		}
		return null;
	}

	public static List<WebElement> LocateElementsBy(String type, String value) {
		log.info("LocateElementsBy functions is Initiated");
		try {
			if (type == "name") {
				List<WebElement> elements = driver.findElements(By.name(value));
				log.info("LocateElementsBy name functions is executed");
				return elements;
			} else if (type == "id") {
				List<WebElement> elements = driver.findElements(By.id(value));
				log.info("LocateElementsBy id functions is executed");
				return elements;
			} else if (type == "className") {
				List<WebElement> elements = driver.findElements(By.className(value));
				log.info("LocateElementsBy classname functions is executed");
				return elements;
			} else if (type == "tagName") {
				List<WebElement> elements = driver.findElements(By.tagName(value));
				log.info("LocateElementsBy tagName functions is executed");
				return elements;
			} else if (type == "linkText") {
				List<WebElement> elements = driver.findElements(By.linkText(value));
				log.info("LocateElementsBy linkText functions is executed");
				return elements;
			} else if (type == "partialLinkText") {
				List<WebElement> elements = driver.findElements(By.partialLinkText(value));
				log.info("LocateElementsBy partialLinkText functions is executed");
				return elements;
			} else if (type == "xpath") {
				List<WebElement> elements = driver.findElements(By.xpath(value));
				log.info("LocateElementsBy xpath functions is executed");
				return elements;
			} else if (type == "cssSelector") {
				List<WebElement> elements = driver.findElements(By.cssSelector(value));
				log.info("LocateElementsBy cssSelector functions is executed");
				return elements;
			}
		} catch (Exception Ex) {
			log.info("LocateElementsBy is has exception could be due to loctor issue please check");

		}
		return null;
	}

	public boolean alertHandling(String type, String keys) {
		boolean flag = false;
		log.info("AlertHandling is Initiated");
		try {
			if (type == "accept") {
				driver.switchTo().alert().accept();
				log.info("Alertaccept functions is executed");
				flag = true;
				return flag;
			} else if (type == "dismiss") {
				driver.switchTo().alert().dismiss();
				log.info("Alertdismiss functions is executed");
				flag = true;
				return flag;
			} else if (type == "gettext") {
				driver.switchTo().alert().getText();
				log.info("AlertgetText functions is executed");
				flag = true;
				return flag;
			} else if (type == "sendkeys") {
				driver.switchTo().alert().sendKeys(keys);
				log.info("AlertSendkeys functions is executed");
				flag = true;
				return flag;
			}
		} catch (Exception Ex) {
			log.info("AlertHandling is has exception could be due to loctor issue please check");
			return flag;
		}
		return flag;
	}

	public void switchToWindowBy(String type, String value) {
		try {
			Set<String> windows = driver.getWindowHandles();
			log.info("switchToWindowBy functions is Initiated");
			if (windows.size() != 0) {
				for (String window : windows) {
					driver.switchTo().window(window);
					String x = driver.getTitle();
					if (type == "title" && x == value) {
						log.info("switchToWindowBy Title functions is executed");
						break;
					} else if (type == "startsWith" && x.startsWith(value)) {
						log.info("switchToWindowBy Title Startswith functions is executed");
						break;
					} else if (type == "contains" && x.contains(value)) {
						log.info("switchToWindowBy Title contains functions is executed");
						break;
					} else if (type == "endsWith" && x.endsWith(value)) {
						log.info("switchToWindowBy Title endsWith functions is executed");
						break;
					}
				}
			}
		} catch (Exception Ex) {
			log.info("switchToWindowBy is has exception could be due to loctor issue please check");
		}
	}

	public void switchToWindowByIndex(String type, int index) {
		try {
			Set<String> windows = driver.getWindowHandles();
			log.info("switchToWindowByIndex functions is Initiated");
			if (windows.size() != 0) {
				List<String> list = new ArrayList<>(windows);
				for (int i = 0; i < list.size(); i++) {
					driver.switchTo().window(list.get(index));
					log.info("switchToWindowByIndex endsWith functions is executed");
				}
			}
		} catch (Exception Ex) {
			log.info("switchToWindowByIndex is has exception could be due to loctor issue please check");
		}
	}

	public void createAndSwitchToWindow(String type) {
		try {
			log.info("createAndSwitchToWindow functions is executed");
			if (type.equals("tab")) {
				//driver.switchTo().newWindow(WindowType.TAB);
				log.info("createAndSwitchToTab functions is executed");
			} else if (type.equals("window")) {
				//driver.switchTo().newWindow(WindowType.WINDOW);
				log.info("createAndSwitchToWindow functions is executed");
			}

		} catch (Exception Ex) {
			log.info("createAndSwitchToWindow is has exception could be due to loctor issue please check");
		}
	}

	public void closeAndSwitchToWindow(String close) {
		try {
			Set<String> windows = driver.getWindowHandles();
			log.info("closeAndSwitchToWindow functions is Initiated");
			if (windows.size() != 0) {
				List<String> list = new ArrayList<>(windows);
				driver.close();
				driver.switchTo().window(list.get(1));
				log.info("closeAndSwitchToWindow functions is executed");
			}
		} catch (Exception Ex) {
			log.info("closeAndSwitchToWindow is has exception could be due to loctor issue please check");
		}
	}

	public void switchToFrame(String type, String value) {
		log.info("switchToFrame functions is Initiated");
		try {
			if (type == "name") {
				driver.switchTo().frame(value);
				log.info("switchToFrameBy Name functions is executed");
			} else if (type == "id") {
				driver.switchTo().frame(value);
				log.info("switchToFrameBy Id functions is executed");
			} else if (type == "index") {
				driver.switchTo().frame(Integer.parseInt(value));
				log.info("switchToFrameBy Index functions is executed");
			}
		} catch (Exception Ex) {
			log.info("switchToFrame is has exception could be due to locator issue please check");
		}
	}

	public void switchToFrameBylocator(String locator, String locvalue) {
		log.info("switchToFrameBylocator functions is Initiated");
		try {
			driver.switchTo().frame(ReusableMethods.LocateElementBy(locator, locvalue));
			log.info("switchToFrameBylocator functions is executed");
		} catch (Exception Ex) {
			log.info("switchToFrameBylocator is has exception could be due to locator issue please check");
		}
	}

	public void waitForFrameAndSwitch(String locator, String locvalue) {
		log.info("waitForFrameAndSwitch functions is Initiated");
		try {
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(
					ExpectedConditions.frameToBeAvailableAndSwitchToIt(ReusableMethods.LocateElementBy(locator, locvalue)));
			log.info("waitForFrameAndSwitch functions is executed");
		} catch (Exception Ex) {
			log.info("waitForFrameAndSwitch is has exception could be due to locator issue please check");
		}
	}

	public void switchToParentFrame() {
		log.info("switchToParentFrame functions is Initiated");
		try {
			driver.switchTo().parentFrame();
			log.info("switchToParentFrame functions is executed");
		} catch (Exception Ex) {
			log.info("switchToParentFrame is has exception could be due to locator issue please check");
		}
	}

	public void switchToDefaultContent() {
		log.info("switchToDefaultContent functions is Initiated");
		try {
			driver.switchTo().defaultContent();
			log.info("switchToDefaultContent functions is executed");
		} catch (Exception Ex) {
			log.info("switchToDefaultContent is has exception could be due to loctor issue please check");
		}
	}

	public static String takeScreenShot() throws Exception {

		log.info("failedScreenShot is Initiated");
		SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		Date dt = new Date();
		String fname = sf.format(dt) + ".png";
		File src = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "/Screenshots/" + fname);
		FileHandler.copy(src, dest);
		log.info("failedScreenShot functions is executed");
		return (dest.getAbsolutePath());
	}

	public void failedScreenShot() throws Exception {
		String filepath = ReusableMethods.takeScreenShot();
		Reporter.log("Test failed for ");
		Reporter.log("<a href=\"" + filepath + "\"><img src=\"" + filepath + "\"height=\"100\" width=\"100\"/></a>");

	}

	public void scrollDown() {
		log.info("scrollDown functions is Initiated");
		try {
			Actions act = new Actions(driver);
			act.sendKeys(Keys.PAGE_DOWN).build().perform();
			log.info("scrollDown functions is executed");
		} catch (Exception Ex) {
			log.info("scrollDown is has exception could be due to loctor issue please check");
		}
	}

	public void scrollUp() {
		log.info("scrollUp functions is Initiated");
		try {
			Actions act = new Actions(driver);
			act.sendKeys(Keys.PAGE_UP).build().perform();
			log.info("scrollUp functions is executed");
		} catch (Exception Ex) {
			log.info("scrollUp is has exception could be due to loctor issue please check");
		}
	}

	public void scrollToBottom() {
		log.info("scrollToBottom functions is Initiated");
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			log.info("scrollToBottom functions is executed");
		} catch (Exception Ex) {
			log.info("scrollToBottom is has exception could be due to loctor issue please check");
		}
	}

	public void scrollToTop() {
		log.info("scrollToTop functions is Initiated");
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
			log.info("scrollToTop functions is executed");
		} catch (Exception Ex) {
			log.info("scrollToTop is has exception could be due to loctor issue please check");
		}
	}

	public void ScrollByVisibleElement(WebElement locator) {
		log.info("ScrollByVisibleElement functions is Initiated");
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", locator);
			log.info("ScrollByVisibleElement functions is executed");
		} catch (Exception Ex) {
			log.info("ScrollByVisibleElement is has exception could be due to locator issue please check");
		}
	}

	public void scrollToRight() {
		log.info("scrollToRight functions is Initiated");
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(6000,0)");
			log.info("scrollToRight functions is executed");
		} catch (Exception Ex) {
			log.info("scrollToRight is has exception could be due to loctor issue please check");
		}
	}

	public void scrollToLeft() {
		log.info("scrollToLeft functions is Initiated");
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(-3000,0)");
			log.info("scrollToLeft functions is executed");
		} catch (Exception Ex) {
			log.info("scrollToLeft is has exception could be due to loctor issue please check");
		}
	}

	public void refreshDriver() {
		log.info("refreshDriver functions is Initiated");
		try {
			driver.navigate().refresh();
			log.info("refreshDriver functions is executed");
		} catch (Exception Ex) {
			log.info("refreshDriver is has exception could be due to loctor issue please check");
		}
	}

	public void forwardPage() {
		log.info("forwardPage functions is Initiated");
		try {
			driver.navigate().forward();
			log.info("forwardPage functions is executed");
		} catch (Exception Ex) {
			log.info("forwardPage is has exception could be due to loctor issue please check");
		}
	}

	public void backPage() {
		log.info("backPage functions is Initiated");
		try {
			driver.navigate().back();
			log.info("backPage functions is executed");
		} catch (Exception Ex) {
			log.info("backPage is has exception could be due to loctor issue please check");
		}
	}

	public void submit(String locator, String locvalue) {
		log.info("submit functions is Initiated");
		try {
			WebElement field = ReusableMethods.LocateElementBy(locator, locvalue);
			field.submit();
			log.info("submit functions is executed");
		} catch (Exception Ex) {
			log.info("submit is has exception could be due to loctor issue please check");
		}
	}

	public void dragAndDrop(WebElement from, WebElement to) {
		log.info("dragAndDrop functions is Initiated");
		try {
			Actions builder = new Actions(driver);
			// WebElement from = ElementUtil.LocateElementBy(locator, locvalue);
			// WebElement to = ElementUtil.LocateElementBy(locator, locvalue);
			builder.dragAndDrop(from, to).perform();
			log.info("dragAndDrop functions is executed");
		} catch (Exception Ex) {
			log.info("dragAndDrop is has exception could be due to loctor issue please check");
		}
	}

	public void dragAndDropBy(String locator, String locvalue) {
		log.info("dragAndDropBy functions is Initiated");
		try {
			Actions builder = new Actions(driver);
			builder.dragAndDropBy(ReusableMethods.LocateElementBy(locator, locvalue), 100, 100).perform();
			log.info("dragAndDropBy functions is executed");
		} catch (Exception Ex) {
			log.info("dragAndDropBy is has exception could be due to loctor issue please check");
		}
	}

	public void addCookie(String key, String value) {
		log.info("addCookie functions is Initiated");
		try {
			driver.manage().addCookie(new Cookie(key, value));
			log.info("addCookie functions is executed");
		} catch (Exception Ex) {
			log.info("addCookie is has exception could be due to loctor issue please check");
		}
	}

	public boolean storeCookiePresent(String value) {
		log.info("StoreCookiePresent functions is Initiated");
		try {
			Cookie cookie1 = driver.manage().getCookieNamed(value);
			if (cookie1.equals(null)) {
				log.info("Cookie is not present");
			} else {
				log.info("Cookie is present");
				log.info("StoreCookiePresent functions is executed");
			}
			return true;
		} catch (Exception Ex) {
			log.info("StoreCookiePresent is has exception could be due to loctor issue please check");
			return false;
		}
	}

	public void storeCookieByName(String value) {
		log.info("StoreCookieByName functions is Initiated");
		try {
			Cookie cookie1 = driver.manage().getCookieNamed(value);
			log.info("StoreCookieByName functions is executed");
			log.info(cookie1);
		} catch (Exception Ex) {

			log.info("StoreCookieByName is has exception could be due to loctor issue please check");
		}
	}

	public void doubleClickElement(String locator, String locvalue) {
		log.info("doubleClickElement functions is Initiated");
		try {
			Actions builder = new Actions(driver);
			builder.doubleClick(ReusableMethods.LocateElementBy(locator, locvalue)).perform();
			log.info("doubleClickElement functions is executed");
		} catch (Exception Ex) {
			log.info("doubleClickElement is has exception could be due to loctor issue please check");
		}
	}

	public void mouseOverElement(String locator, String locvalue) {
		log.info("mouseOverElement functions is Initiated");
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(ReusableMethods.LocateElementBy(locator, locvalue)).perform();
			log.info("mouseOverElement functions is executed");
		} catch (Exception Ex) {
			log.info("mouseOverElement is has exception could be due to loctor issue please check");
		}
	}

	public void releaseElement(String locator, String locvalue) {
		log.info("releaseElement functions is Initiated");
		try {
			Actions builder = new Actions(driver);
			builder.click(ReusableMethods.LocateElementBy(locator, locvalue));
			Thread.sleep(2000);
			builder.release(ReusableMethods.LocateElementBy(locator, locvalue));
			log.info("releaseElement functions is executed");
		} catch (Exception Ex) {
			log.info("releaseElement is has exception could be due to loctor issue please check");
		}
	}

	public String getCurrentUrl() {
		log.info("getCurrentUrl functions is Initiated");
		try {
			String currentUrl = driver.getCurrentUrl();
			log.info("getCurrentUrl functions is executed");
			return currentUrl;
		} catch (Exception Ex) {
			log.info("getCurrentUrl is has exception could be due to loctor issue please check");
			return null;
		}
	}

	public String storePageSource() {
		log.info("storePageSource functions is Initiated");
		try {
			String pageSource = driver.getPageSource();
			log.info("storePageSource functions is executed");
			return pageSource;
		} catch (Exception Ex) {
			log.info("storePageSource is has exception could be due to loctor issue please check");
			return null;
		}
	}

	public boolean storeTextPresent(String expected, String actual) {
		log.info("storeTextPresent functions is Initiated");
		try {
			if (expected.equals(actual)) {
				log.info("The expected heading is same as actual heading" + actual);
				log.info("storeTextPresent functions is executed");
			} else {
				log.info("The expected heading doesn't match the actual heading" + actual);
			}
			return true;
		} catch (Exception Ex) {
			log.info("storeTextPresent is has exception could be due to loctor issue please check");
			return false;
		}
	}

	public boolean storeElementSelected(String locator, String locvalue) {
		log.info("storeElementSelected functions is Initiated");
		try {
			WebElement option = ReusableMethods.LocateElementBy(locator, locvalue);
			option.isSelected();
			Thread.sleep(2000);
			log.info("storeElementSelected functions is executed");
			return true;
		} catch (Exception Ex) {
			log.info("storeElementSelected is has exception could be due to loctor issue please check");
			return false;
		}
	}

	public String storeElementAttribute(String locator, String locvalue) {
		log.info("storeElementAttribute functions is Initiated");
		try {
			Select select = new Select(ReusableMethods.LocateElementBy(locator, locvalue));
			WebElement option = select.getFirstSelectedOption();
			option.getAttribute(locvalue);
			String defaultItem = option.getText();
			Thread.sleep(2000);
			log.info("storeElementAttribute functions is executed");
			return defaultItem;
		} catch (Exception Ex) {
			log.info("storeElementAttribute is has exception could be due to loctor issue please check");
			return null;
		}
	}

	public String storeAlertText() {
		log.info("storeAlertText functions is Initiated");
		try {
			String name = driver.switchTo().alert().getText();
			log.info("storeAlertText functions is executed");
			return name;
		} catch (Exception Ex) {
			log.info("storeAlertText is has exception could be due to loctor issue please check");
			return null;
		}

	}

	public void restartBrowser() {
		log.info("restartBrowser functions is Initiated");
		try {
			driver.manage().deleteAllCookies();
			driver.navigate().refresh();
			log.info("restartBrowser functions is executed");
		} catch (Exception Ex) {
			log.info("restartBrowser is has exception could be due to loctor issue please check");
		}
	}

	public void rightClick(String locator, String locvalue) {
		log.info("rightClick functions is Initiated");
		try {
			Actions action = new Actions(driver);
			WebElement link = ReusableMethods.LocateElementBy(locator, locvalue);
			action.contextClick(link).perform();
			log.info("rightClick functions is executed");
		} catch (Exception Ex) {
			log.info("rightClick is has exception could be due to loctor issue please check");
		}
	}

	@SuppressWarnings("deprecation")
	public void changeWaitTime(int value) {
		log.info("changeWaitTime functions is Initiated");
		try {
			driver.manage().timeouts().implicitlyWait(value, TimeUnit.SECONDS);
			log.info("changeWaitTime functions is executed");
		} catch (Exception Ex) {
			log.info("changeWaitTime is has exception could be due to loctor issue please check");
		}
	}

	public void setBrowserSize() {
		log.info("setBrowserSize functions is Initiated");
		try {
			Dimension dm = new Dimension(450, 630);
			driver.manage().window().setSize(dm);
			log.info("setBrowserSize functions is executed");
		} catch (Exception Ex) {
			log.info("setBrowserSize is has exception could be due to loctor issue please check");
		}
	}

	public void clickIfExists(String locator, String locvalue) {
		log.info("clickIfExists functions is Initiated");
		try {
			WebElement link = ReusableMethods.LocateElementBy(locator, locvalue);
			boolean value = link.isDisplayed();
			if (value == true) {
				link.click();
			} else {
				log.info("Element is not Exists");
			}
			log.info("clickIfExists functions is executed");
		} catch (Exception Ex) {
			log.info("clickIfExists is has exception could be due to loctor issue please check");
		}
	}

	public void sendkeysToElement(String locator, String locvalue, String value) {
		log.info("sendkeysToElement functions is Initiated");
		try {
			WebElement link = ReusableMethods.LocateElementBy(locator, locvalue);
			link.sendKeys(value + Keys.ENTER);
			log.info("sendkeysToElement functions is executed");
		} catch (Exception Ex) {
			log.info("sendkeysToElement is has exception could be due to loctor issue please check");
		}
	}
}