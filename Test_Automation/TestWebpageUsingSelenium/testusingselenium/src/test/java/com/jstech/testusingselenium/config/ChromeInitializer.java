package com.jstech.testusingselenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeInitializer {

	WebDriver driver;
	public ChromeInitializer() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jaspreetsingh_Tuli\\Desktop\\RD Training\\Training Sessions\\TestAutomation_RD\\TestWebpageUsingSelenium\\testusingselenium\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	public WebDriver getDriver() {
		driver.manage().deleteAllCookies();
		return this.driver;
	}
}
