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
	
	@FindBy(xpath ="//div[@id='dismiss-button']")
	WebElement close;
	
	@FindBy(xpath="//iframe[@title='3rd party ad content']")
	WebElement frame1;
	
	@FindBy(xpath="//iframe[@id='ad_iframe']")
	WebElement frame2;
	
	@FindBy(xpath="//label[@id='message23']")
	WebElement UserIdError;
	
	@FindBy(xpath="//label[@id='message18']")
	WebElement PasswordError;
	
	
	/*public String getUserId() throws EncryptedDocumentException, IOException {
		
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
		
		
	}*/
	
	
	
	
	public void setUserIdPassword(String userid, String Password) {
		userId.sendKeys(userid);
		
		password.sendKeys(Password);
		
	}
	
	
	public BankManagerHomePagePom clickLoginBtn() {
		btnLogin.click();
		
		return new BankManagerHomePagePom();
		
	}
//Handling iframe	
	public void iframeHandle() {
		
		driver.switchTo().frame(frame1);
		if(frame2.isDisplayed()) {
			driver.switchTo().frame(frame2);
			close.click();
			driver.switchTo().defaultContent();
	
		}
		
			close.click();
			driver.switchTo().defaultContent();	
	}
	
//Handling the alert
	public void alertHandle() {
		
		Alert alert=driver.switchTo().alert();
		
		System.out.println(alert.getText());
		
		alert.accept();
	}
	
	
	public void clickResetBtn() {
		btnReset.click();
		if((!(userId.getText().length()>0)) && (!(password.getText().length()>0))) {
			System.out.println("Reset is Done");
		}
	}
	
	
	public HomePagePom clickHere() {
		getCredential.click();
		if(frame1.isDisplayed()) {
			iframeHandle();
		}
		return new HomePagePom();
		
		
	}
	
	
	
}
