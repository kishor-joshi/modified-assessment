package com.atmecs.helper;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * 
 * @author kishor.joshi
 *
 */

public class ElementHelper {
	
	/**
	 * this method returns webElement for respective locator.
	 * 
	 * @param driver
	 * @param property
	 * @param locators
	 * @return
	 * @throws Exception
	 */
	public  WebElement getElement(WebDriver driver,Properties property,String locators) throws Exception{
		
		String[] locatorArray=property.getProperty(locators).split("%", 2);
		String objectType=locatorArray[0].toUpperCase();
		String locator=locatorArray[1];
	   
		switch(objectType) {
		 //Find by xpath
		case "XPATH" :        
	        return driver.findElement(By.xpath(locator));
	      
	    
	    //Find by css
		case "CSS":          
	        return driver.findElement(By.cssSelector(locator));
	        
	       //find by class
		case "CLASSNAME" :
	        return driver.findElement(By.className(locator));
	       
	    
	    //find by name
		case "NAME" :
	        return driver.findElement(By.name(locator));
	       
	  
	   
	    //find by link
		case "LINK": 
	        return driver.findElement(By.linkText(locator));
	      
	   
	    //find by partial link
		case "PARTIALLINK" :
	        return driver.findElement(By.partialLinkText(locator));
	     
	   default:
		   return driver.findElement(By.xpath(locator));
		}
	}
	
	/**
	 * 
	 * this method returns list of webElements for respective locator.
	 * @param driver
	 * @param property
	 * @param locators
	 * @return
	 * @throws Exception
	 */
	public  List<WebElement> getElements(WebDriver driver,Properties property,String locators) throws Exception{
		
		String[] locatorArray=property.getProperty(locators).split("%", 2);
		String objectType=locatorArray[0].toUpperCase();
		String locator=locatorArray[1];
	   
		switch(objectType) {
		 //Find by xpath
		case "XPATH" :        
	        return driver.findElements(By.xpath(locator));
	      
	    
	    //Find by css
		case "CSS":          
	        return driver.findElements(By.cssSelector(locator));
	        
	       //find by class
		case "CLASSNAME" :
	        return driver.findElements(By.className(locator));
	       
	    
	    //find by name
		case "NAME" :
	        return driver.findElements(By.name(locator));
	       
	  
	   
	    //find by link
		case "LINK": 
	        return driver.findElements(By.linkText(locator));
	      
	   
	    //find by partial link
		case "PARTIALLINK" :
	        return driver.findElements(By.partialLinkText(locator));
	     
	   default:
		   return driver.findElements(By.xpath(locator));
	       
	 
		}
	}
	public static  List<String> convertToString(List<WebElement> listOfElement) throws Exception{
		List<String>listOfString=new LinkedList<String>();
		for(int i=0;i<listOfElement.size();i++) 
			listOfString.add(i, listOfElement.get(i).getText());
			return listOfString;
	}
	
}
