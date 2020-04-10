package com.amazon.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.config.Constants;
import com.config.Keyword;
import com.utility.PropertyUtility;

public class HomePageTests {

	HomePage homepage;

	@BeforeTest
	public void OpenBrowser() {
		Keyword.openBrowser("Chrome");
		Keyword.launchUrl("https://www.amazon.in/");
		Constants.actual = Constants.driver.getCurrentUrl();
		Assert.assertTrue(Constants.actual.contains("https://www.amazon.in/"));
		Keyword.maximizeBrowser();
		Keyword.loggerInfo("entering appliction url and maximizing browser");
		// homepage =PageFactory.initElements(Constants.driver, HomePage.class);
		homepage = new HomePage();
	}

	@Test
	public void tc_01() {
		Constants.actual = Constants.driver.getTitle();
		Assert.assertTrue(Constants.actual.contains(
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"));
	}
  @Test
	public void tc_02() {
	  homepage.getMenuBtnPostion_Dimension();
	Rectangle searchBtnRect= Constants.element.getRect();
	SoftAssert softassert= new SoftAssert();
	softassert.assertEquals(searchBtnRect.getHeight(),40);
	softassert.assertEquals(searchBtnRect.getWidth(),38);
	softassert.assertEquals(searchBtnRect.getX(),7);
	softassert.assertEquals(searchBtnRect.getY(),10);
	softassert.assertAll();
  }
	@Test
	public void tc_03() {
		homepage.clickOnMenuTab();
		homepage.closeMunuTab();
		Keyword.loggerInfo("verifying by clicking on munu tab it open or not and closing the menu tab");
	}

	@Test
	public void tc_04() {
		homepage.getAmazonLogo();
		Assert.assertTrue(true);
		Keyword.loggerInfo("verify 'amazon' logo visible or not");
	}

	@Test
	public void tc_05() {
		homepage.inLogo();
		Assert.assertTrue(true);
		Keyword.loggerInfo("verify '.in' logo visible or not");

	}

	@Test
	public void tc_06() {
		homepage.clickOnAmazonLogo();
		Constants.actual = Constants.driver.getCurrentUrl();
		Assert.assertTrue((Constants.actual).contains("https://www.amazon.in/ref=nav_logo"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'amazon logo' will it switch to on next page and navigate back on previous page or not");
	}

	@Test
	public void tc_07() {
		String text = homepage.getTryPrimeText();
		Assert.assertEquals(text, "Try Prime", "search result text failed");
		Keyword.loggerInfo("verifying 'Try Prime' text visible or not");
	}

	@Test
	public void tc_08() {
		homepage.clickOnTryprime();
		Constants.actual = Constants.driver.getTitle();
		System.out.println(Constants.actual);
		Assert.assertTrue((Constants.actual).contains("Amazon.in: Amazon Prime"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'Try Prime logo' will it switch to on next page and navigate back on previous page or not");
	}

	@Test
	public void tc_09() {
		Constants.actual = homepage.getColorAllcategoriesDropDown();
		Assert.assertEquals(Constants.actual, "rgba(255, 255, 255, 1)");
		Keyword.loggerInfo("verifing background color of 'All Categories dropdown' dropdown befor hover");

	}

	@Test
	public void tc_10() {
		Constants.actual = homepage.getColor_AllcategoriesDropDown_AfterHover();
		Assert.assertEquals(Constants.actual, "rgba(17, 17, 17, 1)");
		Keyword.loggerInfo("verifing background color of 'All Categories dropdown' dropdown after hovering");
	}

	@Test
	public void tc_11() {
		homepage.clickOn_AllCategoriesDropdown();
		homepage.scrolling_AllcategoriesDropDown();
		Keyword.loggerInfo("scrolling All departrment dropdown");

	}

	@Test
	public void tc_12() {
		homepage.clickOn_AllCategoriesDropdown();
		homepage.selectIndex_AllcategoriesDropDown(36);
		Constants.element = Constants.select.getFirstSelectedOption();
		Constants.actual = Constants.element.getText();
		Assert.assertEquals(Constants.actual, "Software");
		Keyword.loggerInfo("select expected index from All departrment dropdown");
	}

	@Test
	public void tc_13() {
		homepage.clickOnSearchBtn();
		Keyword.switchToWindow(0);
		Constants.actual = Constants.driver.getTitle();
		System.out.println(Constants.actual);
		Assert.assertEquals(Constants.actual,
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");

	}

	@Test
	public void tc_14() {
		homepage.getSearchBtn_Position_Dimension();
		Rectangle searchBtnRect= Constants.element.getRect();
		SoftAssert softassert= new SoftAssert();
		softassert.assertEquals(searchBtnRect.getHeight(), 38);
		softassert.assertEquals(searchBtnRect.getWidth(),581);
		softassert.assertEquals(searchBtnRect.getX(),266);
		softassert.assertEquals(searchBtnRect.getY(),11);
		softassert.assertAll();
		Keyword.loggerInfo("verifing Dimensions of 'search button'(height,width,X,Y)");
		}
	@Test
	public void tc_15() {
		homepage.enterTextinSearchBox("Hard Disk");
		homepage.clickOnSearchBtn();
		Constants.actual = Constants.driver.getTitle();
		System.out.println(Constants.actual);
		Constants.driver.navigate().back();
		Assert.assertEquals(Constants.actual,
				"Laptop Software: Buy Antivirus For Laptop online at best prices in India - Amazon.in");
	Keyword.loggerInfo("entering text in 'search box'and switch to on naxt page and navigat to back");
	}

	@Test
	public void tc_16() {
		Constants.actual = homepage.getColor_SearchBtn();
		Assert.assertEquals(Constants.actual, "rgba(0, 0, 0, 0)");
		Keyword.loggerInfo("verifing background color of 'search button' dropdown befor hover");

	}

	@Test
	public void tc_17() {
		Constants.actual = homepage.getColor_searchBtn_AfterHover();
		Assert.assertEquals(Constants.actual, "rgba(255, 255, 255, 1)");
		Keyword.loggerInfo("verifing background color of 'search button' dropdown after hovering");
	}

	@Test
	public void tc_18() {
		homepage.getSerachBtnLogo();
		Assert.assertTrue(true);
		Keyword.loggerInfo("verify 'Search button' Logo visible or not");
	}

	@Test
	public void tc_19() {
		homepage.getEN_Global_Image();
		Assert.assertTrue(true);
		Keyword.loggerInfo("verify 'global' Image visible or not");
	}

	@Test
	public void tc_20() {
		homepage.getENLanguageText();
		Assert.assertEquals(Constants.actual, "EN", "search result text failed");
		Keyword.loggerInfo("verifying 'EN' text visible or not");
	}

	@Test
	public void tc_21() {
		homepage.clickOnEN_LanguageImage();
		Constants.actual = Constants.driver.getTitle();
		Assert.assertTrue((Constants.actual).contains("Change Language Settings"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo("verifying will it switch to on next page and navigate back on previous page or not");
	}

	@Test
	public void tc_22() {
		homepage.getHelloSignInText();
		Assert.assertEquals(Constants.actual, "Hello. Sign in", "search result text failed");
		Keyword.loggerInfo("verifying 'Hello. Sign in' text visible or not");
	}

	@Test
	public void tc_23() {
		homepage.getAccountListsText();
		Assert.assertEquals(Constants.actual, "Account & Lists", "search result text failed");
		Keyword.loggerInfo("verifying 'Account & Lists' text visible or not");
	}

	@Test
	public void tc_24() {
		homepage.clickOnHelloSignIn_AccountList();
		Constants.actual = Constants.driver.getTitle();
		Assert.assertTrue((Constants.actual).contains("Amazon Sign In"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'Hello sign.in' will it switch to on next page and navigate back on previous page or not");
	}

	@Test
	public void tc_25() {
		homepage.getReturnText();
		Assert.assertEquals(Constants.actual, "Returns", "search result text failed");
		Keyword.loggerInfo("verifying 'Returns' text visible or not");
	}

	@Test
	public void tc_26() {
		homepage.getOrderText();
		Assert.assertEquals(Constants.actual, "& Orders", "search result text failed");
		Keyword.loggerInfo("verifying '& Orders' text visible or not");
	}

	@Test
	public void tc_27() {
		homepage.clickOnReturnOrder();
		Constants.actual = Constants.driver.getTitle();
		System.out.println(Constants.actual);
		// Assert.assertTrue((Constants.actual).contains("Amazon Sign In"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'returns and orders' will it switch to on next page and navigate back on previous page or not");
	}

	@Test
	public void tc_28() {
		homepage.getTryText();
		Assert.assertEquals(Constants.actual, "Try", "search result text failed");
		Keyword.loggerInfo("verifying 'Try' text visible or not");
	}

	@Test
	public void tc_29() {
		homepage.getPrimeText();
		Assert.assertEquals(Constants.actual, "Prime", "search result text failed");
		Keyword.loggerInfo("verifying 'Prime' text visible or not");
	}

	@Test
	public void tc_30() {
		homepage.clickOnTryPrimeTool();
		Constants.actual = Constants.driver.getTitle();
		Assert.assertTrue((Constants.actual).contains("Amazon.in: Amazon Prime"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'TryPrimeTool' will it switch to on next page and navigate back on previous page or not");
	}

	@Test
	public void tc_31() {
		homepage.getCartIcon();
		Assert.assertTrue(true);
		Keyword.loggerInfo("verifying 'Cart' Icon visible or not");
	}

	@Test
	public void tc_32() {
		homepage.getCartText();
		Assert.assertEquals(Constants.actual, "Cart", "search result text failed");
		Keyword.loggerInfo("verifying 'Cart' text visible or not");
	}

	@Test
	public void tc_33() {
		homepage.getZeroNumber();
		Assert.assertEquals(Constants.actual, "0", "search result text failed");
		Keyword.loggerInfo("verifying '0' number visible or not");
	}

	@Test
	public void tc_34() {
		homepage.clickCartTool();
		Constants.actual = Constants.driver.getTitle();
		System.out.println(Constants.actual);
		Assert.assertTrue((Constants.actual).contains("Amazon.in Shopping Cart"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'cart' will it switch to on next page and navigate back on previous page or not");
	}

	@Test
	public void tc_35() {
		homepage.getyourAddressIcon();
		Assert.assertTrue(true);
		Keyword.loggerInfo("verifying 'adress glow icon'  visible or not");
	}

	@Test
	public void tc_36() {
		homepage.getHelloText();
		Assert.assertEquals(Constants.actual, "Hello", "search result text failed");
		Keyword.loggerInfo("verifying 'Hello' text visible or not");
	}

	@Test
	public void tc_37() {
		homepage.getSelectYourAddressText();
		Assert.assertEquals(Constants.actual, "Select your address", "search result text failed");
		Keyword.loggerInfo("verifying 'Select your address' text visible or not");
	}

	@Test
	public void tc_38() {
		homepage.clickOnSelectYourAddress();
		homepage.enterPincodeInPincodeBox("444604");
		homepage.clickOnApplyPincodeBtn();
		Keyword.loggerInfo(
				"verifying by clicking on 'select_your_address' element popup will visible or not and entering text on 'address' box and click on 'Apply tab'");
	}

	// This method to hover on Customer service tool options
	@Test
	public void tc_39() {
		List<WebElement> CustomerServiceTool = Constants.driver.findElements(By.cssSelector("#nav-tools>a"));
		int size = CustomerServiceTool.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			Constants.action = new Actions(Constants.driver);
			Constants.action.moveToElement(CustomerServiceTool.get(i)).perform();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("Unable to Hover");
				e.printStackTrace();
			}
		}
		Keyword.loggerInfo("This test cases hover on Customer service tool options(14-tools)");
	}

	// This method to hover on Shopping container options
	@Test
	public void tc_40() {
		List<WebElement> ContainerList = Constants.driver.findElements(By.cssSelector("#nav-xshop>a"));
		int size = ContainerList.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			Constants.action = new Actions(Constants.driver);
			Constants.action.moveToElement(ContainerList.get(i)).perform();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("Unable to Hover");
				e.printStackTrace();
			}
		}
		Keyword.loggerInfo("This test cases hover on Shopping Container options(5-tools)");
	}

	@AfterTest
	public void quitDriver() {
		Constants.driver.close();
		Constants.driver.quit();
		Keyword.loggerInfo("Close the current window and quits this driver, closing every associated window");
	}

	@AfterMethod
	public void tearTest(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			PropertyUtility.captureScreenshot(Constants.driver, result.getName());
		}
	}
}