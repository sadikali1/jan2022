package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetExamples {

	WebDriver driver;
	
	@Test
	public void testExample() {
		
		WebDriverManager.chromedriver().setup();		
		driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Facebook – log in or sign up");
		
		driver.findElement(By.xpath("//a[text()='Forgotten password?']")).click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		//String soourceCode = driver.getPageSource();
		//System.out.println(soourceCode);
				
		WebElement element = driver.findElement(By.xpath("//h2[@class='uiHeaderTitle']"));
		String text = element.getText();
		Assert.assertEquals(text, "Find Your Account");
		System.out.println(text);
		
		WebElement elementEmail = driver.findElement(By.name("email"));
		String placeHolder = elementEmail.getAttribute("placeholder");
		System.out.println(placeHolder);
		
		WebElement buttonElement = driver.findElement(By.id("did_submit"));
		String font = buttonElement.getCssValue("font-size");
		String lineHeight = buttonElement.getCssValue("line-height");
		String border = buttonElement.getCssValue("border-radius");
		System.out.println(border);
		System.out.println(lineHeight);
		System.out.println(font);
		driver.quit();
	}
}
