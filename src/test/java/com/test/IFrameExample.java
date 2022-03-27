package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrameExample {

	@Test
	public void testIFrame() {
		WebDriverManager.chromedriver().setup();	
       
		WebDriver driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();
		
		String header = driver.findElement(By.xpath("//div[@class='main-header']")).getText();
		Assert.assertEquals(header, "Frames");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));
		//driver.switchTo().frame("frame1");
		String frameText = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
		System.out.println(frameText);
		
		driver.switchTo().parentFrame();
		header = driver.findElement(By.xpath("//div[@class='main-header']")).getText();
		Assert.assertEquals(header, "Frames");
		driver.quit();
	}
	
	@Test
	public void testNestedIFrame() {
		WebDriverManager.chromedriver().setup();	
       
		WebDriver driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoqa.com/nestedframes");
		driver.manage().window().maximize();
		
		String header = driver.findElement(By.xpath("//div[@class='main-header']")).getText();
		Assert.assertEquals(header, "Nested Frames");
		
		driver.switchTo().frame("frame1");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']")));
		String childText = driver.findElement(By.xpath("//body/p")).getText();
		System.out.println(childText);
		
		//driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		header = driver.findElement(By.xpath("//div[@class='main-header']")).getText();
		Assert.assertEquals(header, "Nested Frames");
		driver.quit();
		
	}
}

