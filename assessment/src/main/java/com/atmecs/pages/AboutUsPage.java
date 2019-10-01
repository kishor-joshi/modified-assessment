package com.atmecs.pages;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.atmecs.helper.ElementHelper;
import com.atmecs.utils.BaseClass;
import com.atmecs.utils.Constants;

public class AboutUsPage extends BaseClass{
	
	
	
public  void aboutuspageFotterValidation(WebDriver driver) throws Exception {
	Properties prop=new Properties();
	ElementHelper helper=new ElementHelper();
	ValidateFooter footer=new ValidateFooter();
FileInputStream input = new FileInputStream(Constants.homeLocatorPropertiesFilePath);
prop.load(input);
Actions action = new Actions(driver);
WebElement element=helper.getElement(driver, prop, "aboutus");
action.moveToElement(element).build().perform();
element.click();
driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
String title=driver.getTitle();
System.out.println(title);

//validate footer at about page
footer.ValidateFooterContent(driver);

}
	
}
