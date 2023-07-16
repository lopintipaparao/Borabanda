package com.orangehrm.testscripts;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.Browser;
import com.orangehrm.utils.ReadData;
import com.orangehrm.utils.RetryLogic;

public class LoginPageTest2 {
	WebDriver driver;
	LoginPage lp;
	ReadData rd;

	@Parameters("browsername")
	@BeforeMethod

	public void setup(String browsername) throws Throwable {
		rd = new ReadData("LoginPageData", "Sheet1");
		driver = Browser.openBrowser(browsername);
		String url = rd.getExcelSheetCellDada(1, 1);
		Browser.openURL(url);
	}

	@AfterMethod

	public void teardown() {
		driver.quit();
	}

//	@Test(retryAnalyzer=RetryLogic.class)
	@Test
	public void verifyLoginFunctionality_ValidUsernameAndPassword() throws Throwable {
		lp = new LoginPage(driver);
		boolean status = lp.verifyLogoIsDisplayedOrNot();
		Assert.assertTrue(status, "Test Script Failed Because Logo Is not Displayed");
		 rd = new ReadData("LoginPageData", "Sheet2");
			List<String> rowData= rd.getExcelSheetRowDada(4);
			lp.enterTextInUserNameField(rowData.get(0));
			lp.enterTextInPasswordField(rowData.get(1));
			lp.clickOnLoginButton();
			Assert.assertTrue(status, "Test Script Failed Because of Dashboard Lable is Not Visable");
			
			}
	
//	@Test(retryAnalyzer=RetryLogic.class)
	@Test
	public void verifyLoginFunctionality_ValidUsernameAndPassword_2() throws Throwable {
		lp = new LoginPage(driver);
		boolean status = lp.verifyLogoIsDisplayedOrNot();
		Assert.assertTrue(status, "Test Script Failed Because Logo Is not Displayed");
		 rd = new ReadData("LoginPageData", "Sheet2");
			List<String> rowData= rd.getExcelSheetRowDada(4);
			lp.enterTextInUserNameField(rowData.get(0));
			lp.enterTextInPasswordField(rowData.get(1));
			lp.clickOnLoginButton();
			Assert.assertTrue(status, "Test Script Failed Because of Dashboard Lable is Not Visable");
			
			}
	
////	@Test(retryAnalyzer=RetryLogic.class)
//	@Test
//	public void verifyLoginFunctionality_ValidUsernameAndPassword_3() throws Throwable {
//		lp = new LoginPage(driver);
//		boolean status = lp.verifyLogoIsDisplayedOrNot();
//		Assert.assertTrue(status, "Test Script Failed Because Logo Is not Displayed");
//		 rd = new ReadData("LoginPageData", "Sheet2");
//			List<String> rowData= rd.getExcelSheetRowDada(4);
//			lp.enterTextInUserNameField(rowData.get(0));
//			lp.enterTextInPasswordField(rowData.get(1));
//			lp.clickOnLoginButton();
//			Assert.assertTrue(status, "Test Script Failed Because of Dashboard Lable is Not Visable");
//			
//			}
//	
//	
}
