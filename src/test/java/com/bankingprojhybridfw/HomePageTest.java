package com.bankingprojhybridfw;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bankingprojhybridfw.base.BaseClass;
import com.bankingprojhybridfw.pom.CredentialPagePom;
import com.bankingprojhybridfw.pom.HomePagePom;
import com.bankingprojhybridfw.pom.LoginPagePom;

public class HomePageTest extends BaseClass {
  
	HomePagePom homePagePom;
	
	
	@BeforeClass
	public void setUp() {
		launchWebsite();
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void getUrl() {
		String url=driver.getCurrentUrl();
		
		if(url.equalsIgnoreCase("https://demo.guru99.com/")) {
			System.out.println("On Home Page");
		}
	}
	
	
	
	@Test
	public void testGetCredentials() throws EncryptedDocumentException, IOException {
		LoginPagePom LoginPagePom =new LoginPagePom();
		homePagePom = LoginPagePom.clickHere();
		homePagePom.getEmail();
		//homePagePom.setEmail(email);
		CredentialPagePom credentialpagePom=homePagePom.clickOnSumbitBtn();
		credentialpagePom.saveNewCredentials();
		
	}
	
	
	/*@Test
	public void testClickonSubmit() {
		homePagePom=new HomePagePom();
		homePagePom.clickOnSumbitBtn();
	}
	*/
	
	
}
