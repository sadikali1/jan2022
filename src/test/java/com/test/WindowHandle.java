package com.test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
	
	@Test
	public void testWindowHandle() {
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("tabButton")).click();
		driver.findElement(By.id("windowButton")).click();
		driver.findElement(By.id("messageWindowButton")).click();
		
		String windowId = driver.getWindowHandle();
		Set<String> windIds =  driver.getWindowHandles();
		System.out.println(windIds.size());
		
		//windIds -- parent window
		//windIds -- child window
		
		for(String winId : windIds) {
			System.out.println(winId);
			driver.switchTo().window(winId);
			//System.out.println(driver.getTitle());
			//System.out.println(driver.getCurrentUrl());
			
			List<WebElement> list = driver.findElements(By.id("sampleHeading"));
			if(list.size() >= 1) {
				break;
			}
		}
		
		System.out.println(driver.findElement(By.tagName("body")).getText());
		
		/*
		//String childWindowId = driver.getWindowHandle();
		String text = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(text);
		driver.close();
		
		driver.switchTo().window(windowId);
		driver.findElement(By.id("windowButton")).click();
		driver.quit(); */
	}

}
