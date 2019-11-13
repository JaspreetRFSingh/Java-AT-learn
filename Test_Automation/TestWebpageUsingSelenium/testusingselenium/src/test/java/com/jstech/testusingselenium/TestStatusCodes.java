package com.jstech.testusingselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jstech.testusingselenium.config.ChromeInitializer;

public class TestStatusCodes {
	
	ChromeInitializer initializer = new ChromeInitializer();
	WebDriver driver;
	private static String BASE_URL;

	@BeforeClass
	void init() {
		driver = initializer.getDriver();
		BASE_URL = "https://the-internet.herokuapp.com/status_codes";
	}
	
	String getString(String string) {
		return "This page returned a "+ string +" status code.";
	}
	
	
	
	@Test
	void testStatusCode200() {
		driver.get(BASE_URL);
		WebElement element = driver.findElement(By.xpath("//div[@class='example']/ul/li/a[@href='status_codes/200']"));
		element.click();
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = BASE_URL + "/200";
		Assert.assertEquals(currentUrl, expectedUrl);
	}
	@Test
	void testStatusCode301() {
		driver.get(BASE_URL);
		WebElement element = driver.findElement(By.xpath("//div[@class='example']/ul/li/a[@href='status_codes/301']"));
		element.click();
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = BASE_URL + "/301";
		Assert.assertEquals(currentUrl, expectedUrl);
	}
	@Test
	void testStatusCode404() {
		driver.get(BASE_URL);
		WebElement element = driver.findElement(By.xpath("//div[@class='example']/ul/li/a[@href='status_codes/404']"));
		element.click();
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = BASE_URL + "/404";
		Assert.assertEquals(currentUrl, expectedUrl);
	}
	@Test
	void testStatusCode500() {
		driver.get(BASE_URL);
		WebElement element = driver.findElement(By.xpath("//div[@class='example']/ul/li/a[@href='status_codes/500']"));
		element.click();
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = BASE_URL + "/500";
		Assert.assertEquals(currentUrl, expectedUrl);
	}
}
