package com.atmecs.contentmenu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.atmecs.blogs.BlogValidation;
import com.atmecs.helper.ElementHelper;
import com.atmecs.helper.ExcelReader;
import com.atmecs.utils.BaseClass;
import com.atmecs.utils.Constants;

public class ContentOfServices extends BaseClass{
	
	
	Logger log=Logger.getLogger(BlogValidation.class);
	Properties prop=new Properties();
	 ElementHelper helper=new ElementHelper();
	 
	 
	 
public void validateContentOfServices(WebDriver driver) throws Exception {

	FileInputStream input = new FileInputStream(Constants.contentPropertiesFilePath);
	prop.load(input);
	driver.manage().timeouts().pageLoadTimeout(Constants.waitingTime, TimeUnit.SECONDS);
	WebElement serviceElement=helper.getElement(driver, prop, "services");
	Actions action = new Actions(driver);
	
	
	String[][] ContentList=ExcelReader.getUserData("./src/main/resources/testdata/content.xlsx");
	
	
	for(int j=0;j<2;j++) {
	action.moveToElement(serviceElement).build().perform();
	String dropdownvalue=prop.getProperty("actionOn").replace("###", ContentList[0][j]);
 	WebElement element=driver.findElement(By.xpath(dropdownvalue));
 	action.moveToElement(element).build().perform();
 	
 	
 	for( int i=1;i<ContentList.length;i++) {
	String content=prop.getProperty("content").replace("*****", ContentList[0][j]).replace("###", ContentList[i][j]);
	WebElement dropdownElement=driver.findElement(By.xpath(content));
	boolean isVisible=driver.findElement(By.xpath(content)).isDisplayed();
	if(isVisible) {
		action.moveToElement(dropdownElement).build().perform();
	log.info(ContentList[i][j]+" is present at: "+ContentList[0][j]);
	   }
 	 }
	
	}
		
	
}
}
