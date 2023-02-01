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
import org.testng.asserts.SoftAssert;

import com.bankingprojhybridfw.base.BaseClass;
import com.bankingprojhybridfw.pom.BankManagerHomePagePom;
import com.bankingprojhybridfw.pom.LoginPagePom;
import com.bankingprojhybridfw.pom.NewCustomerPagePom;
import com.bankingprojhybridfw.utility.Utility;

public class LoginPageTest extends BaseClass{
	
	LoginPagePom LoginPagePom;
	Utility utility;
	BankManagerHomePagePom bankmanagerpagepom;
	SoftAssert softAssert;
	NewCustomerPagePom newcustomerpagepom;
	@BeforeClass
	public void setUp() {
		
		launchWebsite();
		
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
		
	}
	
	
	@Test (priority = -1)
	public void testTitle() throws IOException {
		String pageTitle=(driver.getTitle().trim()); 
		utility=new Utility();    // to trim the spaces of both the ends
		utility.getScreenshot("testTitle");
		Assert.assertEquals(pageTitle, "GTPL Bank Home Page");
		
	}
	
	
	
	@Test(priority = 0)
	public void testUrl() {
		
		String pageUrl=driver.getCurrentUrl();
		Assert.assertEquals(pageUrl,"https://demo.guru99.com/V1/index.php");
		
		
	}
	
	@Test(priority = 2)
	public void testLoginButton() throws EncryptedDocumentException, IOException {
			softAssert=new SoftAssert();	
			LoginPagePom = new LoginPagePom();
			utility=new Utility();
			String userid=(String)utility.getSingleCellDataFromExcel(0,0,"Login");
			softAssert.assertTrue(!userid.isEmpty());
			Utility utility1=new Utility();
			String password=(String)utility1.getSingleCellDataFromExcel(0,1,"Login");
			softAssert.assertTrue(!password.isEmpty());
			LoginPagePom.setUserIdPassword(userid, password);
			//softAssert.assertTrue(LoginPagePom.blankCredentials());
			utility.getScreenshot("testLoginButton");
			bankmanagerpagepom=new BankManagerHomePagePom();
			bankmanagerpagepom=LoginPagePom.clickLoginBtn();
			softAssert.assertAll();
			newcustomerpagepom = new NewCustomerPagePom();
			newcustomerpagepom = bankmanagerpagepom.clickOnNewCustomer();
			
			
	}
	
	@Test (dependsOnMethods ="testResetButton")
	public void testBlankCrediantials() throws EncryptedDocumentException, IOException {
		LoginPagePom = new LoginPagePom();
		LoginPagePom.sendBlankCredentials();
		Assert.assertTrue(LoginPagePom.blankCredentials());
		

		
	}
	
	@Test(invocationCount =3, priority = 1)
	
	public void testResetButton() {
		LoginPagePom =new LoginPagePom();
	
		Assert.assertTrue((LoginPagePom.clickResetBtn()),"Reset");
		
	}
	
}
