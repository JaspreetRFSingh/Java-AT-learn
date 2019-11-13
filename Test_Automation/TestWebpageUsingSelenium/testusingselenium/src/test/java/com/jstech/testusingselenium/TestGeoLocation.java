package com.jstech.testusingselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jstech.testusingselenium.config.ChromeInitializer;

public class TestGeoLocation {

	ChromeInitializer initializer = new ChromeInitializer();
	WebDriver driver;
	private static String BASE_URL;
	

	@BeforeClass
	void init() {
		driver = initializer.getDriver();
		BASE_URL = "https://the-internet.herokuapp.com/geolocation";
	}
	
	
	@Test
	void testGeoLocation() {
		try {
			driver.navigate().to(BASE_URL);		
			WebElement locationButton = driver.findElement(By.tagName("button"));
			locationButton.click();
			Thread.sleep(6000);
			driver.findElement(By.partialLinkText("on Google")).click();
			Thread.sleep(2000);
			driver.navigate().back(); 
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
