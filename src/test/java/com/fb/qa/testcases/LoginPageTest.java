package com.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	public LoginPage loginPage;
	public HomePage homePage;
	
	 public LoginPageTest() {
		
		super();
	}

	@BeforeMethod
	public void setUp() {
		intialization();
	 loginPage=new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Facebook - Log In or Sign Up");
		
	}
	
	@Test(priority = 2)
	public void fbLogoTest() {
		boolean flag=loginPage.validateFbImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void LoginTest() {
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
