package com.orangehrm.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartFunctions {

	public static WebDriver driver;
	
	public SmartFunctions(WebDriver driver)
	{
		SmartFunctions.driver=driver;
	}
	
	public static WebElement getElement(String xpath)
	{
		By locator= By.xpath(xpath);
		return driver.findElement(locator);
	}
	public static List<WebElement> getElements(String xpath)
	{
		By locator= By.xpath(xpath);
		return driver.findElements(locator);
	}
	public static void click(WebElement element)
	{
		element.click();
	}
	
	public static void sendKeys(WebElement element,String text)
	{
		element.sendKeys(text);
	}
	public static boolean isDisplayed(WebElement element)
	{
		return element.isDisplayed();
	}
	public static String getText(WebElement element)
	{
		return element.getText();
	}
	
}
