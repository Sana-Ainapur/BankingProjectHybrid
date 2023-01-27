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
import com.bankingprojhybridfw.utility.Utility;

public class HomePageTest extends BaseClass {
  
	LoginPagePom loginPagePom;
	HomePagePom homePagePom;
	CredentialPagePom credentialpagePom;
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
	public void getUrl() {
		String url=driver.getCurrentUrl();
		
		if(url.equalsIgnoreCase("https://demo.guru99.com/")) {
			System.out.println("On Home Page");
		}
	}

	
	@Test
	public void testGetCredentials() throws EncryptedDocumentException, IOException {
		loginPagePom=new LoginPagePom();
		homePagePom = loginPagePom.clickHere();
		utility=new Utility();
		String email=(String)utility.getSingleCellDataFromExcel(0,0,"Email");
		//homePagePom.getEmail();
		homePagePom.setEmail(email);
		credentialpagePom=homePagePom.clickOnSumbitBtn();
		credentialpagePom.saveNewCredentials();
		
	}
	
	/*@Test
	public void testClickonSubmit() {
		homePagePom=new HomePagePom();
		homePagePom.clickOnSumbitBtn();
	}
	*/
	
	
}
