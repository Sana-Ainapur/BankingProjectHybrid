package com.bankingprojhybridfw.pom;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(xpath=" //input[@name='dob']") //Select and the n SendKeys 
	WebElement dateOfBirth;
	
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
	
	public void selectGender(String gender) {
		
		if(gender=="male") {
			genderMaleRadioButton.click();
		}
		else if(gender=="female") {
			genderFemaleRadioButton.click();
		}
	}
	
	
	public void newCustomerName(String name,String gender,String dob,String address,String city,String State,String pin, String telno, String mail) {
		customerName.sendKeys(name);
		selectGender(gender);
		
		
		
		dateOfBirth.clear();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeSelected(dateOfBirth));
		dateOfBirth.sendKeys(dob);
		Address.sendKeys(address);
		cityName.sendKeys(city);
		state.sendKeys(State);
		pincodeNo.sendKeys(pin);
		phoneNumber.sendKeys(telno);
		mailId.sendKeys(mail);	
		
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
