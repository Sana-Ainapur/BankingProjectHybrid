package com.bankingprojhybridfw.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static String projectpath=System.getProperty("user.dir");

	ChromeOptions chromeoptions=new ChromeOptions();
	
	
	public void launchWebsite (String browser){
		
		switch(browser){
			
			case "chrome":
				
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
				
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				break;
				
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				break;
			
				
				
		}
		
		
		//getProperty is used to get the current directory for setting project path
		//current directory
		//System.setProperty("webdriver.chrome.driver", projectpath+"\\drivers\\chromedriver.exe");
		//driver=new ChromeDriver();
		
		driver.get("https://demo.guru99.com/V1/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
		
	
		}

	
	/*public static void main(String[] args) {
		
		//System.setProperty("webdriver.", null);
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		
	}*/
	
		

}
