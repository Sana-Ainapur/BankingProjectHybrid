package com.bankingprojhybridfw;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bankingprojhybridfw.base.BaseClass;
import com.bankingprojhybridfw.pom.HomePagePom;

public class HomePageTest extends BaseClass {
  
	HomePagePom homePagePom;
	
	@BeforeClass
	public void setUp() {
		launchWebsite();
		driver.get("https://demo.guru99.com/");
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	
	public void getUrl() {
		String url=driver.getCurrentUrl();
		
		if(url.equalsIgnoreCase("https://demo.guru99.com/")) {
			System.out.println("Navigated to Home Page URL");
		}
	}
	
	@Test
	public void testClickonSubmit() {
		homePagePom=new HomePagePom();
		homePagePom.clickOnSumbitBtn();
	}
	
	@Test
	public void testSetEmail() {
		homePagePom=new HomePagePom();
		homePagePom.setEmail();
	}
}
