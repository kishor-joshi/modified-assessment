package com.atmecs.moreinfo;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.atmecs.helper.ElementHelper;
import com.atmecs.helper.ExcelReader;
import com.atmecs.utils.Constants;
import com.atmecs.utils.ValidateHelper;
import com.atmecs.utils.atmecsExtendReport;

/**
 * this is helper class.validates the breadcrumb by navigating to each page 
 * 
 * @author kishor.joshi
 *
 */

public class MoreInfoHelperClass {
	Logger log=Logger.getLogger(MoreInfo.class);
	Properties prop=new Properties();
	ElementHelper helper=new ElementHelper();
	MoreInfo infoObj=new MoreInfo();
	
	/**
	 * validates breadcrumb
	 * 
	 * @param driver
	 * @throws Exception
	 */
	
	public void validateBreadCrumb(WebDriver driver,String expectedTitel) throws Exception {
		FileInputStream input = new FileInputStream(Constants.moreinfoPropertiesFilePath);
		prop.load(input);
		String homeURL=prop.getProperty("url");
		String[] expectedBreadcrumb=driver.getCurrentUrl().replace(homeURL, "Home").replace("-", " ").split("/");
		List<WebElement>actualBreadcrumb=helper.getElements(driver, prop, "breadcrumblist");
		ValidateHelper.breadcrumbValidation(actualBreadcrumb,expectedBreadcrumb );
		String actualTitle=helper.getElement(driver, prop, "pagetitle").getText();
		String currentBreadcrumb=helper.getElement(driver, prop, "currentbreadcumb").getText();
		Assert.assertEquals(actualTitle, currentBreadcrumb,"Title not matched with Breadcrumb at: "+actualTitle);
		log.info("Title matched with Breadcrumb at: "+actualTitle);
		Assert.assertEquals(actualTitle, expectedTitel,"title not matched");
		log.info("title matched at: "+expectedTitel);
		//atmecsExtendReport.reportLog("validateBreadCrumb", "failed");
		driver.navigate().back();
	}
	
	
	/**
	 * navigate to each page by clicking on elements having common xpath.
	 * 
	 * @param driver
	 * @param commonxpath
	 * @throws Exception
	 */
	
	public void navigateToEachPage(WebDriver driver,String commonxpath,String excelTitelPath) throws Exception {
		String[][] getTitles =ExcelReader.getUserData(excelTitelPath);
		List<WebElement>list=driver.findElements(By.xpath(commonxpath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i=1;i<=list.size();i++) {
			String eachXpath=commonxpath+"["+i+"]";
			WebElement infoElement=driver.findElement(By.xpath(eachXpath));
			js.executeScript("arguments[0].scrollIntoView(false);", infoElement);
			infoElement.click();
			validateBreadCrumb(driver,getTitles[i-1][0]);
			
		}
	}
	/**
	 * 
	 * scroll upto visibility of specified element
	 * @param driver
	 * @param element
	 */
	public void scrollAndView(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", element);
	}
}
