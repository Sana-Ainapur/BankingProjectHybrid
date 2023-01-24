package com.bankingprojhybridfw;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bankingprojhybridfw.base.BaseClass;
import com.bankingprojhybridfw.pom.LoginPagePom;

public class LoginPageTest extends BaseClass{
	
	LoginPagePom LoginPagePom;
	
	@BeforeClass
	public void setUp() {
		
		launchWebsite();
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		
	}
	
	
	@Test
	public void testTitle() {
		String pageTitle=(driver.getTitle().trim()); // to trim the spaces of both the ends
		
		if(pageTitle.equalsIgnoreCase("GTPL Bank Home Page")) {
			
			System.out.println("We are on Correct page");
		}
		else {
			
			System.out.println("We are on Wrong Page");
			
		}
	}
	
	
	
	@Test
	public void testUrl() {
		
		String pageUrl=driver.getCurrentUrl();// super keyword can be used
		
		if(pageUrl.contentEquals("https://demo.guru99.com/V1/index.php")) {
			
			System.out.println("Correct URL is hitted");
		}
		else
		{
			System.out.println("Wrong URL is hitted");
		}	
		
	}
	
	@Test
		public void testLoginButton() throws EncryptedDocumentException, IOException {
			LoginPagePom = new LoginPagePom();
			String userid=LoginPagePom.getUserId();
			String Password=LoginPagePom.getPwd();
			LoginPagePom.setUserIdPassword(userid, Password);
			LoginPagePom.clickLoginBtn();
			LoginPagePom.alertHandle();
	}
		
	@Test
	
	public void testResetButton() {
		LoginPagePom =new LoginPagePom();
		LoginPagePom.clickResetBtn();
		
		
	}
	
	
	

}
