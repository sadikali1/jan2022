package com.jcpenny.test;

import org.testng.annotations.Test;

import com.core.utils.BaseTest;
import com.pages.CartPage;
import com.pages.HomePage;
import com.pages.ProductdetailsPage;
import com.pages.SigninPage;

public class CheckOutWithNewUser extends BaseTest {
	
	String product = "Fieldcrest Watercolor Floral 3-pc. Floral Comforter Set";
	
	@Test
	public void checkOutwithNewUser() {
		HomePage homePage = new HomePage(driver);
		homePage.searchProduct(product);
		
		ProductdetailsPage productdetailsPage = new ProductdetailsPage(driver);
		productdetailsPage.verifyProduct(product);
		productdetailsPage.clickOnAddCart();
		
		productdetailsPage.verifyProductAndClickOnCheckOut(product);
		
		CartPage cartPage = new CartPage(driver);
		cartPage.verifyProductCheckOut(product);
		
		SigninPage singInPage = new SigninPage(driver);
		singInPage.clickCreatAccountButton();
		singInPage.creactAccount();
	}

}
