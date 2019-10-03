package com.atmecs.moreinfo;

import java.io.FileInputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import com.atmecs.utils.BaseClass;
import com.atmecs.utils.Constants;

/**
 * validates breadcrumb and title after clicking on each MoreInfo link.
 * @author kishor.joshi
 *
 */
public class MoreInfo extends BaseClass{
	
	/**
	 * 
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public void validateMoreInfo(WebDriver driver) throws Exception {
		Properties prop=new Properties();
		MoreInfoHelperClass moreHelperObj=new MoreInfoHelperClass();
		driver.manage().timeouts().pageLoadTimeout(Constants.waitingTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.waitingTime, TimeUnit.SECONDS);
		FileInputStream input = new FileInputStream(Constants.moreinfoPropertiesFilePath);
		prop.load(input);
		String moreinfoXpath=prop.getProperty("moreinfolist");
		moreHelperObj.navigateToEachPage(driver,moreinfoXpath,Constants.moreInfoTitlesDataPath);
		
		
	}
	
	
	
	
	
	
	
}
