package com.bankingprojhybridfw.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bankingprojhybridfw.base.BaseClass;

public class CredentialPagePom extends  BaseClass {
	
	public CredentialPagePom() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@border='1']//tr[4]/td[2]")
	WebElement usrnm;
	
	@FindBy(xpath="//table[@border='1']//tr[5]/td[2]")
	WebElement passwrd;
	
	
	public void saveNewCredentials() {
		String username=usrnm.getText();
		System.out.println(username);
		String password=passwrd.getText();
		System.out.println(password);
		
	}
	
	

}
