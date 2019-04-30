package com.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class FindFriends extends TestBase {
	
	@FindBy(xpath="//h2[@class='_34e']")
	WebElement requestSent;
	
	public FindFriends() {
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyRequestSentLabel()
	{
		return requestSent.isDisplayed();
	}
	
	

}
