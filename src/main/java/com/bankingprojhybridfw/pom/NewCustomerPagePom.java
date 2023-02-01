package com.bankingprojhybridfw.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bankingprojhybridfw.base.BaseClass;

import net.bytebuddy.asm.Advice.This;

public class NewCustomerPagePom extends BaseClass{
	
	public NewCustomerPagePom() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='name']")
	WebElement customerName;
	
	@FindBy(xpath="//label[@id='message']")
	WebElement customerNameError;
	
	@FindBy(xpath="//input[@type='radio'][1]")
	WebElement genderMaleRadioButton;
	
	@FindBy(xpath="//input[@type='radio'][2]")
	WebElement genderFemaleRadioButton;
	
	
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement Address;
	
//	@FindBy(xpath=" //input[@name='dob']") //Select and the n SendKeys 
//	WebElement dateOfBirth;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement cityName;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement state;
	
	@FindBy(xpath="//input[@name='pinno']")//only six digits are allowed
	WebElement pincodeNo;
	
	@FindBy(xpath="//input[@name='telephoneno']") // 15 digits are allowed// no characters allowed
	WebElement phoneNumber;
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement mailId;
	
	@FindBy(xpath="//input[@name='sub']")
	WebElement submitButton;
	
	@FindBy(xpath="//input[@name='res']")
	WebElement resetButton;
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement returnHome;
	
	

	
	public void newCustomerName(String name) {
		customerName.sendKeys(name);
	}
	
	public void clickOnSubmit() {
		submitButton.click();
	}
	
	public void clickOnResetButton() {
		resetButton.click();
	}
	
	public void clickOnHome() {
		returnHome.click();
	}
	
	public void sendInfo() {
		
	}
	
	
	


}
