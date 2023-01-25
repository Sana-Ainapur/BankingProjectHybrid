package com.bankingprojhybridfw.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bankingprojhybridfw.base.BaseClass;

public class BankManagerHomePagePom extends BaseClass {
	
	public BankManagerHomePagePom() {
		
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Manager")
	WebElement manager;
	
	
	@FindBy(linkText = "New Customer")
	WebElement newCustomer;
	
	@FindBy(linkText = "Edit Customer")
	WebElement editCustomer;
	
	@FindBy(linkText = "Delete Customer")
	WebElement deleteCustomer;
	
	@FindBy(linkText = "New Account")
	WebElement newAccount;
	
	@FindBy(linkText = "Edit Account")
	WebElement editAccount;
	
	@FindBy(linkText = "Delete Account")
	WebElement deleteAccount;
	
	@FindBy(linkText = "Mini Statement")
	WebElement miniStatement;
	
	@FindBy(linkText = "Customised Statement")
	WebElement customisedStatement;
	
	@FindBy(linkText = "Log out")
	WebElement logout;
		
	
	
	public ManagerHomePagePom clickOnManager() {
		manager.click();
		return new ManagerHomePagePom();
	}
	
	public NewCustomerPagePom clickOnNewCustomer() {
		newCustomer.click();
		return new NewCustomerPagePom();
			
	}
	
	public EditCustomerPagePom clickOnEditCustomer() {
		
		editAccount.click();
		return new EditCustomerPagePom();
		
	}
	
	public DeleteCustomerPagePom clickOnDeleteCustomer() {
		deleteCustomer.click();
		return new DeleteCustomerPagePom();
	}
	
	public NewAccountPagePom clickOnNewAccount() {
		newAccount.click();
		return new NewAccountPagePom();
		
	}
	
	public DeleteAccountPagePom clickOnDeleteAccount() {
		deleteAccount.click();
		return new DeleteAccountPagePom();
		
	}
	
	public MiniStatementPagePom clickOnMiniStatement() {
		miniStatement.click();
		return new MiniStatementPagePom(); 
			
	}
	
	public StatementPagePom clickOnCustomizedStatement() {
		
		customisedStatement.click();
		return new StatementPagePom();
	}
	
	public LogoutPagePom clickOnLogOut() {
		logout.click();
		return new LogoutPagePom();
			
	}
	
	
}
