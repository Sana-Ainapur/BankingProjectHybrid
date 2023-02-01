package com.bankingprojhybridfw;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bankingprojhybridfw.base.BaseClass;
import com.bankingprojhybridfw.pom.BankManagerHomePagePom;
import com.bankingprojhybridfw.pom.NewCustomerPagePom;

public class BankManagerHomeTest extends BaseClass {
	
	BankManagerHomePagePom bankmanagerhomepom;
	NewCustomerPagePom newcustomerpagepom;
	
	
	@BeforeClass
	public void setUp() {
		launchWebsite();
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void testClickonNewCustomer() {
		
		bankmanagerhomepom=new BankManagerHomePagePom();
		newcustomerpagepom=new NewCustomerPagePom();
		newcustomerpagepom=bankmanagerhomepom.clickOnNewCustomer();
		
		
	}
}
