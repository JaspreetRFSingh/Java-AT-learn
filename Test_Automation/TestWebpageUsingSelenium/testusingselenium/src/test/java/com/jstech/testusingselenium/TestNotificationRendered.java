package com.jstech.testusingselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jstech.testusingselenium.config.ChromeInitializer;

public class TestNotificationRendered {

	
	ChromeInitializer initializer = new ChromeInitializer();
	WebDriver driver;
	private static String BASE_URL;

	@BeforeClass
	void init() {
		driver = initializer.getDriver();
		BASE_URL = "https://the-internet.herokuapp.com/notification_message_rendered";
	}
	
	@Test
	void testAlertMessage() {
		try {
			
			driver.get(BASE_URL);
			WebElement hyperlink = driver.findElement(By.xpath("//a[@href='/notification_message']"));
			hyperlink.click();
			Thread.sleep(2500);
			WebElement notificationAlert = driver.findElement(By.xpath("//div[@id='flash-messages']/div[@id='flash']"));
			String notificationMessage = notificationAlert.getAttribute("class");
			System.out.println(notificationMessage);
			Assert.assertEquals(notificationMessage, "flash notice");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
