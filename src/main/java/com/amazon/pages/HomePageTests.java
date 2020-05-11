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
import com.aventstack.extentreports.MediaEntityBuilder;
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
		Keyword.openURL("https://www.amazon.in/");
		Constants.actual = Constants.driver.getCurrentUrl();
		Assert.assertTrue(Constants.actual.contains("https://www.amazon.in/"));
		Keyword.maximizeBrowser();
		homepage = new HomePage();
		Keyword.loggerInfo("entering appliction url and maximizing browser");
		test = extent.createTest("Amazon Home page");
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
	   Keyword.captureScreenshot("Screenshot/","Snapshot", ".jpg");
	   Keyword.loggerInfo("capturing visible portion of the current frame and describing the date and time format");
	   test = extent.createTest("tc_02 capturing visible portion of the current frame");
	   test.log(Status.INFO, "capturing visible portion of the current frame and describing the date and time format");
   }
   @Test
   public void tc_03() {
	   Keyword.captureScreenshot("Screenshot/","FullScreenshot", ".jpg");
	   Keyword.loggerInfo("capturing entire portion of the current page and describing the date and time format");
	   test = extent.createTest("tc_03 capturing entire portion of the current frame");
	   test.log(Status.INFO, "capturing visible entire of the current frame and describing the date and time format");
   }
	@Test
	public void tc_04() {
		homepage.getMenuBtnPostion_Dimension();
		Rectangle searchBtnRect = Constants.element.getRect();
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(searchBtnRect.getHeight(), 40);
		softassert.assertEquals(searchBtnRect.getWidth(), 38);
		softassert.assertEquals(searchBtnRect.getX(), 7);
		softassert.assertEquals(searchBtnRect.getY(), 10);
		softassert.assertAll();
		Keyword.loggerInfo("verifying dimensions of menu button");
		test = extent.createTest("tc_04 verifying dimensions Menu button");
		test.log(Status.INFO, "verifying height, width and X and Y position of menu button");
	}

	@Test
	public void tc_05() {
		homepage.clickOnMenuTab();
	    homepage.closeMunuTab();
		Keyword.loggerInfo("verifying by clicking on menu tab it open or not and and closing the menu tab");
		test = extent.createTest("tc_05 verifying Menu tab");
		test.log(Status.INFO, "verifying menu tab clickable or not ");
}

	@Test
	public void tc_06() {
		homepage.clickOnMenuTab();
		Keyword.captureScreenshot("Screenshot/", "MenuTabScreenshot", ".jpg");
		homepage.closeMunuTab();
		Keyword.loggerInfo("verifying by clicking on menu tab will it visible or not");
		test = extent.createTest("tc_06 verifying Menu tab visibility");
		test.log(Status.INFO, "verifying menu tab will it visible or not ");
	}


	@Test
	public void tc_07() {
		homepage.clickOnMenuTab();
		homepage.getHelloSignInLogoInMenuBtn();
		Assert.assertTrue(true);
		Keyword.loggerInfo("verifying after clicking on menu button 'Hello.SignIn' logo visible or not");
		test = extent.createTest("tc_07 get Hello Sign.in Logo in Menu button");
		test.log(Status.INFO, "verifying after clicking on menu button 'Hello.SignIn' logo visible or not");
	}

	@Test
	public void tc_08() {
		String actualText = homepage.getHelloSignInTextInMenuBtn();
		homepage.closeMunuTab();
		Assert.assertEquals(actualText, "Hello, Sign in");
		Keyword.loggerInfo("verify after clicking on menu button 'Hello.SignIn' text visible or not");
		test = extent.createTest("tc_08 get Hello Sign.in text visible in Menu button");
		test.log(Status.INFO, "verifying after clicking on menu button 'Hello.SignIn' text visible or not");
	}

	@Test
	public void tc_09() {
		homepage.getAmazonLogo();
		Assert.assertTrue(true);
		Keyword.loggerInfo("verifying 'amazon' logo visible or not");
		test = extent.createTest("tc_09 verifying amazon logo");
		test.log(Status.INFO, "verifying 'amazon' logo visible or not");
	}

	@Test
	public void tc_10() {
		homepage.inLogo();
		Assert.assertTrue(true);
		Keyword.loggerInfo("verifying '.in' logo visible or not");
		test = extent.createTest("tc_10 verifying '.in' logo");
		test.log(Status.INFO, "verifying '.in' logo visible or not");

	}

	@Test
	public void tc_11() {
		homepage.clickOnAmazonLogo();
		Constants.actual = Constants.driver.getCurrentUrl();
		Assert.assertTrue((Constants.actual).contains("https://www.amazon.in/ref=nav_logo"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'amazon logo' will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_11 verifying Amazon Logo clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'amazon logo' will it switch to on next page or not");
	}

	@Test
	public void tc_12() {
		String text = homepage.getTryPrimeText();
		Assert.assertEquals(text, "Try Prime", "search result text failed");
		Keyword.loggerInfo("verifying 'Try Prime' text visible or not");
		test = extent.createTest("tc_12 verifying 'Try Prime' text");
		test.log(Status.INFO, "verifying 'Try Prime' text visible or not");
	}

	@Test
	public void tc_13() {
		homepage.clickOnTryprime();
		Constants.actual = Constants.driver.getTitle();
		System.out.println(Constants.actual);
		Assert.assertTrue((Constants.actual).contains("Amazon.in: Amazon Prime"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'Try Prime logo' will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_13 verifying 'Try Prime logo' clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'Try Prime logo' will it switch to on next page or not");
	}

	@Test
	public void tc_14() {
		Constants.actual = homepage.getColorAllcategoriesDropDown();
		Assert.assertEquals(Constants.actual, "rgba(255, 255, 255, 1)");
		Keyword.loggerInfo("verifing background color of 'All Categories dropdown' before hover");
		test = extent.createTest("tc_14 verifying color of 'All Categories dropdown' before hover");
		test.log(Status.INFO, "verifing background color of 'All Categories dropdown' before hover");
	}

	@Test
	public void tc_15() {
		homepage.getSizeAllCategoriesDropdown();
		List<WebElement> allCategoriesList = Constants.select.getOptions();
		int size = allCategoriesList.size();
		Assert.assertEquals(size, 44);
		Keyword.loggerInfo("verifing size of 'All Categories dropdown'");
		test = extent.createTest("tc_15 get size of 'All Categories dropdown");
		test.log(Status.INFO, "verifing size of 'All Categories dropdown'");
	}

	@Test
	public void tc_16() {
		homepage.getSizeAllCategoriesDropdown();
		List<WebElement> allCategoriesList = Constants.select.getOptions();
		ArrayList<String> actualallCategoriesList = new ArrayList();
		Iterator<WebElement> itr1 = allCategoriesList.iterator();
		while (itr1.hasNext()) {
			actualallCategoriesList.add(itr1.next().getText());
		}
		Keyword.readJsonFile("src/main/resources/{}ExpectedAllCategoriesList.json", "searchDropdownBox");
		Assert.assertEquals(actualallCategoriesList, Constants.expectedList);
		Keyword.loggerInfo("verifing in 'All Categories' dropdown contains as per expectrd");
		test = extent.createTest("tc_16 verifying containts present in 'All Categories dropdown");
		test.log(Status.INFO, "verifing in 'All Categories' dropdown contains as per expectrd");
	}

	@Test
	public void tc_17() {
		Constants.actual = homepage.getColor_AllcategoriesDropDown_AfterHover();
		Assert.assertEquals(Constants.actual, "rgba(17, 17, 17, 1)");
		Keyword.loggerInfo("verifing background color of 'All Categories dropdown' after hovering");
		test = extent.createTest("tc_17 verifying color of 'All Categories dropdown' after hover");
		test.log(Status.INFO, "verifing background color of 'All Categories dropdown' after hovering");
	}

	@Test
	public void tc_18() {
		homepage.clickOn_AllCategoriesDropdown();
		homepage.scrolling_AllcategoriesDropDown();
   	homepage.clickOn_AllCategoriesDropdown();
		Keyword.loggerInfo("scrolling 'All Categories' dropdown");
		test = extent.createTest("tc_18 scrolling 'All Categories' dropdown");
		test.log(Status.INFO, "verifing scrolling 'All Categories' dropdown");
	}
	@Test
	public void tc_19() {
		homepage.clickOn_AllCategoriesDropdown();
		Keyword.captureScreenshot("Screenshot/", "AllCategoriesDropdownScr", ".jpg");
		homepage.clickOn_AllCategoriesDropdown();
		Keyword.loggerInfo("verifying by clicking on 'All Categories' Dropdown will it visible or not");
		test = extent.createTest("tc_19 verifying 'All Categories'Dropdown visibility");
		test.log(Status.INFO, "verifying 'All Categories'Dropdown will it visible or not ");
	}
	@Test
	public void tc_20() {
		homepage.clickOn_AllCategoriesDropdown();
		homepage.selectIndex_AllcategoriesDropDown(36);
		Constants.element = Constants.select.getFirstSelectedOption();
		Constants.actual = Constants.element.getText();
		Assert.assertEquals(Constants.actual, "Shoes & Handbags");
		Keyword.loggerInfo("select expected index from All departrment dropdown");
		test = extent.createTest("tc_20 verifying expected index from All departrment dropdown");
		test.log(Status.INFO, "verifying is it selected expected index from All departrment dropdown");
	}

	@Test
	public void tc_21() {
		homepage.clickOnSearchBtn();
		Keyword.windowHandles(0);
		Constants.actual = Constants.driver.getTitle();
		System.out.println(Constants.actual);
		Assert.assertEquals(Constants.actual,
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		test = extent.createTest("tc_21 verifying by clicking on search button");
		test.log(Status.INFO, "verifying search button clickable or not");
	}

	@Test
	public void tc_22() {
		homepage.getSearchBtn_Dimension();
		Rectangle searchBtnRect = Constants.element.getRect();
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(searchBtnRect.getHeight(), 38);
		softassert.assertEquals(searchBtnRect.getWidth(), 581);
		softassert.assertEquals(searchBtnRect.getX(), 266);
		softassert.assertEquals(searchBtnRect.getY(), 11);
		softassert.assertAll();
		Keyword.loggerInfo("verifing Dimensions of 'search button'(height,width,X,Y)");
		test = extent.createTest("tc_22 verifying Dimensions of 'search button'");
		test.log(Status.INFO, "verifying heght, width and X and Y Position of search button");
	}

	@Test
	public void tc_23() {
		homepage.enterTextinSearchBox("Hard Disk");
		homepage.clickOnSearchBtn();
		Constants.actual = Constants.driver.getTitle();
		System.out.println(Constants.actual);
		Constants.driver.navigate().back();
		Assert.assertEquals(Constants.actual,
				"Shoes & Handbags: Buy Shoes & Handbags Online at Best Prices in India-Amazon.in");
		Keyword.loggerInfo("entering text in 'search box'and switch to on naxt page and navigat to back");
		test = extent.createTest("tc_23 verifying 'search box' by entering text");
		test.log(Status.INFO, "verifying 'search box' by entering text switch to on naxt page and navigat to back");
	}

	@Test
	public void tc_24() {
		Constants.actual = homepage.getColor_SearchBtn();
		Assert.assertEquals(Constants.actual, "rgba(0, 0, 0, 0)");
		Keyword.loggerInfo("verifing background color of 'search button' dropdown before hover");
		test = extent.createTest("tc_24 verifying color of 'search button' before hover");
		test.log(Status.INFO, "verifing background color of 'search button' before hover");
	}

	@Test
	public void tc_25() {
		Constants.actual = homepage.getColor_searchBtn_AfterHover();
		Assert.assertEquals(Constants.actual, "rgba(255, 255, 255, 1)");
		Keyword.loggerInfo("verifing background color of 'search button' dropdown after hovering");
		test = extent.createTest("tc_25 verifying color of 'search button' after hover");
		test.log(Status.INFO, "verifing background color of 'search button' after hover");
	}

	@Test
	public void tc_26() {
		homepage.getSerachBtnLogo();
		Assert.assertTrue(true);
		Keyword.loggerInfo("verifying 'Search button' Logo visible or not");
		test = extent.createTest("tc_26 verifying 'Search button' Logo");
		test.log(Status.INFO, "verifing 'Search button' Logo visible or not");
	}

	@Test
	public void tc_27() {
		homepage.getEN_Global_Image();
		Assert.assertTrue(true);
		Keyword.loggerInfo("verifying 'global' Image visible or not");
		test = extent.createTest("tc_27 verifying 'global' Image");
		test.log(Status.INFO, "verifying 'global' Image visible or not");
	}

	@Test
	public void tc_28() {
		homepage.getENLanguageText();
		Assert.assertEquals(Constants.actual, "EN", "search result text failed");
		Keyword.loggerInfo("verifying 'EN' text visible or not");
		test = extent.createTest("tc_28 verifying 'EN' text");
		test.log(Status.INFO, "verifying 'EN' text visible or not");
	}

	@Test
	public void tc_29() {
		homepage.clickOnEN_LanguageImage();
		Constants.actual = Constants.driver.getTitle();
		Assert.assertTrue((Constants.actual).contains("Change Language Settings"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying  by clicking on 'EN' will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_29 verifying 'EN' text clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'EN' will it switch to on next page or not");
	}

	@Test
	public void tc_30() {
		homepage.getHelloSignInText();
		Assert.assertEquals(Constants.actual, "Hello, Sign in", "search result text failed");
		Keyword.loggerInfo("verifying 'Hello. Sign in' text visible or not");
		test = extent.createTest("tc_30 verifying 'Hello. Sign in' text");
		test.log(Status.INFO, "verifying 'Hello. Sign in' text visible or not");
	}

	@Test
	public void tc_31() {
		homepage.getAccountListsText();
		Assert.assertEquals(Constants.actual, "Account & Lists", "search result text failed");
		Keyword.loggerInfo("verifying 'Account & Lists' text visible or not");
		test = extent.createTest("tc_31 verifying 'Account & Lists' text");
		test.log(Status.INFO, "verifying 'Account & Lists' text visible or not");
	}

	@Test
	public void tc_32() {
		homepage.clickOnHelloSignIn_AccountList();
		Constants.actual = Constants.driver.getTitle();
		Assert.assertTrue((Constants.actual).contains("Amazon Sign In"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'Hello sign.in' will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_32 verifying 'Hello sign.in' text clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'Hello sign.in' will it switch to on next page or not");
	}

	@Test
	public void tc_33() {
		homepage.getReturnText();
		Assert.assertEquals(Constants.actual, "Returns", "search result text failed");
		Keyword.loggerInfo("verifying 'Returns' text visible or not");
		test = extent.createTest("tc_33 verifying 'Returns' text");
		test.log(Status.INFO, "verifying 'Returns' text visible or not");
	}

	@Test
	public void tc_34() {
		homepage.getOrderText();
		Assert.assertEquals(Constants.actual, "& Orders", "search result text failed");
		Keyword.loggerInfo("verifying '& Orders' text visible or not");
		test = extent.createTest("tc_34 verifying '& Orders' text");
		test.log(Status.INFO, "verifying '& Orders' text visible or not");
	}

	@Test
	public void tc_35() {
		homepage.clickOnReturnOrder();
		Constants.actual = Constants.driver.getTitle();
		System.out.println(Constants.actual);
		Assert.assertTrue((Constants.actual).contains("Amazon Sign In"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'returns and orders' will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_35 verifying 'returns and orders' tool clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'returns and orders' will it switch to on next page or not");
	}

	@Test
	public void tc_36() {
		homepage.getTryText();
		Assert.assertEquals(Constants.actual, "Try", "search result text failed");
		Keyword.loggerInfo("verifying 'Try' text visible or not");
		test = extent.createTest("tc_36 verifying 'Try' text");
		test.log(Status.INFO, "verifying 'Try' text visible or not");
	}

	@Test
	public void tc_37() {
		homepage.getPrimeText();
		Assert.assertEquals(Constants.actual, "Prime", "search result text failed");
		Keyword.loggerInfo("verifying 'Prime' text visible or not");
		test = extent.createTest("tc_37 verifying 'Try' text");
		test.log(Status.INFO, "verifying 'Try' text visible or not");
	}

	@Test
	public void tc_38() {
		homepage.clickOnTryPrimeTool();
		Constants.actual = Constants.driver.getTitle();
		Assert.assertTrue((Constants.actual).equalsIgnoreCase("Amazon.in: Amazon Prime"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'TryPrime' will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_38 verifying 'TryPrime' tool clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'TryPrime' tool will it switch to on next page or not");
	}

	@Test
	public void tc_39() {
		homepage.getCartIcon();
		Assert.assertTrue(true);
		Keyword.loggerInfo("verifying 'Cart' Icon visible or not");
		test = extent.createTest("tc_39 verifying 'Cart' Icon");
		test.log(Status.INFO, "verifying 'Cart' Icon visible or not");
	}

	@Test
	public void tc_40() {
		homepage.getCartText();
		Assert.assertEquals(Constants.actual, "Cart", "search result text failed");
		Keyword.loggerInfo("verifying 'Cart' text visible or not");
		test = extent.createTest("tc_40 verifying 'Cart' text");
		test.log(Status.INFO, "verifying 'Cart' text visible or not");
	}

	@Test
	public void tc_41() {
		homepage.getZeroNumber();
		Assert.assertEquals(Constants.actual, "0", "search result text failed");
		Keyword.loggerInfo("verifying '0' number visible or not");
		test = extent.createTest("tc_41 verifying '0' number");
		test.log(Status.INFO, "verifying '0' number visible or not");
	}

	@Test
	public void tc_42() {
		homepage.clickCartTool();
		Constants.actual = Constants.driver.getTitle();
		System.out.println(Constants.actual);
		Assert.assertTrue((Constants.actual).contains("Amazon.in Shopping Cart"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'cart' will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_42 verifying 'cart' tool clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'cart' tool will it switch to on next page or not");
	}

	@Test
	public void tc_43() {
		homepage.getyourAddressIcon();
		Assert.assertTrue(true);
		Keyword.loggerInfo("verifying 'adress glow' icon  visible or not");
		test = extent.createTest("tc_43 verifying 'adress glow' Icon");
		test.log(Status.INFO, "verifying 'adress glow' Icon visible or not");
	}

	@Test
	public void tc_44() {
		homepage.getHelloText();
		Assert.assertEquals(Constants.actual, "Hello", "search result text failed");
		Keyword.loggerInfo("verifying 'Hello' text visible or not");
		test = extent.createTest("tc_44 verifying 'Hello' text");
		test.log(Status.INFO, "verifying 'Hello' text visible or not");
	}

	@Test
	public void tc_45() {
		homepage.getSelectYourAddressText();
		Assert.assertEquals(Constants.actual, "Select your address", "search result text failed");
		Keyword.loggerInfo("verifying 'Select your address' text visible or not");
		test = extent.createTest("tc_45 verifying 'Select your address' text");
		test.log(Status.INFO, "verifying 'Select your address' text visible or not");
	}

	@Test
	public void tc_46() {
		homepage.clickOnSelectYourAddress();
		homepage.enterPincodeInPincodeBox("444604");
		homepage.clickOnApplyPincodeBtn();
		Keyword.loggerInfo(
				"verifying by clicking on 'select_your_address' element popup will visible or not and entering text on 'address' box and click on 'Apply tab'");
		test = extent.createTest("tc_46 verifying 'select_your_address' popup clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'select_your_address' tool popup will visible or not");
	}

	@Test
	public void tc_47() {
		homepage.clickOnMobile_Option();
		Constants.actual = Constants.driver.getTitle();
		Assert.assertTrue((Constants.actual).contains(
				"Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'Mobile' option from shopping container will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_47 verifying 'Mobile' option clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'Mobile' option will it switch to on next page or not");
	}

	@Test
	public void tc_48() {
		homepage.clickOnBest_Sellers_Option();
		Constants.actual = Constants.driver.getTitle();
		Assert.assertEquals(Constants.actual,"Amazon.in Bestsellers: The most popular items on Amazon");
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'Best Sellers' option from shopping container will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_48 verifying 'Best Sellers' option clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'Best Sellers' option will it switch to on next page or not");
	}

	@Test
	public void tc_49() {
		homepage.clickOnPantry_Option();
		Constants.actual = Constants.driver.getTitle();
		System.out.println("PANTRY-"+Constants.actual);
		Assert.assertEquals(Constants.actual,"Amazon Pantry: The Online Grocery Shopping Store- Shop Daily Grocery Items and Get delivered in Next Day- Amazon.in");
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'Pantry' option from shopping container will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_49 verifying 'Pantry' option clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'Pantry' option will it switch to on next page or not");
	}

	@Test
	public void tc_50() {
		homepage.clickOnAmazon_Pay_Option();
		Constants.actual = Constants.driver.getTitle();
		Assert.assertEquals(Constants.actual,"Amazon Pay");
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'Amazon Pay' option from shopping container will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_50 verifying 'Amazon Pay' option clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'Amazon Pay' option will it switch to on next page or not");
	}

	@Test
	public void tc_51() {
		homepage.clickOnComputers_Option();
		Constants.actual = Constants.driver.getTitle();
		Assert.assertEquals(Constants.actual,"Computers & Accessories: Buy Computers & Accessories Online at Low Prices in India - Amazon.in");
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'Computers' option from shopping container will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_51 verifying 'Computers' option clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'Computers' option will it switch to on next page or not");
	}

	@Test
	public void tc_52() {
		homepage.clickOnNew_Releases_Option();
		Constants.actual = Constants.driver.getTitle();
		Assert.assertEquals(Constants.actual,"Amazon.in Hot New Releases: The bestselling new and future releases on Amazon");
		Constants.driver.navigate().back();
		Keyword.loggerInfo("verifying by clicking on 'New Releases' option from shopping container will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_52 verifying 'New Releases' option clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'New Releases' option will it switch to on next page or not");
	}

	@Test
	public void tc_53() {
		homepage.clickOnBooks_Option();
		Constants.actual = Constants.driver.getTitle();
		System.out.println("BOOK-"+Constants.actual);
		Assert.assertEquals(Constants.actual,"Book Store Online : Buy Books Online at Best Prices in India | Books Shopping @ Amazon.in");
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'Books' option from shopping container will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_53 verifying 'Books' option clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'Books' option will it switch to on next page or not");
	}

	@Test
	public void tc_54() {
		homepage.clickOnCustomer_Service_Option();
		Constants.actual = Constants.driver.getTitle();
		System.out.println("Costumet service-"+Constants.actual);
		Assert.assertEquals(Constants.actual,"Amazon.in Help: Help");
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'Customer Service' option from shopping container will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_54 verifying 'Customer Service' option clickable or not");
		test.log(Status.INFO,
				"verifying by clicking on 'Customer Service' option will it switch to on next page or not");
	}

	@Test
	public void tc_55() {
		homepage.clickOnSell_Option();
		Constants.actual = Constants.driver.getTitle();
		System.out.println("CART"+Constants.actual);
		Assert.assertEquals(Constants.actual,"Amazon.in: Selling on Amazon - Start Selling Now");
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'Sell' option from shopping container will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_55 verifying 'Sell' option clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'Sell' option will it switch to on next page or not");
	}

	@Test
	public void tc_56() {
		homepage.clickOnGift_Ideas_Option();
		Constants.actual = Constants.driver.getTitle();
		System.out.println("GIFT-"+Constants.actual);
		Assert.assertEquals(Constants.actual,"Amazon.in Shopping Cart");
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'Gift Ideas' option from shopping container will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_56 verifying 'Gift Ideas' option clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'Gift Ideas' option will it switch to on next page or not");
	}

	@Test
	public void tc_57() {
		homepage.clickOnBaby_Option();
		Constants.actual = Constants.driver.getTitle();
		System.out.println(Constants.actual);
		Assert.assertTrue((Constants.actual).contains("Amazon.in Shopping Cart"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'Baby' option from shopping container will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_57 verifying 'Baby' option clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'Baby' option will it switch to on next page or not");
	}

	@Test
	public void tc_58() {
		homepage.clickOnAmazon_Basics_Option();
		Constants.actual = Constants.driver.getTitle();
		System.out.println(Constants.actual);
		Assert.assertTrue((Constants.actual).contains("Amazon.in Shopping Cart"));
		Constants.driver.navigate().back();
		Keyword.loggerInfo(
				"verifying by clicking on 'AmazonBasics' option from shopping container will it switch to on next page and navigate back on previous page or not");
		test = extent.createTest("tc_58 verifying 'AmazonBasics' option clickable or not");
		test.log(Status.INFO, "verifying by clicking on 'AmazonBasics' option will it switch to on next page or not");
	}

	@Test
	public void tc_59() {
		homepage.getYourListsText();
		Constants.expected = "Your Lists";
		Assert.assertEquals(Constants.actual, Constants.expected);
		Keyword.loggerInfo("verifying 'Your Lists' text visible or not");
		test = extent.createTest("tc_59 verifying 'Your Lists' text");
		test.log(Status.INFO, "verifying 'Your Lists' text visible or not");

	}
	@Test
	public void tc_60() {
		homepage.getYourListsItems();
		List<WebElement> list = Constants.driver.findElements(By.cssSelector(PropertyUtility.getProperty("YourList")));
		Constants.actualList = new ArrayList();
		Iterator<WebElement> itr = list.iterator();
		while (itr.hasNext()) {
			Constants.actualList.add(itr.next().getText());
		}
		Keyword.readJsonFile("src/main/resources/AccountAndListContaint.json", "Your Lists");
		Assert.assertEquals(Constants.actualList, Constants.expectedList);
		Keyword.loggerInfo("verifing in 'Your Lists' items from Account & Lists tool");
		test = extent.createTest("tc_60 verifying items present in 'Your Lists");
		test.log(Status.INFO, "verifing in 'Your Lists' items as per expected");
	}

	@Test
	public void tc_61() {
		homepage.getYourAccountText();
		Constants.expected = "Your Account";
		Assert.assertEquals(Constants.actual, Constants.expected);
		Keyword.loggerInfo("verifying 'Your Account' text visible or not");
		test = extent.createTest("tc_61 verifying 'Your Account' text");
		test.log(Status.INFO, "verifying 'Your Account' text visible or not");
	}

	@Test
	public void tc_62() {
		homepage.getyourAccountItems();
		List<WebElement> list = Constants.driver
				.findElements(By.cssSelector(PropertyUtility.getProperty("YourAccount")));
		Constants.actualList = new ArrayList();
		Iterator<WebElement> itr = list.iterator();
		while (itr.hasNext()) {
			Constants.actualList.add(itr.next().getText());
		}
		System.out.println(Constants.actualList);
		Keyword.readJsonFile("src/main/resources/AccountAndListContaint.json", "Your Account");
		Assert.assertEquals(Constants.actualList, Constants.expectedList);
		Keyword.loggerInfo("verifing in 'Your Account' items from Account & Lists tool");
		test = extent.createTest("tc_62 verifying items present in 'Your Account");
		test.log(Status.INFO, "verifing in 'Your Account' items as per expected");
	}

	@AfterTest
	public void quitDriver() {
		Constants.driver.close();
		Constants.driver.quit();
		Keyword.loggerInfo("Close the current window and quits this driver, closing every associated window");
	}

	@AfterMethod
	public void tearTest(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			test.fail("Test Faild ", MediaEntityBuilder
					.createScreenCaptureFromPath(PropertyUtility.captureScreenshot(Constants.driver, result.getName()))
					.build());
		} else if (ITestResult.SUCCESS == result.getStatus()) {
			test.pass("Test Passed ", MediaEntityBuilder
					.createScreenCaptureFromPath(PropertyUtility.captureScreenshot(Constants.driver, result.getName()))
					.build());
		}
		extent.flush();

	}
}