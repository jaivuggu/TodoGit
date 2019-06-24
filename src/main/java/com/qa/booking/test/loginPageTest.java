package com.qa.booking.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.loginPage;

public class loginPageTest extends hotelBookingTestBase{

	
	loginPage LP;
	HomePage HP;
	
	public loginPageTest() {
		
		
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		
		LP= new loginPage();
		
	}
	
	
	@Test()
	
	public void LoginTest() {
		
		LP.login();
	}
	

	@AfterMethod
	
	public void teardown() {
	driver.quit();
	}
}
