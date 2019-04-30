package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.FindFriends;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.util.TestUtil;

public class FindFriendsTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	FindFriends contactsPage;
	TestUtil testUtil;
	
	
	public FindFriendsTest() {
		super();
	}
	
		
		@BeforeMethod
		public void setUp() {
			intialization();
			contactsPage=new FindFriends();
			testUtil=new TestUtil();
		 loginPage=new LoginPage();
		 homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 contactsPage=homePage.clickOnContactsLink();
		}
		
		@Test
		public void verifyContactsPageLabel() {
			boolean displayed=contactsPage.verifyRequestSentLabel();
			System.out.println(displayed);
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
	}


