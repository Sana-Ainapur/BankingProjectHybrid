package com.bankingprojhybridfw.pom;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	
	
	
	public void saveNewCredentials() throws IOException {
		String username=usrnm.getText();
		writeinExcelSheet(0, 0,"New Credentials",username);
		System.out.println(username);
		String password=passwrd.getText();
		writeinExcelSheet(0, 1,"New Credentials",password);
		System.out.println(password);
		
	}
	
	public void writeinExcelSheet(int row, int cell, String SheetName, String value) throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook(); 
		XSSFSheet sh1=wb.createSheet(SheetName);
		sh1.createRow(row).createCell(cell).setCellValue(value);
		FileOutputStream fout=new FileOutputStream(projectpath+"\\src\\test\\resources\\ExcelSheet\\BankingGetCredential.xlsx");
		wb.write(fout);
		
	}
	
	

	
	

}
