package com.atmecs.pages;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.atmecs.helper.ElementHelper;
import com.atmecs.utils.BaseClass;
import com.atmecs.utils.Constants;

public class AboutUsPage extends BaseClass{
	
	
	//@Test(priority=2)
public  void aboutuspageFotterValidation(WebDriver driver) throws Exception {
	Properties prop=new Properties();
	ElementHelper helper=new ElementHelper();
	ValidateFooter footer=new ValidateFooter();
FileInputStream input = new FileInputStream(Constants.homeLocatorPropertiesFilePath);
prop.load(input);
helper.getElement(driver, prop, "aboutus").click();
driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
String title=driver.getTitle();
System.out.println(title);
footer.ValidateFooterContent(driver);

}
	
}
