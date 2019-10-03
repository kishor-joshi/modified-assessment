package com.atmecs.pages;

import java.io.FileInputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.atmecs.helper.ElementHelper;
import com.atmecs.utils.Constants;
/**
 * contactUs page.
 * @author kishor.joshi
 *
 */
public class ContactUs {
	public Properties prop=new Properties();
	public ElementHelper helper=new ElementHelper();
	public ValidateFooter footer=new ValidateFooter();
	
	
	public void validateFooterAtContactUs(WebDriver driver) throws Exception {
		FileInputStream input = new FileInputStream(Constants.homeLocatorPropertiesFilePath);
		prop.load(input);
		helper.getElement(driver, prop, "contactus").click();
		driver.manage().timeouts().pageLoadTimeout(Constants.waitingTime, TimeUnit.SECONDS);
		String title=driver.getTitle();
		System.out.println(title);
		
		//validate footer at contact us page.
		footer.ValidateFooterContent(driver);
	}
}
