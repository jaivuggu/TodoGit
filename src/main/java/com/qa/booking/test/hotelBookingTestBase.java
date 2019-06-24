 package com.qa.booking.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import hotelUtil.testUtil;

public class hotelBookingTestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public hotelBookingTestBase () {

		try {

			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\Jai\\eclipse-workspace\\test\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(ip);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}

	}



public static void initialization() {
	
	String browserName = prop.getProperty("browser");
	if(browserName.equals("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Other files\\chromedriver.exe");
		
		driver = new ChromeDriver();
	}else if (browserName.equals("FF")) {

		System.setProperty("webdriver.gecko.driver", "F:\\Other files\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
	}
	
	
	driver.get(prop.getProperty("url"));

	driver.manage().window().maximize();
	
	driver.manage().timeouts().pageLoadTimeout(testUtil.Page_Load_TimeOut, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(testUtil.Implicit_Wait, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();



	
}

}
