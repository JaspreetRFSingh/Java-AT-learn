package com.jstech.testusingselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jstech.testusingselenium.config.ChromeInitializer;

public class TestDynamicLoading {

	ChromeInitializer initializer = new ChromeInitializer();
	WebDriver driver;
	private static String BASE_URL;
	

	@BeforeClass
	void init() {
		driver = initializer.getDriver();
		BASE_URL = "https://the-internet.herokuapp.com/dynamic_loading";
	}
	
	@Test
	void testHiddenElement() {
		try {
			driver.get(BASE_URL+"/1");
			String textAtFinishId = driver.findElement(By.xpath("//div[@id='finish']")).getText();
			driver.findElement(By.xpath("//div[@id='start']/button")).click();
			Thread.sleep(8000);
			String textAtFinishIdAfter = driver.findElement(By.xpath("//div[@id='finish']")).getText();
			Assert.assertEquals(textAtFinishId, "");
			Assert.assertEquals(textAtFinishIdAfter, "Hello World!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testElementRenderedAfterwards() {
		try {
			driver.get(BASE_URL+"/2");
			WebElement element = driver.findElement(By.xpath("//div[@class = 'example']/div[1]"));
			element.findElement(By.xpath("//div[@class = 'example']/div[1]/button")).click();
			Thread.sleep(8000);
			element = driver.findElement(By.xpath("//div[@class = 'example']/div[1]"));
			String actualStringDisplayed = element.getText();
			Assert.assertEquals(actualStringDisplayed, "Hello World!");
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
