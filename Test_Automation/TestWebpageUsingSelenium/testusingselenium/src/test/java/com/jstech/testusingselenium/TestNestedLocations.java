package com.jstech.testusingselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jstech.testusingselenium.config.ChromeInitializer;

public class TestNestedLocations {


	ChromeInitializer initializer = new ChromeInitializer();
	WebDriver driver;

	@BeforeClass
	void init() {
		driver = initializer.getDriver();
	}
	
	@Test
	void testLarge() {
		driver.get("https://the-internet.herokuapp.com/large");
		WebElement element = driver.findElement(By.xpath("//div[@id='sibling-50.3']"));
		String currentElementText = element.getText();
		Assert.assertEquals(currentElementText, "50.3");
	}
	
	@Test
	void testLargeTable() {
		driver.get("https://the-internet.herokuapp.com/large");
		WebElement element = driver.findElement(By.xpath("//tr[@class='row-50']/td[@class='column-50']"));
		String currentElementText = element.getText();
		Assert.assertEquals(currentElementText, "50.50");
	}
	
}
