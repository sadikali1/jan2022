package com.jcpenny.test1;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.core.utils.BaseTest;
import com.page.factory.HomePage;
import com.page.factory.ProductdetailsPage;


public class SearchProduct extends BaseTest {

	String product = "Fieldcrest Watercolor Floral 3-pc. Floral Comforter Set";
	
	@Test
	public void searchTest() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.searchProduct(product);
		
		ProductdetailsPage productdetailsPage = PageFactory.initElements(driver, ProductdetailsPage.class);
		productdetailsPage.verifyProduct(product);
	}
	
}


