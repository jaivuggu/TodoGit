package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.booking.baseclass.TestBase;

import okhttp3.internal.connection.RouteSelector.Selection;

public class loginPage  extends TestBase{
	
	String month="November 2019";
	String day="9";
	
	@FindBy(xpath="//input[@id='ss']")
	WebElement SearchBox; // type to enter destination
	
	
	@FindBy(xpath="//div[@class='bicon bicon-aclose header-signin-prompt__close']")
	WebElement HeaderBox;
	
	
	
	@FindBy(xpath="//div[@data-sb-id='main' and @data-calendar2-type='checkin']") 
	WebElement Checkin;
	
	@FindBy(xpath="//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[2]/svg/path")
	WebElement Calender;
	
	
	@FindBy(xpath="//*[@id=\\\"frm\\\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr/td[contains(text(),\"+day+\")]")
	WebElement pickupdate;
	
	@FindBy(xpath="//*[@id=\\\"frm\\\"]/div[1]/div[2]/div[2]/div/div/div[2]")
	WebElement pickup; // doubt on this
	
	
	
	@FindBy(xpath="//span[@class='xp__guests__count']/span[1]")
	WebElement twoadults;
	
	@FindBy(xpath="//div[@class='xp__button']/descendant::span[1]")
	WebElement oneroom;
	
	
public loginPage() {
PageFactory.initElements(driver, this);
}


public HomePage login()  {

	
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath("//input[@id='ss']"))).build().perform();
	
	SearchBox.sendKeys("Limerick, Limerick County, Ireland");
	
	action.moveToElement(Checkin).build().perform();
	Checkin.click();
	
	while(true) {
	
	String text = Calender.getText();
	
	
	System.out.println("this is the month"+text);
		
	if(text.equals(month)) {
		break;
	}
	else {
		pickup.click();
	}


}	
	
	pickupdate.click();

	twoadults.click();
	
	oneroom.click();

	
	
	return new HomePage();
}
}



