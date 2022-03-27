package com.test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExample {

	@Test
	public void testExample() {
		WebDriverManager.chromedriver().setup();	
	       
		WebDriver driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.baeldung.com/rest-assured-tutorial");
		driver.manage().window().maximize();
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(20000, 2000);");
		js.executeScript("window.scroll(20000, 2000);");
		js.executeScript("window.scroll(20000, 2000);");
	}
	
		
	@Test
	public void testExample1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();	
	       
		WebDriver driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	
		Alert a = driver.switchTo().alert();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.cssSelector("[data-testid=\"open-registration-form-button\"]"));
		js.executeScript("arguments[0].click()", element);
				
		String name = (String) js.executeScript("return document.querySelector('[data-testid=\"open-registration-form-button\"]').text");
		System.out.println(name);
		js.executeScript("document.querySelector('[data-testid=\"open-registration-form-button\"]').click()");
		Thread.sleep(2000);
		js.executeScript("document.querySelector('[name=\"firstname\"]').value = \"QA\"");
		
	}
}
