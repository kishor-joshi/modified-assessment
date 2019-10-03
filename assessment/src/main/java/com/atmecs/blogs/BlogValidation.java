package com.atmecs.blogs;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.record.HideObjRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.atmecs.helper.ElementHelper;
import com.atmecs.utils.BaseClass;
import com.atmecs.utils.Constants;
import com.atmecs.utils.MonthConvertion;

public class BlogValidation extends BaseClass {
	Logger log=Logger.getLogger(BlogValidation.class);
	Properties prop=new Properties();
	 ElementHelper helper=new ElementHelper();
	 MonthConvertion monthObj=new MonthConvertion();
	 
public void validateBreadCrumb(WebDriver driver) throws Exception {
	driver.manage().timeouts().pageLoadTimeout(Constants.waitingTime, TimeUnit.SECONDS);
	FileInputStream input = new FileInputStream(Constants.blogPropertiesFilePath);
	prop.load(input);
	log.info("title is "+driver.getTitle());
	String[] title=driver.getTitle().split("\\s\\|\\s");
	
	List<WebElement>breadCrumbList=helper.getElements(driver, prop, "breadcrumb");
	String breadCrumb=breadCrumbList.get(breadCrumbList.size()-1).getText();
	Assert.assertEquals(title[0], breadCrumb,"breadCrumb not matched");
	log.info("breadCrum matched.breadCrumb is "+breadCrumb);
}




public void validateDate(WebDriver driver) throws Exception {
	driver.manage().timeouts().pageLoadTimeout(Constants.waitingTime, TimeUnit.SECONDS);
	FileInputStream input = new FileInputStream(Constants.blogPropertiesFilePath);
	prop.load(input);
	String blogdate=helper.getElement(driver, prop, "blogdate").getText();
	monthObj.monthDifference(blogdate);
}




public void validateErrorMessage(WebDriver driver) throws Exception {
	FileInputStream input = new FileInputStream(Constants.blogPropertiesFilePath);
	prop.load(input);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement element=helper.getElement(driver, prop, "inputcommentbox");
	Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
    String browserName = cap.getBrowserName().toLowerCase();
	boolean isErrorMessageDisplayed=helper.isErrorMessageShowing(element, browserName);
	js.executeScript("arguments[0].scrollIntoView();", element);
	
	helper.getElement(driver, prop, "postcomment").click();
	isErrorMessageDisplayed=helper.isErrorMessageShowing(element, browserName);
	log.info("error message: "+element.getAttribute("validationMessage"));
	Assert.assertEquals(isErrorMessageDisplayed,true,"failed: hidden message is not displayed posted comment with no data at comment box");
	log.info("passed: hidden message is displayed for posted comment with no data at comment box ");
}
}
