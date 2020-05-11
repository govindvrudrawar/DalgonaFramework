package com.config;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Keyword {
	/**
	 * This method is used to open specific browser. Browser name should be as
	 * follow :<br>
	 * <ol>
	 * <li>Chrome</li>
	 * <li>Firefox</li>
	 * <li>IE</li> only above mention browsers can be open using this method
	 * 
	 * @param browserName
	 * @author Sujit Kolhe
	 * 
	 */
	public static void openBrowser(String browserName) {
		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			Constants.driver = new ChromeDriver();
			Constants.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			Constants.driver = new FirefoxDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			Constants.driver = new InternetExplorerDriver();
			break;
		default:
			System.err.println("Invalid browser name : " + browserName);
		}

	}

	/**
	 * This method is used to launched the url in the browser is looking at. .
	 * 
	 * @param url
	 * @author Sujit Kolhe
	 * 
	 */
	public static void openURL(String url) {
		Constants.driver.get(url);

	}

	/**
	 * This method is used to maximizes the current window which recently launched
	 * url.
	 * 
	 * @author Sujit Kolhe
	 * 
	 */
	public static void maximizeBrowser() {
		Constants.driver.manage().window().maximize();
	}

	/**
	 * This method is used to capture the screenshot and store it in the specified
	 * location. Constructs a SimpleDateFormat using the given pattern and pattern
	 * the pattern describing the date and time format
	 * <ol>
	 * <li>Visible portion of the current frame</li>
	 * <li>Pattern describing the date and time format</li>
	 * </ol>
	 * 
	 * @OutputType : jpg Type for the screenshot output
	 * @author Sujit Kolhe
	 * 
	 */
	public static void captureScreenshot(String screenshotPath, String fileName, String extension) {
		TakesScreenshot ts = (TakesScreenshot) Constants.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss").format(new java.util.Date());
		try {
			FileUtils.copyFile(src, new File(screenshotPath + fileName + " " + dateTimeFormat + extension));
		} catch (IOException e) {
			System.out.println("Screenshot result failed"+e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to capture the screenshot and store it in the specified
	 * location. Constructs a SimpleDateFormat using the given pattern and the
	 * default date format symbols for the default
	 * <ol>
	 * <li>Entire page</li>
	 * <li>Pattern describing the date and time format</li>
	 * </ol>
	 * 
	 * @OutputType : jpg Type for the screenshot output
	 * @author Sujit Kolhe
	 * 
	 */
	public static void captureEntireScreenshot(String FullScreenshot, String fileName, String extension) {
		Constants.ashot = new AShot();
		Constants.ashot.shootingStrategy(ShootingStrategies.viewportPasting(2000));
		Screenshot sc = Constants.ashot.takeScreenshot(Constants.driver);
		BufferedImage image = sc.getImage();
		String dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss").format(new java.util.Date());
		try {
			ImageIO.write(image, "jpg", new File(FullScreenshot + fileName + " " + dateTimeFormat + extension));
		} catch (IOException e) {
			System.err.println("Full screenshot result faild"+e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to get the matching web element on the current page
	 * follow :<br>
	 * <ol>
	 * <li>XPATH</li>
	 * <li>ID</li>
	 * <li>CSS</li>
	 * <li>NAME</li>
	 * <li>CLASS</li>only above mention locators type can be select using this
	 * method
	 * 
	 * @return WebElement
	 * @author Sujit Kolhe
	 * 
	 */
	public static WebElement getWebElement(String locatorType, String locatorValue) {
		Constants.element = null;
		switch (locatorType) {
		case "XAPTH":
			Constants.element = Constants.driver.findElement(By.xpath(locatorValue));
			break;
		case "ID":
			Constants.element = Constants.driver.findElement(By.id(locatorValue));
			break;
		case "CSS":
			Constants.element = Constants.driver.findElement(By.cssSelector(locatorValue));
			break;
		case "NAME":
			Constants.element = Constants.driver.findElement(By.name(locatorValue));
			break;
		case "CLASS":
			Constants.element = Constants.driver.findElement(By.className(locatorValue));
			break;
		case"LINKTEXT":
			Constants.element=Constants.driver.findElement(By.linkText(locatorValue));
			break;
		case"PARTIAL_LINKTEXT":
			Constants.element=Constants.driver.findElement(By.partialLinkText(locatorValue));
			break;
		default:
			System.err.println("Invalid Locator Type");
		}
		return Constants.element;
	}

	/**
	 * This method is used to click on target web element on current page.
	 * 
	 * @author Sujit Kolhe
	 * 
	 */
	public static void clickOnElement(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Unable to click on element"+e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to close, the opened tab in current window.
	 * 
	 * @author Sujit Kolhe
	 * 
	 * 
	 */
	public static void closedTab(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}

	/**
	 * This method is used to verify, is this element displayed or not?
	 *
	 * @return Whether or not the element is displayed
	 * @author Sujit Kolhe
	 * 
	 */
	
	public static void getLogo(String locatorType, String locatorValue) {
		boolean expected = getWebElement(locatorType, locatorValue).isDisplayed();
	}

	/**
	 * This method is used to get the visible text of target element.
	 * 
	 * @author Sujit Kolhe
	 * 
	 */
	public static void getElementText(String locatorType, String locatorValue) {
		Constants.element = getWebElement(locatorType, locatorValue);
		Constants.actual = Constants.element.getText();
	}

	/**
	 * This method is used to get the value of a given CSS property. Color values
	 * should be returned.
	 * 
	 * @param propertyName the css property name of the element
	 * @return The current, computed value of the property.
	 * @author Sujit Kolhe
	 * 
	 */
	public static void getColor(String locatorType, String locatorValue, String propertyValue) {
		Constants.element = getWebElement(locatorType, locatorValue);
		Constants.actual = Constants.element.getCssValue(propertyValue);
	}

	/**
	 * This method is used to hover on target element to move to on current window.
	 * 
	 * @author Sujit Kolhe
	 * 
	 */
	public static void hoverOnElement(String locatorType, String locatorValue) {
		boolean selected = getWebElement(locatorType, locatorValue).isSelected();
		Constants.action = new Actions(Constants.driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("unbable to move on element");
			e.printStackTrace();
		}
		Constants.action.moveToElement(Constants.element).perform();
	}

	/**
	 * This method is used to get the value of a given CSS property after hover on
	 * web element. Color values should be returned as rgba strings
	 * 
	 * @param propertyName the css property name of the element
	 * @return The current, computed value of the property.
	 * @author Sujit Kolhe
	 * 
	 */
	public static void getColor_After_Hover(String locatorType, String locatorValue, String propertyValue) {
		hoverOnElement(locatorType, locatorValue);
		Constants.actual = Constants.element.getCssValue(propertyValue);

	}

	/**
	 * This method is used to scroll.
	 * 
	 * @author Sujit Kolhe
	 * 
	 */
	public static void scrolling() {
		Actions action = new Actions(Constants.driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.err.println("unable to scroll");
			e.printStackTrace();
		}
		action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
	}

	/**
	 * This method is used to select the option from dropdown at the given index.
	 * 
	 * @author Sujit Kolhe
	 * 
	 */
	public static void selectDropdown(String locatorType, String locatorValue, int indexToEnter) {
		Constants.element = getWebElement(locatorType, locatorValue);
		Constants.select = new Select(Constants.element);
		Constants.select.selectByIndex(indexToEnter);

	}

	/**
	 * This method is used to typing the text in the target element.
	 *
	 * @param keysToSend character sequence to send to the element
	 * @author Sujit Kolhe
	 * 
	 */
	public static void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	/**
	 * This method is used to read JSON file as expected.
	 *
	 * @param filepath the path of the file to read
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @author Sujit Kolhe
	 * 
	 */

	public static void readJsonFile(String filePath, String key) {
	try {
		Constants.obj = new JSONParser().parse(new FileReader(filePath));
	} catch (IOException | ParseException e) {
		System.out.println("Unable to read file" + e.getMessage());
		e.printStackTrace();
	}
	Constants.jsonObj = (JSONObject) Constants.obj;
	Constants.jsonArray = (JSONArray) Constants.jsonObj.get(key);
	System.out.println(Constants.jsonArray.size());
	Constants.expectedList = new ArrayList();
	Iterator itr = Constants.jsonArray.iterator();
	while (itr.hasNext()) {
		System.out.println(itr.next());
		// Constants.jsonArray =Constants.jsonObj
	}
	String[] getList = new String[Constants.jsonArray.size()];
	for (int i = 0; i < Constants.jsonArray.size(); i++) {
		getList[i] = (String) Constants.jsonArray.get(i);
		Constants.expectedList.add(i, getList[i]);
	}
	System.out.println(Constants.expectedList);
	}

	/**
	 * This method is used to switch to a different frame or window.
	 *
	 * @return A TargetLocator which can be used to select a frame or window
	 * @author Sujit Kolhe
	 * 
	 */
	public static void windowHandles(int windowIndex) {
		Set<String> newWindow = Constants.driver.getWindowHandles();
		System.out.println(newWindow);
		ArrayList<String> getWindow = new ArrayList(newWindow);
		Constants.driver.switchTo().window(getWindow.get(windowIndex));
	}
	
	/*
	 * This method is used for Select Value.
	 * @Author Govind Rudrawar                                                                                                                                                                                                                                                                                                                                                       
	 */
	public static void selectValue(String locaterType,String locatorValue,String textToselect) {
		WebElement element=getWebElement(locaterType, locatorValue);
		Select select=new Select (element);
		select.selectByVisibleText(textToselect);
	}
	/*
	 * This method is used for Implicit Wait URL.
	 * @Author Yogesh Shinde                                                                                                                                                                                                                                                                                                                                                      
	 */
	public static Timeouts implicit_Wait(long locatorValue,String locaterType) {
		Timeouts element=null;
		switch(locaterType)
		{
		case"DAYS":
			
			element=Constants.driver.manage().timeouts().implicitlyWait(locatorValue,TimeUnit.DAYS);
			break;
		case"HOURS":
			element=Constants.driver.manage().timeouts().implicitlyWait(locatorValue,TimeUnit.HOURS);
			break;
		case"MICROSECONDS":
			element=Constants.driver.manage().timeouts().implicitlyWait(locatorValue,TimeUnit.MICROSECONDS);
			break;
		case"MILLISECONDS":
			element=Constants.driver.manage().timeouts().implicitlyWait(locatorValue,TimeUnit.MILLISECONDS);
			break;
		case"MINUTES":
			element=Constants.driver.manage().timeouts().implicitlyWait(locatorValue,TimeUnit.MINUTES);
			break;
		case"NANOSECONDS":
			element=Constants.driver.manage().timeouts().implicitlyWait(locatorValue,TimeUnit.NANOSECONDS);
			break;
		case"SECONDS":
			element=Constants.driver.manage().timeouts().implicitlyWait(locatorValue,TimeUnit.SECONDS);
			break;
		
		default:
			System.out.println("Invalid LOcatorType: "+locaterType+". Expected DAYS,HOURS,MICROSECONDS,MILLISECONDS,MINUTES,NANOSECONDS,SECONDS");
		}
		
		return element;
	
	}	
		/**
		 * This method is used to create logging operations, except configuration and *
		 * See {@getLogger(String)} detailed information.
		 * 
		 * @author Sujit Kolhe
		 * 
		 */
	public static void loggerInfo(String massage) {
		Logger logger = Logger.getLogger(Keyword.class);
		logger.info(massage);
	}

	/**
	 * This method is used to Close the current window, quitting the browser if it's
	 * the last window currently open.
	 * 
	 * @author Sujit Kolhe
	 * 
	 */
	public static void closeBrowser() {
		Constants.driver.close();
	}
	/**
	 * This method is used to Thread sleep
	 */
public static void threadSleep() {
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	/**
	 * This method is used to quits this driver, closing every associated window.
	 * 
	 * @author Sujit Kolhe
	 * 
	 */
	public static void closeAllBrowser() {
		Constants.driver.quit();
	}

}