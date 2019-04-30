package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.FindFriends;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.MarketPage;
import com.fb.qa.util.TestUtil;

public class MarketTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	FindFriends contactsPage;
	TestUtil testUtil;
	MarketPage marketPage;
	
	String sheetName="HybridFacebook";
	
	public MarketTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intialization();
		contactsPage=new FindFriends();
		testUtil=new TestUtil();
	 loginPage=new LoginPage();
	 marketPage=new MarketPage();
	 homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	 marketPage=homePage.clickDealsLink();
	}
	
	@DataProvider
	public Object[][] getFacebookTestData() {
	Object data[][]=TestUtil.getTestData(sheetName);
	return data;
	}
	
	@Test(dataProvider = "getFacebookTestData")
	public void verifyMarketPage(String minprice,String maxprice,String item,String location) throws InterruptedException {
		
		//driver.manage().deleteAllCookies();
		marketPage.login(minprice, maxprice, item,location);
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
