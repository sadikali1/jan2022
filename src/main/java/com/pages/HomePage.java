package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchProduct(String product) {
		driver.findElement(By.id("searchInputId")).sendKeys(product);
		driver.findElement(By.cssSelector("button[data-automation-id='searchIconBlock']")).click();
	}

}


