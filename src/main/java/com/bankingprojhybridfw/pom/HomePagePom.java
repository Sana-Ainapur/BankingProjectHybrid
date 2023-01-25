package com.bankingprojhybridfw.pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bankingprojhybridfw.base.BaseClass;

public class HomePagePom extends BaseClass{
	
	
	public HomePagePom() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement email;
	
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement btnSubmit;
	
	
	public void getEmail() throws EncryptedDocumentException, IOException {
		
		FileInputStream fileinputstream=new FileInputStream(projectpath+"\\src\\test\\resources\\ExcelSheet\\BankingGetCredential.xlsx");
		
		Sheet sh=WorkbookFactory.create(fileinputstream).getSheet("Login");
		String email=sh.getRow(0).getCell(0).getStringCellValue();
		//return email;
		setEmail(email);
	}
	
	public void setEmail(String emailid) {
		email.sendKeys(emailid);
	}
	
	
	
	public CredentialPagePom clickOnSumbitBtn() {
		btnSubmit.click();
		return new CredentialPagePom();
	}
	
	
	

}
