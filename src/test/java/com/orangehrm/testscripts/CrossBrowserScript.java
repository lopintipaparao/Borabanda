package com.orangehrm.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.Browser;
import com.orangehrm.utils.ReadData;
import com.orangehrm.utils.RetryLogic;


public class CrossBrowserScript {

	WebDriver driver;
	LoginPage lp;
	ReadData rd;

	@Parameters("browsername")
	@BeforeMethod

	public void setup(String browsername) throws Throwable {
		driver = Browser.openBrowser(browsername);
		Browser.openURL("http://demo.guru99.com/V4/");
	}

	@AfterMethod

	public void teardown() {
		driver.quit();
	}
	
//	@Test(retryAnalyzer=RetryLogic.class)
	@Test
	public void testParameterWithXML() throws InterruptedException{
		//Find user name
		WebElement userName = driver.findElement(By.name("uid"));
		//Fill user name
		userName.sendKeys("guru99");
		//Find password
		WebElement password = driver.findElement(By.name("password"));
		//Fill password
		password.sendKeys("guru99");
	}
	
//	@Test(retryAnalyzer=RetryLogic.class)
	@Test
	public void testParameterWithXML_2() throws InterruptedException{
		//Find user name
		WebElement userName = driver.findElement(By.name("uid"));
		//Fill user name
		userName.sendKeys("guru99");
		//Find password
		WebElement password = driver.findElement(By.name("password"));
		//Fill password
		password.sendKeys("guru99");
	}
	
////	@Test(retryAnalyzer=RetryLogic.class)
//	@Test
//	public void testParameterWithXML_3() throws InterruptedException{
//		Browser.implicitlyWait(10);
//		//Find user name
//		WebElement userName = driver.findElement(By.name("uid"));
//		//Fill user name
//		userName.sendKeys("guru99");
//		//Find password
//		WebElement password = driver.findElement(By.name("password"));
//		//Fill password
//		password.sendKeys("guru99");
//	}
//	
	
}
