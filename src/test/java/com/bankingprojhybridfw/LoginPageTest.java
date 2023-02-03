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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.bankingprojhybridfw.base.BaseClass;
import com.bankingprojhybridfw.pom.BankManagerHomePagePom;
import com.bankingprojhybridfw.pom.LoginPagePom;
import com.bankingprojhybridfw.pom.NewCustomerPagePom;
import com.bankingprojhybridfw.utility.Utility;
@Listeners(MyListener.class)

public class LoginPageTest extends BaseClass{
	
	LoginPagePom LoginPagePom;
	Utility utility;
	BankManagerHomePagePom bankmanagerpagepom;
	SoftAssert softAssert;
	NewCustomerPagePom newcustomerpagepom;
	
	
	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;
	
	@BeforeClass
	public void setUp() {
		
		launchWebsite();
		utility=new Utility();
		//utility.createExtentReports();
		extentSparkReporter=new ExtentSparkReporter(projectpath+"//extentReport//extent.html");
		extentReports=new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
	}
	
	
	@AfterClass
	public void tearDown() {
		
		extentReports.flush();
		driver.close();
		
	}
	
	
	@Test (priority = -1)
	public void testTitle() throws IOException {
		extentTest =extentReports.createTest("testTitle");
		String pageTitle=(driver.getTitle().trim()); 
		extentTest.log(Status.FAIL,pageTitle);
		Assert.assertEquals(pageTitle, "GTPL Bank Home Page!");
		
	}
	
	
	
	@Test(priority = 0)
	public void testUrl() {
		
		extentTest =extentReports.createTest("testUrl");
		String pageUrl=driver.getCurrentUrl();
		extentTest.log(Status.PASS, pageUrl);
		Assert.assertEquals(pageUrl,"https://demo.guru99.com/V1/index.php");
		
		
	}
	
	@Test(priority = 2)
	public void testLoginButton() throws EncryptedDocumentException, IOException {
			extentTest =extentReports.createTest("testLoginButton");
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
			//utility.getScreenshot("testLoginButton");
			bankmanagerpagepom=new BankManagerHomePagePom();
			bankmanagerpagepom=LoginPagePom.clickLoginBtn();
			softAssert.assertAll();
			
			newcustomerpagepom = new NewCustomerPagePom();
			newcustomerpagepom = bankmanagerpagepom.clickOnNewCustomer();
			extentTest.log(Status.PASS,"LoginTest");
			
			
	}
	
	@Test (dependsOnMethods ="testResetButton")
	public void testBlankCrediantials() throws EncryptedDocumentException, IOException {
		extentTest =extentReports.createTest("testBlankCrediantials");
		LoginPagePom = new LoginPagePom();
		LoginPagePom.sendBlankCredentials();
		extentTest.log(Status.PASS,"Blank Credentials Tested");
		Assert.assertTrue(LoginPagePom.blankCredentials());
		

		
	}
	
	@Test(invocationCount =2, priority = 1)
	
	public void testResetButton() {
		extentTest =extentReports.createTest("testResetButton");
		LoginPagePom =new LoginPagePom();
		extentTest.log(Status.PASS,"Reset Button Tested");
		Assert.assertTrue((LoginPagePom.clickResetBtn()),"Reset");
		
	}
	
}
