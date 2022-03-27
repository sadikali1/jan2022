package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {

	private WebDriver driver;
	
	By productTitle = By.cssSelector("a[data-automation-id='at-product-title-link']");
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyProductCheckOut(String product) {
		String productTitle1 =  driver.findElement(productTitle).getText();
		Assert.assertEquals(productTitle1, product);
		driver.findElement(By.cssSelector("[id=\"checkoutButton\"]")).click();
	}
	
}
