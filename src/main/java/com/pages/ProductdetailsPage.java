package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class ProductdetailsPage {

	private WebDriver driver;

	public ProductdetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	
	public void verifyProduct(String product) {
		String productText = driver.findElement(By.cssSelector("h1[id=\"productTitle-false\"]")).getText();
		Assert.assertEquals(productText, product);
	}
	
	public void clickOnAddCart() {
		driver.findElement(By.cssSelector("p[data-automation-id='addToCart']")).click();
	}
	
	public void verifyProductAndClickOnCheckOut(String product) {
		String productTitle = driver.findElement(By.cssSelector("div[data-automation-id='ocProductTitle']")).getText();
		Assert.assertEquals(productTitle, product);
		
		driver.findElement(By.cssSelector("button[data-automation-id='at-panel-checkout-button']")).click();
		
	}
}
