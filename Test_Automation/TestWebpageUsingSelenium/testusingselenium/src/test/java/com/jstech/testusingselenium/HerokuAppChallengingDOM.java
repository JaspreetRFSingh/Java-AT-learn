package com.jstech.testusingselenium;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jstech.testusingselenium.config.ChromeInitializer;

public class HerokuAppChallengingDOM {

	ChromeInitializer initializer = new ChromeInitializer();
	WebDriver driver;
	private static String BASE_URL;
	

	@BeforeClass
	void init() {
		driver = initializer.getDriver();
		BASE_URL = "https://the-internet.herokuapp.com/challenging_dom";
	}
	
	@Test
	void testChallengingDOM() {
		List<String> buttonTextList = Arrays.asList("foo", "bar", "baz", "qux");
		driver.get(BASE_URL);
		WebElement element;
		for(int i=0; i<5; i++) {
			element = driver.findElement(By.xpath("//div[@class='large-2 columns']/a[@class='button']"));
			Assert.assertEquals(buttonTextList.contains(element.getText()), true);
			element.click();
		}
		for(int i=0; i<5; i++) {
			element = driver.findElement(By.xpath("//div[@class='large-2 columns']/a[@class='button alert']"));
			Assert.assertEquals(buttonTextList.contains(element.getText()), true);
			element.click();
		}
		for(int i=0; i<5; i++) {
			element = driver.findElement(By.xpath("//div[@class='large-2 columns']/a[@class='button success']"));
			Assert.assertEquals(buttonTextList.contains(element.getText()), true);
			element.click();
		}
	}
	
	@Test
	void testEditButton() {
		driver.get(BASE_URL);
		driver.findElement(By.xpath("//div[@class='large-10 columns']/table/tbody/tr/td/a[@href = '#edit']")).click();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://the-internet.herokuapp.com/challenging_dom#edit";
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test
	void testDeleteButton() {
		driver.get(BASE_URL);
		driver.findElement(By.xpath("//div[@class='large-10 columns']/table/tbody/tr/td/a[@href = '#delete']")).click();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://the-internet.herokuapp.com/challenging_dom#delete";
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
}
