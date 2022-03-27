package com.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableExample {

	@Test
	public void selenium() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/webtables");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
				
		String text = driver.findElement(By.xpath("//div[@class='rt-tr-group']/div/div[4]")).getText();
		System.out.println(text);
			
				
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='rt-tr-group']/div/div[4]"));
		System.out.println(elements.size());
		for(WebElement element : elements) {
			System.out.println(element.getText());
		}
	}
}
