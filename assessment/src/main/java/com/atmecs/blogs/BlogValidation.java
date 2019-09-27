package com.atmecs.blogs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
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
}
