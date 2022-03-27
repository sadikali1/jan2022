package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	@Test
	public void checkBox() {
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoqa.com/checkbox");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("[title='Toggle']")).click();
		driver.findElement(By.cssSelector("[for='tree-node-desktop'] > [class='rct-title']")).click();
		driver.quit();
	}
	
	
}

// CSS selector 
// XPath 



