package com.jstech.testusingselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jstech.testusingselenium.config.ChromeInitializer;

public class TestTableActions {
	ChromeInitializer initializer = new ChromeInitializer();
	WebDriver driver;
	private static String BASE_URL;

	@BeforeClass
	void init() {
		driver = initializer.getDriver();
		BASE_URL = "https://the-internet.herokuapp.com/tables";
	}
	@Test
	void testTableData() {
		driver.get(BASE_URL);
		WebElement element = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[3]"));
		String tableData = element.getText();
		String expectedTableData = "jdoe@hotmail.com";
		Assert.assertEquals(tableData, expectedTableData);
	}
	
	@Test
	void testTableDataWithClassesAndIds() {
		driver.get(BASE_URL);
		WebElement element = driver.findElement(By.xpath("//table[@id='table2']/tbody/tr[3]/td[@id='']"));
		String tableData = element.getText();
		String expectedTableData = "jdoe@hotmail.com";
		Assert.assertEquals(tableData, expectedTableData);
	}
	
	@Test
	void testDeleteActions() {
		driver.get(BASE_URL);
		WebElement element = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[6]/a[@href='#delete']"));
		element.click();
		String expectedUrl = BASE_URL+"#delete";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
		driver.navigate().to(BASE_URL);
		element = driver.findElement(By.xpath("//table[@id='table2']/tbody/tr[3]/td[6]/a[@href='#delete']"));
		element.click();
		String expectedUrlTable2 = BASE_URL+"#delete";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrlTable2);
	}
	
}
