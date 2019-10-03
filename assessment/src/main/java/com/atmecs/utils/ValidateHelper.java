package com.atmecs.utils;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class   ValidateHelper {
	
public static void breadcrumbValidation(List<WebElement> breadCrumblist,String[] titlelist) {
	Logger log=Logger.getLogger(ValidateHelper.class);
	for(int i=0;i<breadCrumblist.size();i++) {
		String actualtitle=breadCrumblist.get(i).getText().replaceAll("[^\\w]", "").toLowerCase();
		String expectedtitle=titlelist[i].replaceAll("[^\\w]", "").toLowerCase();
		
				if(actualtitle.equals(expectedtitle))
			log.info("breadcrumb matched at: "+titlelist[i]);
		
		else {
			//atmecsExtendReport.reportLog("validateBreadCrumb", "failed");
			Assert.assertEquals(false, "breadcrumb not matched at: "+"expected: "+actualtitle+" actual: "+expectedtitle);
		}
	
	}
}
}
