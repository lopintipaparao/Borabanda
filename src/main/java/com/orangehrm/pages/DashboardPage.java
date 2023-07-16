package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orangehrm.utils.Browser;
import com.orangehrm.utils.SmartFunctions;

//import org.openqa.selenium.WebDriver;

public class DashboardPage extends SmartFunctions {
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	public boolean verifyLogoIsDisplayedOrNot() {
		Browser.explicitWait_visibilityOfElement(10, By.xpath(Browser.getLocator("loginpage", "companyLogo_locator")));
		WebElement logo_element = SmartFunctions.getElement(Browser.getLocator("loginpage", "companyLogo_locator"));
		return SmartFunctions.isDisplayed(logo_element);
	}

	public void enterTextInUserNameField(String username) {
		WebElement username_element = SmartFunctions
				.getElement(Browser.getLocator("loginpage", "username_Locator"));
		SmartFunctions.sendKeys(username_element, username);
	}
	
	public void enterTextInPasswordField(String password) {
		WebElement password_element = SmartFunctions
				.getElement(Browser.getLocator("loginpage", "password_Locator"));
		SmartFunctions.sendKeys(password_element, password);
	}
	
	public void clickOnLoginButton() {
		WebElement loginButton_element = SmartFunctions
				.getElement(Browser.getLocator("loginpage", "loginButton_Locator"));
		loginButton_element.click();
	}

	public String Verify_Required_ErrorMessage() {
		return SmartFunctions
				.getText(SmartFunctions.getElement(Browser.getLocator("loginpage", "errorMessage_Locator")));

	}
	
	public String Verify_InvalidCredentials_ErrorMessage() {
		Browser.explicitWait_visibilityOfElement(10, By.xpath(Browser.getLocator("loginpage", "invalidCredentialsErrorMsg_Locator")));
		return SmartFunctions
				.getText(SmartFunctions.getElement(Browser.getLocator("loginpage", "invalidCredentialsErrorMsg_Locator")));

	}
	
	public boolean verifyDashboardLableIsDisplayedOrNot() {
		Browser.explicitWait_visibilityOfElement(10, By.xpath(Browser.getLocator("loginpage", "dashboard_Locator")));
		WebElement dashboardLable_element = SmartFunctions.getElement(Browser.getLocator("loginpage", "dashboard_Locator"));
		return SmartFunctions.isDisplayed(dashboardLable_element);
	}


}
