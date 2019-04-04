package com.ievolve;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestingParallel {

	WebDriver driver = null;
	
	
	@Test
	public void test1(String browser) {
		System.out.println("this is test1");
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/JAVA/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://naukri.com");	
		}
		if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/JAVA/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://facebook.com");	
		}
		
	
		
	}
	
	
	@Test
	@Parameters("browser")
	public void test2(String browser) {
		System.out.println("this is test2");
		
		if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/JAVA/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://facebook.com");	
		}
	}
	
}
