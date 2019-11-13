package com.jstech.testusingselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jstech.testusingselenium.config.ChromeInitializer;

public class TestHerokuApp {
	ChromeInitializer initializer = new ChromeInitializer();
	WebDriver driver;

	@BeforeClass
	void init() {
		driver = initializer.getDriver();
	}
	
	@Test
	void testAddRemoveElements() {
		driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
		driver.findElement(By.xpath("//div[@class='example']/button")).click();
		driver.findElement(By.xpath("//*[@id=\"elements\"]/button")).click();
	}
	
	@Test
	void testCheckBox() {
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		WebElement element = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
		element.click();
		
	}
	
	@Test
	void testInput() {
		driver.get("https://the-internet.herokuapp.com/inputs");
		WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")); 
	
		element.sendKeys("23");
		element.sendKeys(Keys.ARROW_UP);
		String actual = element.getText();
		String expected = "24";
		Assert.assertEquals(actual, expected);
	} 
	
	
	@Test
	void testDropdown() {
		driver.get("https://the-internet.herokuapp.com/dropdown");
		WebElement element = driver.findElement(By.xpath("//select[@id='dropdown']/option[@value='2']"));
		element.click();
		Assert.assertEquals(element.isSelected(), true);
	}
	
	@Test
	void testTypo() {
		driver.get("https://the-internet.herokuapp.com/typos");
		WebElement element = driver.findElement(By.xpath("//div[@class='example']/p[2]"));
		String elementText = element.getText();
		Assert.assertEquals(elementText, "Sometimes you'll see a typo, other times you won't.");
		
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
