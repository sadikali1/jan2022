package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage {

private WebDriver driver;
	
	public ShippingPage(WebDriver driver) {
		this.driver = driver;
	}

	
	public void fillGuestDetails() {

		driver.findElement(By.id("firstName")).sendKeys("QA");
		driver.findElement(By.id("lastName")).sendKeys("QA");
		driver.findElement(By.id("company")).sendKeys("Company");
		driver.findElement(By.id("lineOne")).sendKeys("Sector 2");
	}
}
