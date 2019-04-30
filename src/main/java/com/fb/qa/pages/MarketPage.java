package com.fb.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fb.qa.base.TestBase;
import com.fb.qa.util.TestUtil;

public class MarketPage extends TestBase {

	@FindBy(xpath = "//input[ @class='_58al' and @aria-controls='js_3' and @type='text']")
	WebElement searchItem;

	@FindBy(xpath = "//input[@placeholder='Min']")
	WebElement minPrice;

	@FindBy(xpath = "//input[@placeholder='Max']")
	WebElement maxPrice;

	@FindBy(xpath = "//input[@type='text' and @class='_58al' and @aria-autocomplete='list' and @aria-controls='js_1']")
	WebElement location;

	@FindBy(xpath = "//i[ @class='img sp_sXEen-N7SfC_1_5x sx_d2cb4c']")
	WebElement searchButton;

	public MarketPage() {
		PageFactory.initElements(driver, this);
	}

	public MarketPage login(String item, String minprice, String maxprice, String loction) throws InterruptedException {

		

		// searchItem.submit();
		// Thread.sleep(3000);

		minPrice.clear();
		minPrice.sendKeys(minprice);
		Thread.sleep(3000);

		maxPrice.clear();
		maxPrice.sendKeys(maxprice);
		Thread.sleep(3000);

		//location.click();
		
		
		
		
		searchItem.clear();
		searchItem.sendKeys(item);
		Actions itemList = new Actions(driver);
        Action mouseOverItem = itemList.moveToElement(searchItem).click().build();
		//searchButton.click();

		Thread.sleep(3000);
		

		// ((JavascriptExecutor)driver).executeScript("arguments[0].click();",searchButton);
		searchButton.click();
		
		location.clear();
		location.sendKeys(loction);
		location.sendKeys(Keys.RETURN);
		
//		Actions locationList = new Actions(driver);
//        Action mouseOverLocation = locationList.moveToElement(location).click().build();
    	searchButton.click();
		Thread.sleep(3000);

		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Thread.sleep(30000);

		return new MarketPage();

	}
}