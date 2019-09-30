package com.atmecs.blogs;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
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
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
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
	js.executeScript("arguments[0].scrollIntoView();", element);
	WebElement hiddenMessage=helper.getElement(driver, prop, "hiddenmessage");
	Assert.assertEquals(hiddenMessage.isDisplayed(),false ,"failed: hidden message is displaying without clicking on post comment");
	log.info("Passed: hidden message is not displayed without clicking on post comment");

	helper.getElement(driver, prop, "postcomment").click();
	
	Assert.assertEquals(hiddenMessage.isDisplayed(),"failed: hidden message is not displayed posted comment with no data at comment box");
	log.info("passed: hidden message is displayed for posted comment with no data at comment box ");
}
}
