package com.jstech.testusingselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jstech.testusingselenium.config.ChromeInitializer;

public class TestDynamicContent {

	ChromeInitializer initializer = new ChromeInitializer();
	WebDriver driver;
	private static String BASE_URL;

	@BeforeClass
	void init() {
		BASE_URL = "https://the-internet.herokuapp.com/dynamic_content";
		driver = initializer.getDriver();
	}
	
	@Test
	void testDynamicityOfContentWithoutMakingContentStatic() {
		driver.get(BASE_URL);
		String textBefore = driver.findElement(By.xpath("//div[@class = 'large-10 columns large-centered']/div[3]/div[2]")).getText();
		driver.navigate().refresh();
		String textAfter = driver.findElement(By.xpath("//div[@class = 'large-10 columns large-centered']/div[3]/div[2]")).getText();
		Assert.assertEquals(textBefore.equals(textAfter), false);
	}
	
	@Test
	void testDynamicityOfContent() {
		driver.get(BASE_URL+"?with_content=static");
		String textBefore = driver.findElement(By.xpath("//div[@class = 'large-10 columns large-centered']/div[2]/div[2]")).getText();
		driver.navigate().refresh();
		String textAfter = driver.findElement(By.xpath("//div[@class = 'large-10 columns large-centered']/div[2]/div[2]")).getText();
		Assert.assertEquals(textBefore.equals(textAfter), true);
	}
}
