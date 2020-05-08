package com.amazon.pages;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.config.Constants;
import com.config.ExtentsReport;
import com.config.Keyword;
import com.utility.PropertyUtility;

public class HomePageTests extends ExtentsReport {
	HomePage homepage;

	@BeforeTest
	public void OpenBrowser() {
		Keyword.openBrowser("Chrome");
		Keyword.launchUrl("https://www.amazon.in/");
		Constants.actual = Constants.driver.getCurrentUrl();
		Assert.assertTrue(Constants.actual.contains("https://www.amazon.in/"));
		Keyword.maximizeBrowser();
		homepage = new HomePage();
		Keyword.loggerInfo("entering appliction url and maximizing browser");
		test = extent.createTest("Open Browser", "open the browser , launching url and maximize the window");
		test.log(Status.INFO, "launching Amazon home page url");
	}

	@Test
	public void tc_01() {
		Constants.actual = Constants.driver.getTitle();
		Assert.assertTrue(Constants.actual.contains(
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"));
		Keyword.loggerInfo("verifying title of the current page");
		test = extent.createTest("tc_01 verifying title of the home page");
		test.log(Status.INFO, "verifying title of Amazon home page page");
	}

	@Test
	public void tc_02() {
		homepage.getMenuBtnPostion_Dimension();
		Rectangle searchBtnRect = Constants.element.getRect();
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(searchBtnRect.getHeight(), 40);
		softassert.assertEquals(searchBtnRect.getWidth(), 38);
		softassert.assertEquals(searchBtnRect.getX(), 7);
		softassert.assertEquals(searchBtnRect.getY(), 10);
		softassert.assertAll();
		Keyword.loggerInfo("verifying dimensions of menu button");
		test = extent.createTest("tc_02 verifying dimensions Menu button");
		test.log(Status.INFO, "verifying height, width and X and Y position of menu button");
	}

	@Test
	public void tc_03() {
		homepage.clickOnMenuTab();
		homepage.closeMunuTab();
		Keyword.loggerInfo("verifying by clicking on munu tab it open or not and closing the menu tab");
		test = extent.createTest("tc_03 verifying Menu tab", "verifying by clicking on munu tab it open or not");
		test.log(Status.INFO, "verifying munu tab clickable or not ");
	}

	@Test
	public void tc_04() {
		homepage.clickOnMenuTab();
		homepage.getHelloSignInLogoInMenuBtn();
		Assert.assertTrue(true);
		Keyword.loggerInfo("verifying after clicking on menu button 'Hello.SignIn' logo visible or not");
		test = extent.createTest("tc_04 get Hello Sign.in Logo in Menu button");
		test.log(Status.INFO, "verifying after clicking on menu button 'Hello.SignIn' logo visible or not");
	}

	@Test
	public void tc_05() {
		String actualText = homepage.getHelloSignInTextInMenuBtn();
		homepage.closeMunuTab();
		Assert.assertEquals(actualText, "Hello. Sign in");
		Keyword.loggerInfo("verify after clicking on menu button 'Hello.SignIn' text visible or not");
		test = extent.createTest("tc_05 get Hello Sign.in text visible in Menu button");
		test.log(Status.INFO, "verifying after clicking on menu button 'Hello.SignIn' text visible or not");
	}

	@Test
	public void tc_06() {
		homepage.getAmazonLogo();
		Assert.assertTrue(true);
		Keyword.loggerInfo("verifying 'amazon' logo visible or not");
		test = extent.createTest("tc_06 verifying amazon logo");
		test.log(Status.INFO, "verifying 'amazon' logo visible or not");
	}

	@Test
	public void tc_07() {
		homepage.inLogo();
		Assert.assertTrue(true);
		Keyword.loggerInfo("verifying '.in' logo visible or not");
		test = extent.createTest("tc_07 verifying '.in' logo");
		test.log(Status.INFO, "verifying '.in' logo visible or not");

	}

	@Test
	public void tc_08() {
		homepage.clickOnAmazonLogo();
		Constants.actual = Constants.driver.getCurrentUrl();
		Assert.assertTrue((Constants.actual).contains("https://www.amazon.in/ref=nav_logo"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'amazon logo' will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_08 verifying Amazon Logo clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'amazon logo' will it switch to on next page or not");
	}

	@Test
	public void tc_09() {
		String text = homepage.getTryPrimeText();
		Assert.assertEquals(text, "Try Prime", "search result text failed");
		Keyword.loggerInfo("verifying 'Try Prime' text visible or not");
		test = extent.createTest("tc_09 verifying 'Try Prime' text");
		test.log(Status.INFO, "verifying 'Try Prime' text visible or not");
	}

	@Test
	public void tc_10() {
		homepage.clickOnTryprime();
		Constants.actual = Constants.driver.getTitle();
		System.out.println(Constants.actual);
		Assert.assertTrue((Constants.actual).contains("Amazon.in: Amazon Prime"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'Try Prime logo' will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_10 verifying 'Try Prime logo' clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'Try Prime logo' will it switch to on next page or not");
	}

	@Test
	public void tc_11() {
		Constants.actual = homepage.getColorAllcategoriesDropDown();
		Assert.assertEquals(Constants.actual, "rgba(255, 255, 255, 1)");
		Keyword.loggerInfo("verifing background color of 'All Categories dropdown' before hover");
		test = extent.createTest("tc_11 verifying color of 'All Categories dropdown' before hover");
		test.log(Status.INFO, "verifing background color of 'All Categories dropdown' before hover");
	}

	@Test
	public void tc_12() {
		homepage.getSizeAllCategoriesDropdown();
		List<WebElement> allCategoriesList = Constants.select.getOptions();
		int size = allCategoriesList.size();
		Assert.assertEquals(size, 43);
		Keyword.loggerInfo("verifing size of 'All Categories dropdown'");
		test = extent.createTest("tc_12 get size of 'All Categories dropdown");
		test.log(Status.INFO, "verifing size of 'All Categories dropdown'");
	}

	@Test
	public void tc_13() {
		homepage.getSizeAllCategoriesDropdown();
		List<WebElement> allCategoriesList = Constants.select.getOptions();
		ArrayList<String> actualallCategoriesList = new ArrayList();
		Iterator<WebElement> itr1 = allCategoriesList.iterator();
		while (itr1.hasNext()) {
			actualallCategoriesList.add(itr1.next().getText());
		}
		try {
			Constants.obj = new JSONParser()
					.parse(new FileReader("src/main/resources/{}ExpectedAllCategoriesList.json"));
		} catch (IOException | ParseException e) {
			System.out.println("Unable to read file" + e.getMessage());
			e.printStackTrace();
		}
		Constants.jsonObj = (JSONObject) Constants.obj;
		Constants.jsonArray = (JSONArray) Constants.jsonObj.get("searchDropdownBox");
		System.out.println(Constants.jsonArray.size());
		List<String> expected = new ArrayList();
		Iterator itr = Constants.jsonArray.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
			// Constants.jsonArray =Constants.jsonObj
		}
		String[] getList = new String[Constants.jsonArray.size()];
		for (int i = 0; i < Constants.jsonArray.size(); i++) {
			getList[i] = (String) Constants.jsonArray.get(i);
			expected.add(i, getList[i]);
		}
		System.out.println(expected);
		Keyword.loggerInfo("verifing containts in 'All Categories dropdown'");
		test = extent.createTest("tc_13 verifing containts present in 'All Categories dropdown");
		test.log(Status.INFO, "verifing containts in 'All Categories dropdown");
	}

	@Test
	public void tc_14() {
		Constants.actual = homepage.getColor_AllcategoriesDropDown_AfterHover();
		Assert.assertEquals(Constants.actual, "rgba(17, 17, 17, 1)");
		Keyword.loggerInfo("verifing background color of 'All Categories dropdown' after hovering");
		test = extent.createTest("tc_14 verifying color of 'All Categories dropdown' after hover");
		test.log(Status.INFO, "verifing background color of 'All Categories dropdown' after hovering");
	}

	@Test
	public void tc_15() {
		homepage.clickOn_AllCategoriesDropdown();
		homepage.scrolling_AllcategoriesDropDown();
		Keyword.loggerInfo("scrolling 'All Categories' dropdown");
		test = extent.createTest("tc_15 scrolling 'All Categories' dropdown");
		test.log(Status.INFO, "verifing scrolling 'All Categories' dropdown");
	}

	@Test
	public void tc_16() {
		homepage.clickOn_AllCategoriesDropdown();
		homepage.selectIndex_AllcategoriesDropDown(36);
		Constants.element = Constants.select.getFirstSelectedOption();
		Constants.actual = Constants.element.getText();
		Assert.assertEquals(Constants.actual, "Software");
		Keyword.loggerInfo("select expected index from All departrment dropdown");
		test = extent.createTest("tc_16 verifying expected index from All departrment dropdown");
		test.log(Status.INFO, "verifying is it selected expected index from All departrment dropdown");
	}

	@Test
	public void tc_17() {
		homepage.clickOnSearchBtn();
		Keyword.windowHandles(0);
		Constants.actual = Constants.driver.getTitle();
		System.out.println(Constants.actual);
		Assert.assertEquals(Constants.actual,
				"Amazon.in - Departments : Books, Movies, Music, Kindle, Mobiles, Cameras, Computers, Toys, Baby products, Health & Personal Care, Home & Kitchen, Pet Supplies, Sports & Outdoors, Watches, Fashion Jewellery, Luggage, Shoes & Handbags, Clothing & Accessories, Musical Instruments & Professional Audio, Office & Stationery, Car & Motorbike");
		test = extent.createTest("tc_17 verifying by clicking on search button");
		test.log(Status.INFO, "verifying search button clickable or not");
	}

	@Test
	public void tc_18() {
		homepage.getSearchBtn_Dimension();
		Rectangle searchBtnRect = Constants.element.getRect();
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(searchBtnRect.getHeight(), 38);
		softassert.assertEquals(searchBtnRect.getWidth(), 581);
		softassert.assertEquals(searchBtnRect.getX(), 266);
		softassert.assertEquals(searchBtnRect.getY(), 11);
		softassert.assertAll();
		Keyword.loggerInfo("verifing Dimensions of 'search button'(height,width,X,Y)");
		test = extent.createTest("tc_18 verifying Dimensions of 'search button'");
		test.log(Status.INFO, "verifying heght, width and X and Y Position of search button");
	}

	@Test
	public void tc_19() {
		homepage.enterTextinSearchBox("Hard Disk");
		homepage.clickOnSearchBtn();
		Constants.actual = Constants.driver.getTitle();
		System.out.println(Constants.actual);
		Constants.driver.navigate().back();
		Assert.assertEquals(Constants.actual,
				"Software : Buy Security, Business, Office and Education software online at best prices in India - Amazon.in");
		Keyword.loggerInfo("entering text in 'search box'and switch to on naxt page and navigat to back");
		test = extent.createTest("tc_19 verifying 'search box' by entering text");
		test.log(Status.INFO, "verifying 'search box' by entering text switch to on naxt page and navigat to back");
	}

	@Test
	public void tc_20() {
		Constants.actual = homepage.getColor_SearchBtn();
		Assert.assertEquals(Constants.actual, "rgba(0, 0, 0, 0)");
		Keyword.loggerInfo("verifing background color of 'search button' dropdown before hover");
		test = extent.createTest("tc_20 verifying color of 'search button' before hover");
		test.log(Status.INFO, "verifing background color of 'search button' before hover");
	}

	@Test
	public void tc_21() {
		Constants.actual = homepage.getColor_searchBtn_AfterHover();
		Assert.assertEquals(Constants.actual, "rgba(255, 255, 255, 1)");
		Keyword.loggerInfo("verifing background color of 'search button' dropdown after hovering");
		test = extent.createTest("tc_21 verifying color of 'search button' after hover");
		test.log(Status.INFO, "verifing background color of 'search button' after hover");
	}

	@Test
	public void tc_22() {
		homepage.getSerachBtnLogo();
		Assert.assertTrue(true);
		Keyword.loggerInfo("verifying 'Search button' Logo visible or not");
		test = extent.createTest("tc_22 verifying 'Search button' Logo");
		test.log(Status.INFO, "verifing 'Search button' Logo visible or not");
	}

	@Test
	public void tc_23() {
		homepage.getEN_Global_Image();
		Assert.assertTrue(true);
		Keyword.loggerInfo("verifying 'global' Image visible or not");
		test = extent.createTest("tc_23 verifying 'global' Image");
		test.log(Status.INFO, "verifying 'global' Image visible or not");
	}

	@Test
	public void tc_24() {
		homepage.getENLanguageText();
		Assert.assertEquals(Constants.actual, "EN", "search result text failed");
		Keyword.loggerInfo("verifying 'EN' text visible or not");
		test = extent.createTest("tc_24 verifying 'EN' text");
		test.log(Status.INFO, "verifying 'EN' text visible or not");
	}

	@Test
	public void tc_25() {
		homepage.clickOnEN_LanguageImage();
		Constants.actual = Constants.driver.getTitle();
		Assert.assertTrue((Constants.actual).contains("Change Language Settings"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying  by clicking on 'EN' will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_25 verifying 'EN' text clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'EN' will it switch to on next page or not");
	}

	@Test
	public void tc_26() {
		homepage.getHelloSignInText();
		Assert.assertEquals(Constants.actual, "Hello. Sign in", "search result text failed");
		Keyword.loggerInfo("verifying 'Hello. Sign in' text visible or not");
		test = extent.createTest("tc_26 verifying 'Hello. Sign in' text");
		test.log(Status.INFO, "verifying 'Hello. Sign in' text visible or not");
	}

	@Test
	public void tc_27() {
		homepage.getAccountListsText();
		Assert.assertEquals(Constants.actual, "Account & Lists", "search result text failed");
		Keyword.loggerInfo("verifying 'Account & Lists' text visible or not");
		test = extent.createTest("tc_27 verifying 'Account & Lists' text");
		test.log(Status.INFO, "verifying 'Account & Lists' text visible or not");
	}

	@Test
	public void tc_28() {
		homepage.clickOnHelloSignIn_AccountList();
		Constants.actual = Constants.driver.getTitle();
		Assert.assertTrue((Constants.actual).contains("Amazon Sign In"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'Hello sign.in' will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_28 verifying 'Hello sign.in' text clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'Hello sign.in' will it switch to on next page or not");
	}

	@Test
	public void tc_29() {
		homepage.getReturnText();
		Assert.assertEquals(Constants.actual, "Returns", "search result text failed");
		Keyword.loggerInfo("verifying 'Returns' text visible or not");
		test = extent.createTest("tc_29 verifying 'Returns' text");
		test.log(Status.INFO, "verifying 'Returns' text visible or not");
	}

	@Test
	public void tc_30() {
		homepage.getOrderText();
		Assert.assertEquals(Constants.actual, "& Orders", "search result text failed");
		Keyword.loggerInfo("verifying '& Orders' text visible or not");
		test = extent.createTest("tc_30 verifying '& Orders' text");
		test.log(Status.INFO, "verifying '& Orders' text visible or not");
	}

	@Test
	public void tc_31() {
		homepage.clickOnReturnOrder();
		Constants.actual = Constants.driver.getTitle();
		System.out.println(Constants.actual);
		Assert.assertTrue((Constants.actual).contains("Amazon Sign In"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'returns and orders' will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_31 verifying 'returns and orders' tool clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'returns and orders' will it switch to on next page or not");
	}

	@Test
	public void tc_32() {
		homepage.getTryText();
		Assert.assertEquals(Constants.actual, "Try", "search result text failed");
		Keyword.loggerInfo("verifying 'Try' text visible or not");
		test = extent.createTest("tc_32 verifying 'Try' text");
		test.log(Status.INFO, "verifying 'Try' text visible or not");
	}

	@Test
	public void tc_33() {
		homepage.getPrimeText();
		Assert.assertEquals(Constants.actual, "Prime", "search result text failed");
		Keyword.loggerInfo("verifying 'Prime' text visible or not");
		test = extent.createTest("tc_33 verifying 'Try' text");
		test.log(Status.INFO, "verifying 'Try' text visible or not");
	}

	@Test
	public void tc_34() {
		homepage.clickOnTryPrimeTool();
		Constants.actual = Constants.driver.getTitle();
		Assert.assertTrue((Constants.actual).contains("Amazon.in: Amazon Prime"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'TryPrime' will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_34 verifying 'TryPrime' tool clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'TryPrime' tool will it switch to on next page or not");
	}

	@Test
	public void tc_35() {
		homepage.getCartIcon();
		Assert.assertTrue(true);
		Keyword.loggerInfo("verifying 'Cart' Icon visible or not");
		test = extent.createTest("tc_35 verifying 'Cart' Icon");
		test.log(Status.INFO, "verifying 'Cart' Icon visible or not");
	}

	@Test
	public void tc_36() {
		homepage.getCartText();
		Assert.assertEquals(Constants.actual, "Cart", "search result text failed");
		Keyword.loggerInfo("verifying 'Cart' text visible or not");
		test = extent.createTest("tc_36 verifying 'Cart' text");
		test.log(Status.INFO, "verifying 'Cart' text visible or not");
	}

	@Test
	public void tc_37() {
		homepage.getZeroNumber();
		Assert.assertEquals(Constants.actual, "0", "search result text failed");
		Keyword.loggerInfo("verifying '0' number visible or not");
		test = extent.createTest("tc_37 verifying '0' number");
		test.log(Status.INFO, "verifying '0' number visible or not");
	}

	@Test
	public void tc_38() {
		homepage.clickCartTool();
		Constants.actual = Constants.driver.getTitle();
		System.out.println(Constants.actual);
		Assert.assertTrue((Constants.actual).contains("Amazon.in Shopping Cart"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'cart' will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_38 verifying 'cart' tool clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'cart' tool will it switch to on next page or not");
	}

	@Test
	public void tc_39() {
		homepage.getyourAddressIcon();
		Assert.assertTrue(true);
		Keyword.loggerInfo("verifying 'adress glow' icon  visible or not");
		test = extent.createTest("tc_39 verifying 'adress glow' Icon");
		test.log(Status.INFO, "verifying 'adress glow' Icon visible or not");
	}

	@Test
	public void tc_40() {
		homepage.getHelloText();
		Assert.assertEquals(Constants.actual, "Hello", "search result text failed");
		Keyword.loggerInfo("verifying 'Hello' text visible or not");
		test = extent.createTest("tc_40 verifying 'Hello' text");
		test.log(Status.INFO, "verifying 'Hello' text visible or not");
	}

	@Test
	public void tc_41() {
		homepage.getSelectYourAddressText();
		Assert.assertEquals(Constants.actual, "Select your address", "search result text failed");
		Keyword.loggerInfo("verifying 'Select your address' text visible or not");
		test = extent.createTest("tc_41 verifying 'Select your address' text");
		test.log(Status.INFO, "verifying 'Select your address' text visible or not");
	}

	@Test
	public void tc_42() {
		homepage.clickOnSelectYourAddress();
		homepage.enterPincodeInPincodeBox("444604");
		homepage.clickOnApplyPincodeBtn();
		Keyword.loggerInfo(
				"verifying by clicking on 'select_your_address' element popup will visible or not and entering text on 'address' box and click on 'Apply tab'");
		test = extent.createTest("tc_38 verifying 'select_your_address' popup clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'select_your_address' tool popup will visible or not");
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
		extent.flush();
	}

}