package com.atmecs.pages;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.atmecs.helper.ElementHelper;
import com.atmecs.utils.BaseClass;
import com.atmecs.utils.Constants;

public class MediaPage extends BaseClass {
	public Properties prop=new Properties();
	public ElementHelper helper=new ElementHelper();
	public ValidateFooter footer=new ValidateFooter();
	
	public void validateFooterAtMedia(WebDriver driver) throws Exception {
		FileInputStream input = new FileInputStream(Constants.homeLocatorPropertiesFilePath);
		prop.load(input);
		helper.getElement(driver, prop, "media").click();
		driver.manage().timeouts().pageLoadTimeout(Constants.waitingTime, TimeUnit.SECONDS);
		String title=driver.getTitle();
		System.out.println(title);
		
		//validate footer at Media page.
		footer.ValidateFooterContent(driver);
	}
}
