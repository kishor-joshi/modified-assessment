package com.atmecs.scripts;

import org.testng.annotations.Test;

import com.atmecs.moreinfo.ExploreMore;
import com.atmecs.moreinfo.MoreInfo;
import com.atmecs.utils.BaseClass;
/**
 * 
 * @author kishor.joshi
 *
 */

public class ValidateMoreInfo extends BaseClass{
	MoreInfo infoObj=new MoreInfo();
	ExploreMore exploreObj=new ExploreMore();
	
	/**
	 * moreinfo and exploremore validation
	 * @throws Exception
	 */
	
@Test
public void moreInfoValidation() throws Exception {
	infoObj.validateMoreInfo(driver);
	
	//exploreObj.validateServiceContent(driver);
}
}
