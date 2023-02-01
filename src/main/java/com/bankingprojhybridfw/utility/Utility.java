package com.bankingprojhybridfw.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.bankingprojhybridfw.base.BaseClass;

public class Utility extends BaseClass{

	FileInputStream fis;
	
	public Utility()  {
		
		try {
		 this.fis=new  FileInputStream(projectpath+"\\src\\test\\resources\\ExcelSheet\\LoginCredentials.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Object getSingleCellDataFromExcel(int row, int cell, String sheetName) throws EncryptedDocumentException, IOException {
		
		Sheet sh=WorkbookFactory.create(fis).getSheet(sheetName);
		Object data="";
		if (sh.getRow(row).getCell(cell).getCellType().toString().equalsIgnoreCase("string")) {
			data=sh.getRow(row).getCell(cell).getStringCellValue();
			
		}
		else if(sh.getRow(row).getCell(cell).getCellType().toString().equalsIgnoreCase("numeric")) {
			data=sh.getRow(row).getCell(cell).getNumericCellValue();
		
		}
		return data;
	
	
	}
	
	
	public void getAllDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException {
		
		
		
		Sheet sh=WorkbookFactory.create(fis).getSheet(sheetName);
		
		int rowCount = sh.getLastRowNum();
				
	
		Object data[][] = new Object[rowCount][1];

			Map<String,Object> map=new HashMap<>();
		
		for(int i=0;i<sh.getLastRowNum();i++) {
			int cellCount=sh.getRow(i).getLastCellNum();
				for(int j=0;j<cellCount;j++) {
					if (sh.getRow(i).getCell(j).getCellType().toString().equalsIgnoreCase("string")) {
						
						map.put(sh.getRow(0).getCell(j).getStringCellValue(),
								sh.getRow(i+1).getCell(j).getStringCellValue());
						
					}
					else if(sh.getRow(i).getCell(j).getCellType().toString().equalsIgnoreCase("numeric")) {
						
						map.put(sh.getRow(0).getCell(j).getStringCellValue(),
								sh.getRow(i+1).getCell(j).getNumericCellValue());
					
					}
				}
		
		
			data[i][0]=map;
		
		}
		
	
	}	
	
	public void getScreenshot(String ScreenShotName) throws IOException {
		
		File Screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
		String desPath=projectpath+"\\Screenshot\\"+ScreenShotName+".jpeg";
	
		FileUtils.copyFile(Screenshot,new File(desPath));
		
		
	}
	
}
