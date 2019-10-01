package com.atmecs.blogs;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.helper.ElementHelper;
import com.atmecs.helper.ExcelReader;
import com.atmecs.pages.ValidateFooter;
import com.atmecs.utils.BaseClass;
import com.atmecs.utils.Constants;
import com.atmecs.utils.MonthConvertion;

public class Blogs extends BaseClass{
	MonthConvertion monthObj=new MonthConvertion();
	Logger log=Logger.getLogger(Blogs.class);
	
	 Properties prop=new Properties();
	 ElementHelper helper=new ElementHelper();
	
	 String[][] blogcondtion;
	public void navigateToBlog(WebDriver driver) throws Exception {
		
		FileInputStream input = new FileInputStream(Constants.blogPropertiesFilePath);
		prop.load(input);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebElement element=helper.getElement(driver, prop, "insights");
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebElement blogelement=helper.getElement(driver, prop, "blog");
		action.moveToElement(blogelement).build().perform();
		blogelement.click();
	
		
		List<WebElement>datelist=helper.getElements(driver, prop, "blogdates");
		System.out.println(datelist.size());
		for(WebElement date:datelist) {
		
		int differenceOfDay=Integer.parseInt(monthObj.monthDifference(date.getText()));
		if(differenceOfDay>90) {
			String blogXpath=prop.getProperty("blogtitlewithdatecondtion").replace("###", date.getText());
			String blogName=driver.findElement(By.xpath(blogXpath)).getText();
			log.info("blog name of "+date.getText()+" is :"+blogName);
		}
			
		}
		blogcondtion=ExcelReader.getUserData(Constants.ExcelFilePath);
		String xpath=prop.getProperty("blogcondtion").replace("###", blogcondtion[1][0]);
		WebElement readMoreElement=driver.findElement(By.xpath(xpath));
		
		action.moveToElement(readMoreElement).build().perform();
		readMoreElement.click();
	}
	
	
	
	public void validateBlog(WebDriver driver) throws Exception {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		FileInputStream input = new FileInputStream(Constants.blogPropertiesFilePath);
		prop.load(input);
		String[][] blogcondtion=ExcelReader.getUserData(Constants.ExcelFilePath);
		String actualblogtitle=driver.getTitle();
		if(actualblogtitle.contentEquals(blogcondtion[1][0]))
		Assert.assertEquals(true, "differentblog selected");
	}
	
	
	
	
	
	
	
	
}
