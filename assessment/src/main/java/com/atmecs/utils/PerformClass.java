package com.atmecs.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PerformClass {
	
	/**
	 * 
	 * 	 * @param element
	 * @param text
	 */
	public void SelectByText(WebElement element,String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
}
