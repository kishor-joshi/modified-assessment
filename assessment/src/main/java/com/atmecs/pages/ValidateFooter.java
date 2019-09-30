package com.atmecs.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.helper.ElementHelper;
import com.atmecs.helper.ExcelReader;
import com.atmecs.utils.BaseClass;
import com.atmecs.utils.Constants;

public class ValidateFooter {
	
	
	
public  void ValidateFooterContent(WebDriver driver) throws Exception {
	Logger log=Logger.getLogger(ValidateFooter.class);
	
	ElementHelper helper=new ElementHelper();
	Properties prop=new Properties();
	 String[][] getFooterElement;
	FileInputStream input = new FileInputStream(Constants.homeLocatorPropertiesFilePath);
	prop.load(input);
	
	getFooterElement=ExcelReader.getUserData(Constants.footeerElementData);
	WebElement footerElement=helper.getElement(driver, prop, "footer");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", footerElement);
	
	for(int i=0;i<getFooterElement.length;i++) {
		String xpath=prop.getProperty("footertextelement").replace("###", getFooterElement[i][0]);
		 WebElement element=driver.findElement(By.xpath(xpath));
		 boolean isPresent=element.isDisplayed();
		 Actions action = new Actions(driver);
		 action.moveToElement(element).build().perform();
		 Assert.assertEquals(true, isPresent,getFooterElement[i][0]+"not displayed");
		 log.info(getFooterElement[i][0]+" displayed");
	
	}
	
	
}
}
