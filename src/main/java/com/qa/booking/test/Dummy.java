package com.qa.booking.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Dummy {

	WebDriver driver;
	
	

	
	
	
	
	
	@Test
	public void validatePage() {
		

		System.setProperty("webdriver.chrome.driver", "F:\\Other files\\chromedriver.exe");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.booking.com");
		
	
		driver.close();
	}
	
	
	
	
	
}
