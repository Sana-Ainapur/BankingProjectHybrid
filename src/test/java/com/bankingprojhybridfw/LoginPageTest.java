package com.bankingprojhybridfw;

import java.io.IOException;

import org.apache.logging.log4j.util.PropertySource.Util;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bankingprojhybridfw.base.BaseClass;
import com.bankingprojhybridfw.pom.LoginPagePom;
import com.bankingprojhybridfw.utility.Utility;

public class LoginPageTest extends BaseClass{
	
	LoginPagePom LoginPagePom;
	Utility utility;
	
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
		Assert.assertEquals(pageTitle, "GTPL Bank Home Page");
		
	}
	
	
	
	@Test
	public void testUrl() {
		
		String pageUrl=driver.getCurrentUrl();// super keyword can be used
		
	/*	if(pageUrl.contentEquals("https://demo.guru99.com/V1/index.php")) {
			
			System.out.println("Correct URL is hitted");
		}
		else
		{
			System.out.println("Wrong URL is hitted");
		}	*/
		
	
		
	}
	
	@Test
	public void testLoginButton() throws EncryptedDocumentException, IOException {
			LoginPagePom = new LoginPagePom();
			utility=new Utility();
			String userid=(String)utility.getSingleCellDataFromExcel(0,0,"Login");
			Utility utility1=new Utility();
			String password=(String)utility1.getSingleCellDataFromExcel(0,1,"Login");
			LoginPagePom.setUserIdPassword(userid, password);
			LoginPagePom.clickLoginBtn();
			
	}
		
	@Test
	
	public void testResetButton() {
		LoginPagePom =new LoginPagePom();
		LoginPagePom.clickResetBtn();	
		
	}
	
}
