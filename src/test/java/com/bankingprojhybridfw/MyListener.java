package com.bankingprojhybridfw;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.bankingprojhybridfw.base.BaseClass;
import com.bankingprojhybridfw.utility.Utility;

public class MyListener extends BaseClass implements ITestListener  {
	
	Utility utility;
	
	@Override
	public void onTestStart(ITestResult result) {
		    System.out.println(result.getName()+"  TestExecution Started..");
	}
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		utility=new Utility();
		try {
			utility.getScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(result.getName()+"  Successfully Executed..");
	}
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		utility=new Utility();
		try {
			utility.getScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(result.getName()+" Execution Failed..");
	    
	}
	

}
