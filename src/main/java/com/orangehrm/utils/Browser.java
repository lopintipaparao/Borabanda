package com.orangehrm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
	
	public static WebDriver driver;
	public static WebDriver openBrowser(String browsername) throws Exception
	{
		if(browsername.equalsIgnoreCase("chrome"))
		{
//			ChromeOptions cp= new ChromeOptions();
//			cp.addArguments("remote-allow-origins=*");
			driver= new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else
		{
			throw new Exception("Browser Name Doesn't Match");
		}
		
		Browser.implicitlyWait(10);
		
		return driver;
	}
	
	public static void openURL(String url)
	{
		driver.get(url);
	}
	
	public static void closeBrowser()
	{
		driver.close();
	}
	
	public static void getScreenshot(String imagename)
	{
		try
		{
		String filepath= ".//ScreenShots//"+imagename+".jpg";
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(filepath));
		}
		catch(Throwable t)
		{
			t.printStackTrace();
		}
	}
	
	public static void implicitlyWait(int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	public static void explicitWait_visibilityOfElement(int sec, By by)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}
	
	public static String getLocator(String filename, String Key)
	{
		String value="";
		try {
		String filepath=".//src//main//resources//locators//"+filename+".properties";
		FileInputStream is= new FileInputStream(filepath);
		
		Properties pro= new Properties();
		pro.load(is);
		value=pro.getProperty(Key);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return value;
	
	}
}
