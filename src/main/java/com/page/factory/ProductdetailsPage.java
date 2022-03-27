package com.page.factory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductdetailsPage {

	private WebDriver driver;

	@FindBy(css = "h1[id=\"productTitle-false\"]")
	private WebElement productTitle;
	
	@FindBy(css = "p[data-automation-id='addToCart']" )
	private WebElement AddCartButton;
	
	@FindBy(css = "div[data-automation-id='ocProductTitle']")
	private WebElement productTitle1;
	
	@FindBy(css="button[data-automation-id='at-panel-checkout-button']")
	private WebElement checkOutButton;
	
	
	public ProductdetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	
	public void verifyProduct(String product) {
		String productText = productTitle.getText();
		Assert.assertEquals(productText, product);
	}
	
	public void clickOnAddCart() {
		AddCartButton.click();
	}
	
	public void verifyProductAndClickOnCheckOut(String product) {
		productTitle1.getText();
		Assert.assertEquals(productTitle, product);
		checkOutButton.click();
	}
}
