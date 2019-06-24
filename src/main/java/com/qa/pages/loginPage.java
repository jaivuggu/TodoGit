package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.booking.test.hotelBookingTestBase;

public class loginPage  extends hotelBookingTestBase{
	
	
	
	
	@FindBy(xpath="//input[@type='search' and @id='ss']")
	WebElement SearchBox;
	
	
	@FindBy(xpath="//div[@class='bicon bicon-aclose header-signin-prompt__close']")
	WebElement HeaderBox;
	
	
	@FindBy(xpath="//div[@data-component='search/destination/input']/descendant::li[1]") 
	WebElement Destination;
	
	@FindBy(xpath="//form[@id='frm']/descendant::div[@class='sb-searchbox__input sb-date-field__field sb-date__field-svg_icon']/descendant::span[1]")
	WebElement DatePickup;
	
	
	//Actions action = new Actions(driver);
	//action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author')]"))).build().perform();
	
public loginPage() {
PageFactory.initElements(driver, this);
}

/*
public String ValidateLoginPage() {
	return driver.getTitle();
}


public boolean ValidateLogoImage() {
	return Logo.isDisplayed();
}
*/

public HomePage login()  {

	HeaderBox.click();
	Actions action = new Actions(driver);
    action.moveToElement(SearchBox).build().perform();
	
	
	SearchBox.sendKeys("Limerick");
	//Destination.click();
	
	
	DatePickup.click();
	
	
	
	return new HomePage();
}
}


