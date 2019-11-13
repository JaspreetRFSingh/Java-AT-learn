package com.jstech.testusingselenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jstech.testusingselenium.config.ChromeInitializer;

public class TestWindowHandle {
	ChromeInitializer initializer = new ChromeInitializer();
	WebDriver driver;
	private static String BASE_URL;

	@BeforeClass
	void init() {
		driver = initializer.getDriver();
		BASE_URL = "https://the-internet.herokuapp.com/windows";
	}
	
	@Test
	void testWhetherNewWindowOpened() {
		driver.get(BASE_URL);
		WebElement element = driver.findElement(By.xpath("//div[@class='example']/a"));
		element.click();
		Set<String> windowHandles = driver.getWindowHandles();
        for(String winHandle : windowHandles){
            driver.switchTo().window(winHandle);
        }
        
		String actualNewWindowTitle = driver.getTitle();
		String expectedNewWindowtitle = "New Window";
		
		Assert.assertEquals(actualNewWindowTitle, expectedNewWindowtitle);
	}
}
