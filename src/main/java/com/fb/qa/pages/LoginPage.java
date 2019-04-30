package com.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class LoginPage extends TestBase {
	// Page Factory - OR:
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(css="a[title=\"Go to Facebook home\"]")
	WebElement fbLogo;
	
	//initializing the Page Objects
		
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	//Actions:
	
public String validateLoginPageTitle() {
	return driver.getTitle();
}
	public boolean validateFbImage() {
		return fbLogo.isDisplayed();
	}

	public HomePage login(String email,String pw) {
		username.sendKeys(email);
		password.sendKeys(pw);
		loginBtn.click();
		
		return new HomePage();
	}
}
