package com.bankingprojhybridfw;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
		Assert.assertEquals(url,"https://demo.guru99.com/1");
	}

	
	@Test
	public void testGetCredentials() throws EncryptedDocumentException, IOException, InterruptedException {
		loginPagePom=new LoginPagePom();
		homePagePom = loginPagePom.clickHere();
		utility=new Utility();
		String email=(String)utility.getSingleCellDataFromExcel(0,0,"Email");
		//homePagePom.getEmail();
		homePagePom.setEmail(email);
		Assert.assertTrue(!email.isBlank());
		utility.getScreenshot("testGetCredentials");
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
