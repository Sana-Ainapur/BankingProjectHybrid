package com.bankingprojhybridfw.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bankingprojhybridfw.base.BaseClass;

public class LoginPagePom extends BaseClass {
	
	public LoginPagePom() {
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
	
	
	
	public void clickLoginBtn() {
		btnLogin.click();
	}
	
	
	
	public void clickResetBtn() {
		btnReset.click();
	}
	
	
	public void clickHere() {
		getCredential.click();
		
		
	}
	
	
	
}
