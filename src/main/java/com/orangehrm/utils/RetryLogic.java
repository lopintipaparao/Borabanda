package com.orangehrm.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer{

	int mincount=0, maxcount=2;
	@Override
	public boolean retry(ITestResult result) {
		
		if(mincount<maxcount)
		{
			mincount++;
			return true;
		}
		return false;
	}

}
