package com.fb.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[contains(@class,'_1vp5')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[@id='findFriendsNav']")
	////div[@class='_cy7']
	WebElement contactsLink;
	
	@FindBy(xpath="//a[@class='_5afe' and @title='Marketplace']//div[@class='linkWrap noCount' and @dir='ltr'  ] ")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[@class='_5afe' and @title='News Feed']//div[@class='linkWrap noCount' and @dir='ltr'  ] ")
	WebElement tasksLink;
	
	
	//initializing the Page Objects
	
		public HomePage() {
			PageFactory.initElements(driver,this);
		}
		
		public String verifyHomePageTitle() {
			return driver.getTitle();
		}
		
		public boolean verifyCorrectUserName() {
			return userNameLabel.isDisplayed();
		}
		public FindFriends clickOnContactsLink() {
			//there was as element not clickable then used this code
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",contactsLink);
			//contactsLink.click();
			return new FindFriends();
		}
		
		public MarketPage clickDealsLink() {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",dealsLink);
			//dealsLink.click();
			return new MarketPage();
		}
		
		public NotificationsPage clickTaskLink() {
			tasksLink.click();
			return new NotificationsPage();
		}
}
