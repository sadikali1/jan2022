package com.jcpenny.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.core.utils.BaseTest;
import com.pages.CartPage;
import com.pages.HomePage;
import com.pages.ProductdetailsPage;
import com.pages.SigninPage;

public class CheckOutWithExistingUser extends BaseTest{
	
	String product = "Fieldcrest Watercolor Floral 3-pc. Floral Comforter Set";
	
	@Test
	public void checkoutProduct() {
		HomePage homePage = new HomePage(driver);
		homePage.searchProduct(product);
		
		ProductdetailsPage productdetailsPage = new ProductdetailsPage(driver);
		productdetailsPage.verifyProduct(product);
		
		productdetailsPage.clickOnAddCart();
		
		productdetailsPage.verifyProductAndClickOnCheckOut(product);
		
		CartPage cartPage = new CartPage(driver);
		cartPage.verifyProductCheckOut(product);
		
		
		SigninPage signInPage = new SigninPage(driver);
		signInPage.login("QQ", "Test111");
	}	
	
}
