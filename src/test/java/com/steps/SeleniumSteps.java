package com.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumSteps {

	 WebDriver driver;

	@Given("I navigated url on browser")
	public void i_navigated_url_on_browser() {
	   WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   driver.navigate().to("https://www.facebook.com/");
	   driver.manage().window().maximize();
	   
	}

	
	@When("I enter user name into user input field")
	public void i_enter_user_name_into_user_input_field() {
		driver.findElement(By.id("email")).sendKeys("Test@gmail.com");
	}



	@When("I enter password in password filed")
	public void i_enter_password_in_password_filed() {
		driver.findElement(By.id("pass")).sendKeys("123456");
	}


	@When("I click on login button")
	public void i_click_on_login_button() {
		driver.findElement(By.name("login")).click();
	}


	@Then("I verify user login successfully")
	public void i_verify_user_login_successfully() {
	  
	}

	@Then("I verified user not login successfully")
	public void i_verified_user_not_login_successfully() {
	  
	}


}
