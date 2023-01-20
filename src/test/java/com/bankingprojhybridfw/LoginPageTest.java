package com.bankingprojhybridfw;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bankingprojhybridfw.base.BaseClass;

public class LoginPageTest extends BaseClass{
	
	@BeforeClass
	public void setUp() {
		
		launchWebsite();
		
	}
	
	@Test
	public void testTitle() {
		String pageTitle=(driver.getTitle().trim());
		
		if(pageTitle.equalsIgnoreCase("GTPL Bank Home Page")) {
			
			System.out.println("We are on Correct page");
		}
		else {
			
			System.out.println("We are on Wrong Page");
			
		}
	}
	
	
	
	@Test
	public void testUrl() {
		
		String pageUrl=driver.getCurrentUrl();
		
		if(pageUrl.contentEquals("https://demo.guru99.com/V1/index.php")) {
			
			System.out.println("Correct URL is hitted");
		}
		else
		{
			System.out.println("Wrong URL is hitted");
		}	
		
		
		
	}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
		
	}

}
