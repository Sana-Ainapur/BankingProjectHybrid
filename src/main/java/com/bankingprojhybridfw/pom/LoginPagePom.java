package com.bankingprojhybridfw.pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bankingprojhybridfw.base.BaseClass;

public class LoginPagePom extends BaseClass {
	
	public LoginPagePom() { //Constructor
		PageFactory.initElements(driver, this);//This is current Class Page (Login page WebElements)
	}

	@FindBy(xpath = "//input[@name='uid']")
	WebElement userId;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='LOGIN']")
	WebElement btnLogin;
	
	@FindBy(xpath="//input[@value='RESET']")
	WebElement btnReset;
	
	@FindBy(xpath="//a[text()='here']")
	WebElement getCredential;
	
	public void alertHandle() {
		
		Alert alert=driver.switchTo().alert();
		
		System.out.println(alert.getText());
		
		alert.accept();
	}
	
	public String getUserId() throws EncryptedDocumentException, IOException {
		
		FileInputStream fileinputstream=new FileInputStream(projectpath+"\\src\\test\\resources\\ExcelSheet\\BankingGetCredential.xlsx");
		Sheet sh=WorkbookFactory.create(fileinputstream).getSheet("Login Credentials");
		String userid=sh.getRow(0).getCell(0).getStringCellValue();
		return userid;
		
		
	}
	
	
	public String getPwd() throws EncryptedDocumentException, IOException {
		FileInputStream fileinputstream=new FileInputStream(projectpath+"\\src\\test\\resources\\ExcelSheet\\BankingGetCredential.xlsx");
		Sheet sh=WorkbookFactory.create(fileinputstream).getSheetAt(1);
		String pwd=sh.getRow(0).getCell(1).getStringCellValue();
		return pwd;
		
		
	}
	
	public void setUserIdPassword(String userid, String Password) {
		userId.sendKeys(userid);
		password.sendKeys(Password);
		
	}
	
	
	public void clickLoginBtn() {
		btnLogin.click();
		
	}
	
	
	public void clickResetBtn() {
		btnReset.click();
		if((userId.getText()==" ") && (password.getText()==" ")) {
			System.out.println("Reset is Done");
		}
	}
	
	
	public HomePagePom clickHere() {
		getCredential.click();
		return new HomePagePom();
		
		
	}
	
	
	
}
