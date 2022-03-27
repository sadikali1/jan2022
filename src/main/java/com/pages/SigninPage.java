package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SigninPage {
	
	private WebDriver driver;
	
	public SigninPage(WebDriver driver) {
		this.driver = driver;
	}

	
	public void login(String userName, String password) {
		driver.findElement(By.id("email")).sendKeys(userName);
		driver.findElement(By.id("cartSignInPassword")).sendKeys(password);
		driver.findElement(By.cssSelector("[data-automation-id=\"at-sign-in-button\"]"));
	}
	
	public void clicknGuest() {
		driver.findElement(By.xpath("(//button[@data-automation-id=\"at-continue-as-guest\"])[2]")).click();
	}
	
	public void clickCreatAccountButton() {
		driver.findElement(By.cssSelector("[data-automation-id=\"at-create-account-button\"]"));
	}
	
	public void creactAccount() {
		
	}
}
