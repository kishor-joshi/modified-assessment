package com.atmecs.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.atmecs.contentmenu.ContentOfServices;
import com.atmecs.utils.BaseClass;

public class ValidateContentMenu extends BaseClass {
	
	ContentOfServices content=new ContentOfServices();
	@Test
public void contentMenuValidation() throws Exception {
	content.validateContentOfServices(driver);
}
}
