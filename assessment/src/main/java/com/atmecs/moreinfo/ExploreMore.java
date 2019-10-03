package com.atmecs.moreinfo;

import java.io.FileInputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.atmecs.helper.ElementHelper;
import com.atmecs.utils.BaseClass;
import com.atmecs.utils.Constants;
/**
 * 
 * validates breadcrumb and title by clicking on Exploremore link.
 * 
 * @author kishor.joshi
 *
 */
public class ExploreMore extends BaseClass{
	
	/**
	 * validates the All content's title and breadcrumb appeared on service page.
	 * @param driver
	 * @throws Exception
	 */
public void validateServiceContent(WebDriver driver) throws Exception {
	Properties prop=new Properties();
	ElementHelper helper=new ElementHelper();
	MoreInfoHelperClass moreHelperObj=new MoreInfoHelperClass();
	driver.manage().timeouts().pageLoadTimeout(Constants.waitingTime, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(Constants.waitingTime, TimeUnit.SECONDS);
	FileInputStream input = new FileInputStream(Constants.moreinfoPropertiesFilePath);
	prop.load(input);
	
	WebElement exploreElement=helper.getElement(driver, prop, "exploremorelink");
	moreHelperObj.scrollAndView(driver,exploreElement );
	exploreElement.click();
	String moreinfoXpath=prop.getProperty("readmorelist");
	moreHelperObj.navigateToEachPage(driver,moreinfoXpath,Constants.serviceContentsDataPath );
	}



}
