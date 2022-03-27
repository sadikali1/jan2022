package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {
	
	@Test
	public void selenium() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.jcpenney.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		WebElement inputElement = driver.findElement(By.xpath("//input[@id='searchInputId']"));
		inputElement.sendKeys("Fieldcrest Watercolor Floral 3-pc. Floral Comforter Set");
		
		driver.findElement(By.xpath("//button[@data-automation-id='searchIconBlock']")).click();
	}

}
