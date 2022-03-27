package com.test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadDownlod {

	@Test
	public void testUpload() {
		WebDriverManager.chromedriver().setup();
		
        Map<String, Object> prefs = new HashMap<String, Object>();             
        prefs.put("download.default_directory", "C:\\Users\\admin\\eclipse-workspace1\\seleniumjan2022");
        
        Map<String, Object> prefs1 = new HashMap<String, Object>();             
        prefs1.put("deviceName", "Nexus 5");
        
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("mobileEmulation", prefs1);
        //options.addArguments("--headless");
        
		WebDriver driver = new ChromeDriver(options);	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoqa.com/upload-download");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("downloadButton")).click();
		
		driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\admin\\Downloads\\Priya Vijaykumar Resume.docx");
	}
}
