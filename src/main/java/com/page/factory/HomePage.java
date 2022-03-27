package com.page.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	private WebDriver driver;
	
	@FindBy(id ="searchInputId")
	private WebElement searchInput;
	
	@FindBy(css = "button[data-automation-id='searchIconBlock']")
	private WebElement searchButton;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchProduct(String product) {
		searchInput.sendKeys(product);
		searchButton.click();
	}

}


