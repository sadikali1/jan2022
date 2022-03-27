package com.test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumAlert {

	@Test
	public void selenium() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		driver.findElement(By.id("confirmButton")).click();
		Alert alert1 = driver.switchTo().alert();
		String text = alert1.getText();
		System.out.println(text);
		alert1.dismiss();
		
		String message = driver.findElement(By.id("confirmResult")).getText();
		System.out.println(message);
		
		driver.findElement(By.id("promtButton")).click();
		Alert alert2 = driver.switchTo().alert();
		alert2.sendKeys("Testing");
		alert2.accept();
		
		String result = driver.findElement(By.id("promptResult")).getText();
		System.out.println(result);
				
		driver.findElement(By.id("timerAlertButton")).click();	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert3 = driver.switchTo().alert();
		alert3.accept();
		
		driver.quit();		
	}

}
