package com.atmecs.pages;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.atmecs.helper.ElementHelper;
import com.atmecs.utils.BaseClass;
import com.atmecs.utils.Constants;

public class CareerPage extends BaseClass {
	public Properties prop=new Properties();
	public ElementHelper helper=new ElementHelper();
	public ValidateFooter footer=new ValidateFooter();
	

	public  void validateFooterAtCareer(WebDriver driver) throws Exception {
		FileInputStream input = new FileInputStream(Constants.homeLocatorPropertiesFilePath);
		prop.load(input);
		helper.getElement(driver, prop, "careers").click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		String title=driver.getTitle();
		System.out.println(title);
		footer.ValidateFooterContent(driver);
	}
}
