package com.atmecs.blogs;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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

public class Blogs extends BaseClass{
	
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
		helper.getElement(driver, prop, "blog").click();
		
		List<WebElement>datelist=helper.getElements(driver, prop, "blogdates");
		System.out.println(datelist.size());
		for(WebElement date:datelist) {
		System.out.println("date is "+date.getText());
		}
		blogcondtion=ExcelReader.getUserData(Constants.ExcelFilePath);
		String xpath=prop.getProperty("blogcondtion").replace("###", blogcondtion[1][0]);
		driver.findElement(By.xpath(xpath)).click();
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
