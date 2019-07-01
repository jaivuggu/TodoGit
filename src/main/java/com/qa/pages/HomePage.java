package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.booking.baseclass.TestBase;

public class HomePage extends TestBase {
	
	
	
	@FindBy(xpath="//a[contains(text(),'Show all 13')]")
	WebElement showall13;
	
	@FindBy(xpath="//div[@id='filter_facilities']//a[@data-id='hotelfacility-54']/div[@class='bui-checkbox__label filter_item css-checkbox']")
	WebElement Spa;
	
	@FindBy(xpath="//a[@class='hotel_name_link url']")
	WebElement Hotelname;
	
	
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	public TaskPage HomePage() throws InterruptedException {
		
	
		
WebElement element = showall13; //selecting show 13 elements
		
		Coordinates coordinate = ((Locatable)element).getCoordinates();
		coordinate.inViewPort();
		Spa.click();
		
	
			return new TaskPage();
 			
			
		}
	
	
	
	
	
	}
	

	
	





