package com.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.FindFriends;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.MarketPage;
import com.fb.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	FindFriends contactsPage;
	MarketPage marketlist;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intialization();
		testUtil=new TestUtil();
		contactsPage=new FindFriends();
	 loginPage=new LoginPage();
	 marketlist=new MarketPage();
	 homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Facebook", "home page title not matched ");
		
	}
	@Test(priority = 2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		contactsPage=homePage.clickOnContactsLink();
	}
	@Test(priority=4)
	public void verifyMarketListTest() {
		marketlist=homePage.clickDealsLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
