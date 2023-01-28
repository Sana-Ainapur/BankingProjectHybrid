package com.bankingprojhybridfw.pom;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTAttrImpl;

import com.bankingprojhybridfw.base.BaseClass;

public class CredentialPagePom extends  BaseClass {
	XSSFWorkbook wb;
	XSSFSheet sh1;
	
	public CredentialPagePom() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@border='1']//tr[4]/td[2]")
	WebElement usrnm;
	
	@FindBy(xpath="//table[@border='1']//tr[5]/td[2]")
	WebElement passwrd;
	
	
	
	public void saveNewCredentials() throws IOException {
		
		String username=(usrnm.getText()).trim();
		System.out.println(username);
		String password=passwrd.getText();
		System.out.println(password);
		
		writeinExcelSheet(0,0,username,1,0,password);
		
	}
	
	public void writeinExcelSheet(int row1, int cell1,String value1,int row2, int cell2,String value2) throws IOException {
		wb = new XSSFWorkbook(); 
		sh1=wb.createSheet("New Credentials");
		
		sh1.createRow(row1).createCell(cell1).setCellValue(value1);
		
		sh1.createRow(row2).createCell(cell2).setCellValue(value2);
		
		FileOutputStream fout=new FileOutputStream(projectpath+"\\src\\test\\resources\\ExcelSheet\\BankingGetCredential.xlsx");
		
		wb.write(fout);
		
	}
	

	
	

}
