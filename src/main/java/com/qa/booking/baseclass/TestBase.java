package com.qa.booking.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.bookingutil.testUtil;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;

	
	
	
	public TestBase() {

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
	

	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(testUtil.Page_Load_TimeOut, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(testUtil.Implicit_Wait, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	driver.navigate().refresh();

	
	
}
	
	
	
	
	

}
