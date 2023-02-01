package com.bankingprojhybridfw;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bankingprojhybridfw.base.BaseClass;
import com.bankingprojhybridfw.pom.BankManagerHomePagePom;
import com.bankingprojhybridfw.pom.NewCustomerPagePom;
import com.bankingprojhybridfw.utility.Utility;

public class NewCustomerPageTest extends BaseClass{
	
	Utility utility;
	NewCustomerPagePom newcustomerpagepom;
	BankManagerHomePagePom bankmanagerpagepom;
	
	
	@BeforeClass
	public void setUp() {
		launchWebsite();
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void clickOnSubmitButton() throws EncryptedDocumentException, IOException {
		
		newcustomerpagepom=new NewCustomerPagePom();
		bankmanagerpagepom =new BankManagerHomePagePom();
		newcustomerpagepom=bankmanagerpagepom.clickOnNewCustomer();
		utility=new Utility();
		String custname=(String)utility.getSingleCellDataFromExcel(1,0,"New Customer");
		newcustomerpagepom.newCustomerName(custname);
	}
}
