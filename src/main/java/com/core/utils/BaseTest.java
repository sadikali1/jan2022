package com.core.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void setup() throws IOException {
		
		String browser = Configuration.config("browserType");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			new Exception("Please provide valid browser name");
		}
		driver.get(Configuration.config("Url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {		
		System.out.println(result.isSuccess());
		if(! result.isSuccess()) {
			takeScreenshot();
		}
		driver.quit();
	}
	
	public void takeScreenshot() throws IOException {
		TakesScreenshot takeScreen = (TakesScreenshot) driver;		
		File screenshot = takeScreen.getScreenshotAs(OutputType.FILE);		
		
		File screen = new File("image.png");
		FileUtils.copyFile(screenshot, screen);
	}
	
	

}
