package com.atmecs.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	 String[][] getData;
	 String[][] getFooterData;
	FileInputStream input = new FileInputStream(Constants.homeLocatorPropertiesFilePath);
	prop.load(input);
	
	getData = ExcelReader.getUserData(Constants.ExcelFilePath);
	getFooterData = ExcelReader.getUserData(Constants.twotimeDataPath);
	String dataofOnetime[][]=ExcelReader.getUserData(Constants.onetimeDataPath);
	
	for(int i=0;i<getFooterData.length;i++) {
		String element=prop.getProperty("twotimeContent").replace("###", getFooterData[i][0]);
		 boolean isPresent=driver.findElement(By.xpath(element)).isDisplayed();
		 Assert.assertEquals(true, isPresent,getFooterData[i][0]+"not displayed");
		log.info(getFooterData[i][0]+" displayed");
	}
	for(int i=0;i<dataofOnetime.length;i++) {
		String element=prop.getProperty("onetimeContent").replace("###", dataofOnetime[i][0]);
		 boolean isPresent=driver.findElement(By.xpath(element)).isDisplayed();
		 Assert.assertEquals(true, isPresent,dataofOnetime[i][0]+"not displayed");
		 log.info(dataofOnetime[i][0]+" displayed");
	
	}
	
	
	
}
}
