package com.atmecs.utils;


import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.atmecs.helper.ElementHelper;
import com.atmecs.pages.ValidateFooter;



public class BaseClass {
	public  WebDriver driver;
/**
 * select driver class type
 * 
 * @param selecteddriver
 * @throws IOException
 */
	
	@Parameters({"selecteddriver","modeOfRunning"})
	@BeforeTest
	public void setBrowser(String selecteddriver,String modeOfRunning) throws IOException {
		Properties prop=new Properties();
		
		if(modeOfRunning.equalsIgnoreCase("grid")) {
			System.out.println(selecteddriver);
			driver=com.atmecs.helper.BaseClassForGrid.getDriver(selecteddriver);
		}
		
		else {
			switch (selecteddriver) {
		case "chrome":
			ChromeOptions optionschrome = new ChromeOptions();
			optionschrome.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", Constants.chromeDriverPath);
			 driver = new ChromeDriver(optionschrome);
			break;
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constants.fireFoxDriverPath);
			
			driver = new FirefoxDriver();
			break;
			
		case "ie":
			
			System.setProperty("webdriver.ie.driver", Constants.IEDriverPath);
			driver = new InternetExplorerDriver();
			break;
		}
		}
		driver.manage().timeouts().implicitlyWait(Constants.waitingTime, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		FileInputStream input = new FileInputStream(Constants.homeLocatorPropertiesFilePath);
		prop.load(input);
		driver.manage().timeouts().implicitlyWait(Constants.waitingTime, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	}
	

}
