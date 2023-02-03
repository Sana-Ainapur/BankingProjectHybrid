package com.bankingprojhybridfw;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bankingprojhybridfw.base.BaseClass;
import com.bankingprojhybridfw.pom.BankManagerHomePagePom;
import com.bankingprojhybridfw.pom.LoginPagePom;
import com.bankingprojhybridfw.pom.NewCustomerPagePom;
import com.bankingprojhybridfw.utility.Utility;

public class NewCustomerPageTest extends BaseClass{
	
	Utility utility;
	LoginPagePom loginpagepom;
	NewCustomerPagePom newcustomerpagepom;
	BankManagerHomePagePom bankmanagerpagepom;
	SoftAssert softAssert;
	
	
	@BeforeClass
	public void setUp() {
		launchWebsite();
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void clickOnSubmitButton() throws EncryptedDocumentException, IOException, InterruptedException {
		loginpagepom = new LoginPagePom();
		softAssert = new SoftAssert();
		utility=new Utility();
		String userid=(String)utility.getSingleCellDataFromExcel(0,0,"Login");
		softAssert.assertTrue(!userid.isEmpty());
		Utility utility1=new Utility();
		String password=(String)utility1.getSingleCellDataFromExcel(0,1,"Login");
		softAssert.assertTrue(!password.isEmpty());
		loginpagepom.setUserIdPassword(userid, password);
		bankmanagerpagepom=new BankManagerHomePagePom();
		bankmanagerpagepom=loginpagepom.clickLoginBtn();
		newcustomerpagepom=new NewCustomerPagePom();
		newcustomerpagepom=bankmanagerpagepom.clickOnNewCustomer();
		utility=new Utility();
		String custname=(String)utility.getSingleCellDataFromExcel(1,0,"New Customer");
		newcustomerpagepom.newCustomerName(custname,"20-10-1991","female","Hno-104,Street no.2","Mumbai","Maharashtra","400001","23452472348","rkumar12@sdhaj.com");
		newcustomerpagepom.clickOnSubmit();
		Thread.sleep(20000);
	}
}
