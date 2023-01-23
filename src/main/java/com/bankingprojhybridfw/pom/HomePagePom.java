package com.bankingprojhybridfw.pom;

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
	
	public void setEmail() {
		email.sendKeys("abcxyz@gmail.com");
	}
	
	public void clickOnSumbitBtn() {
		btnSubmit.click();
	}
	
	
	

}
