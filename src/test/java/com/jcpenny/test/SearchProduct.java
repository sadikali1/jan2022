package com.jcpenny.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.core.utils.BaseTest;
import com.pages.HomePage;
import com.pages.ProductdetailsPage;

public class SearchProduct extends BaseTest {

	String product = "Fieldcrest Watercolor Floral 3-pc. Floral Comforter Set";
	
	@Test
	public void searchTest() throws IOException {
		HomePage homePage = new HomePage(driver);
		homePage.searchProduct(product);
		
		ProductdetailsPage productdetailsPage = new ProductdetailsPage(driver);
		productdetailsPage.verifyProduct(product);
		
	}
	
	
	
}


