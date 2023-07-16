package com.orangehrm.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class FailedTestScriptScreenshotLogic  implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
	   System.out.println("Test Script Failed");
	   Browser.getScreenshot(result.getName());
	  }
}
