package com.qa.pages;

import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class roughwork {
	/*
	WebElement date= driver.findElement(By.xpath("//div[@data-sb-id='main' and @data-calendar2-type='checkin']"));
	String dateVal="Wed, Jul 31";
public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal){
JavascriptExecutor js=((JavascriptExecutor)driver);
js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');",element);
}
*/	
	public static WebDriver driver;
	
	@FindBy(xpath="//div[@id='filter_facilities']//a[@data-id='hotelfacility-54']/div[@class='bui-checkbox__label filter_item css-checkbox']")
	WebElement spabutton;
	
	public roughwork() {
		PageFactory.initElements(driver, this);
		}
		
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		String month="November 2019";
		String day="9";
		System.setProperty("webdriver.chrome.driver", "F:\\Other files\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.booking.com");
		driver.navigate().refresh();
		//driver.findElement(By.xpath("//input[@id='ss']")).sendKeys("Limerick");
		
		
		
		/*Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@data-component='search/destination/input']/descendant::li[1]"))).build().perform();
		driver.findElement(By.xpath("//div[@data-component='search/destination/input']/descendant::li[1]")).click();
		*/
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//input[@id='ss']"))).build().perform();
		driver.findElement(By.xpath("//input[@id='ss']")).sendKeys("Limerick, Limerick County, Ireland");

		Thread.sleep(1000);;
		
		//driver.findElement(By.xpath("//div[@class='bicon bicon-aclose header-signin-prompt__close']")).click(); //Header box
		
		
		
		
		driver.findElement(By.xpath("//div[@data-sb-id='main' and @data-calendar2-type='checkin']")).click();
		

		while(true) {
		
		//String text = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[2]/div/div/div/div/div[2]")).getText();
		
		String text = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/div")).getText();
		
		
		System.out.println("this is the month"+text);
			
		if(text.equals(month)) {
			break;
		}
		else {
			driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[2]")).click();
		}
		}
		
		driver.findElement(By.xpath(" //*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr/td[contains(text(),"+day+")]")).click();
		
		
		driver.findElement(By.xpath("//span[@class='xp__guests__count']/span[1]")).click(); // 2 adults
		
		driver.findElement(By.xpath("//div[@class='xp__button']/descendant::span[1]")).click(); // 1 room
		
		
		
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Show all 13')]"));//selecting show 13 elements
		
		Coordinates coordinate = ((Locatable)element).getCoordinates();
		coordinate.inViewPort();
		
		driver.findElement(By.xpath("//a[contains(text(),'Show all 13')]")).click(); // this is select the show 13 options on the page
		
		driver.findElement(By.xpath("//div[@id='filter_facilities']//a[@data-id='hotelfacility-54']/div[@class='bui-checkbox__label filter_item css-checkbox']")).click();
		//  this will click on spa option
		
		
		
		
	/* List<WebElement> list =driver.findElements(By.xpath("//div[@id='filter_facilities']//a[@data-id='hotelfacility-54']/div[@class='bui-checkbox__label filter_item css-checkbox']"));
		// this is for the SPA Check only
		for (WebElement links : list) {
			
			String linktext = links.getText();
			System.out.println("the links are     "+ linktext);
		
		} */
		System.out.println("******************************************************************************************");

			
		Thread.sleep(2000);
		
		List<WebElement> list1 =driver.findElements(By.xpath("//a[@class='hotel_name_link url']"));
		
		for (WebElement nooflinks : list1) {
			
			String hotelslist= nooflinks.getText();
			System.out.println("The hotels list are  " + hotelslist);
			
			
			
		}
	
		
		
		List<WebElement> spa = driver.findElements(By.xpath("//*[@id=\"search_results_table\"]/div[3]/div[2]/ul[1]/li/a"));
		
		for (WebElement spalist : spa) {
			
			String spalinks = spalist.getText();
			
			System.out.println("The spa links are  "+ spalinks);
		}
		
		
		String nameproperty = driver.findElement(By.xpath("//*[@id=\"right\"]/div[3]/div/div/div/h1")).getText();
		System.out.println("The property name "+ nameproperty);
		
		/*
		 
		List<WebElement> hotelslist = driver.findElements(By.xpath("//div[starts-with(@class,'sr_item  sr_item_new sr_item_default sr_property_block  sr_flex_layout')]"));
		
		for (WebElement Hlist : hotelslist) {
		String	HL=Hlist.getText();
		
		System.out.println("The List are  = " + HL);
		}
		
		System.out.println("******************************************************************************************");
			//Thread.sleep(10000);
		*/

		driver.close();
	
		
	

		
	
	
	}


	
	
		
	}


