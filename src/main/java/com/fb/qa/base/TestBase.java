package com.fb.qa.base;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fb.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\sunil\\Documents\\priya\\HybridFramework\\src\\main\\java\\com\\fb\\qa\\config\\config.properties");
			prop.load(ip);
		}catch (Exception e) {
			
		}
		
	}
	public static void intialization() {
		 // Create object of HashMap Class
		Map<String, Object> prefs = new HashMap<String, Object>();
              
                // Set the notification setting it will override the default setting
		prefs.put("profile.default_content_setting_values.notifications", 2);
 
                // Create object of ChromeOption class
		ChromeOptions options = new ChromeOptions();
 
                // Set the experimental option
		options.setExperimentalOption("prefs", prefs);
		//driver = new ChromeDriver(options);
		
		String browserName=prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Priya\\drivers\\chromedriver.exe");	
			driver=new ChromeDriver(options);
		}else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Priya\\drivers\\geckodriver.exe");	
			driver=new FirefoxDriver();
		}
		
		 
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	}

}
