package com.jstech.testusingselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jstech.testusingselenium.config.ChromeInitializer;

public class TestFrames {

	ChromeInitializer initializer = new ChromeInitializer();
	WebDriver driver;
	private static String BASE_URL;

	@BeforeClass
	void init() {
		driver = initializer.getDriver();
		BASE_URL = "https://the-internet.herokuapp.com";
	}
	
	@Test
	void testFrameNavigation() {
		driver.get(BASE_URL+"/frames");
		WebElement element = driver.findElement(By.xpath("//a[@href='/nested_frames']"));
		element.click();
		String actual = driver.getCurrentUrl();
		String expected = BASE_URL + "/nested_frames";
		Assert.assertEquals(actual, expected);
	}
	@Test
	void testFrameNavigationIframe() {
		driver.get(BASE_URL+"/frames");
		WebElement element = driver.findElement(By.xpath("//a[@href='/iframe']"));
		element.click();
		String actual = driver.getCurrentUrl();
		String expected = BASE_URL + "/iframe";
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	void testTextInsideIFrame() {
		driver.get(BASE_URL+"/iframe");
		WebElement element = driver.findElement(By.xpath("//textarea[@id='mce_0']"));
		element.clear();
		String keysToSend = "Hi, I am Jaspreet Singh";
		element.sendKeys(keysToSend);
		String textRetrieved = element.getText();
		Assert.assertEquals(keysToSend.equals(textRetrieved), true);
	}
}
