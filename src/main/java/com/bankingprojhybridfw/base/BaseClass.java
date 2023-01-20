package com.bankingprojhybridfw.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	public static WebDriver driver;
	
	public void launchWebsite (){
		
		String projectpath=System.getProperty("user.dir");
		//getProperty is used to get the current directory for setting project path
		//current directory
		System.setProperty("webdriver.chrome.driver", projectpath+"\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/V1/index.php");
		
	
		
	}
		
		
		
	

}
