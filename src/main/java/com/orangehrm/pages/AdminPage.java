package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orangehrm.utils.Browser;
import com.orangehrm.utils.SmartFunctions;

public class AdminPage {

	WebDriver driver;

	public AdminPage(WebDriver driver) {
		
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
}
