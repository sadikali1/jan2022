package com.test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example1 {
	
	protected WebDriver driver;
	
	@Test
	public void testExample() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		
		WebDriverManager.chromedriver().setup();		
		driver = new ChromeDriver();
		
		WebDriverManager.firefoxdriver().setup();
		//driver = new FirefoxDriver();
		
		//WebDriverManager.edgedriver().setup();
		//EdgeDriver driver = new EdgeDriver();
		
		//driver = new SafariDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		WebElement createButtonElement = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		createButtonElement.click();
		
		WebElement firstNameObj = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstNameObj.sendKeys("Testing");
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("QA");
		
		WebElement selectDay = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select select = new Select(selectDay);
		//select.selectByIndex(10);
		
		//select.selectByValue("10");
		select.selectByVisibleText("20");
		
		WebElement selectMonthElement = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select selectMonth = new Select(selectMonthElement);
		selectMonth.selectByVisibleText("Mar");
		
		driver.quit();
	}
	
	// SCM (Source Code management tool)
	
	

}
