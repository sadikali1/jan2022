package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsExample {

	@Test
	public void example1() {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoqa.com/droppable");
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		WebElement source  = driver.findElement(By.id("draggable"));
		WebElement target  = driver.findElement(By.id("droppable"));
		action.dragAndDrop(source, target).perform();
		driver.quit();

	}
	
	
	@Test
	public void example2() {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoqa.com/dragabble");
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		WebElement source  = driver.findElement(By.id("dragBox"));
		action.moveToElement(source).dragAndDropBy(source, 200, 200).pause(12000).build().perform();
		driver.quit();
	}

	@Test
	public void mouseMove() {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoqa.com/menu#");
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		WebElement source  = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
		WebElement subMenu  = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
		WebElement subMenu2  = driver.findElement(By.xpath("//a[text()='Sub Sub Item 2']"));
		action.moveToElement(source).moveToElement(subMenu).click(subMenu2).build().perform();
		driver.quit();
	}
	
	
	@Test
	public void example3() {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoqa.com/buttons");
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		WebElement elementButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
		action.click(elementButton).build().perform();
		
		String text = driver.findElement(By.id("dynamicClickMessage")).getText();
		Assert.assertEquals(text, "You have done a dynamic click");
		
		WebElement button1 = driver.findElement(By.id("rightClickBtn"));
		action.contextClick(button1).build().perform();
		
		text = driver.findElement(By.id("rightClickMessage")).getText();
		Assert.assertEquals(text, "You have done a right click");
		
		WebElement button2 = driver.findElement(By.id("doubleClickBtn"));
		action.doubleClick(button2).build().perform();
		driver.quit();
	}
}
