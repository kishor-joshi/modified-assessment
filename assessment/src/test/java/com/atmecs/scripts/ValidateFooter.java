package com.atmecs.scripts;

import org.testng.annotations.Test;

import com.atmecs.pages.AboutUsPage;
import com.atmecs.pages.CareerPage;
import com.atmecs.pages.ContactUs;
import com.atmecs.pages.InsightPage;
import com.atmecs.pages.MediaPage;
import com.atmecs.pages.PartnersPage;
import com.atmecs.pages.Services;
import com.atmecs.utils.BaseClass;

public class ValidateFooter extends BaseClass {
	AboutUsPage about=new AboutUsPage();
	CareerPage career=new CareerPage();
	InsightPage sight=new InsightPage();
	PartnersPage page=new PartnersPage();
	Services service=new Services();
	MediaPage mediapage=new MediaPage();
	ContactUs contact=new ContactUs();
	
@Test
void footerValidation() throws Exception {
	about.aboutuspageFotterValidation(driver);
	career.validateFooterAtCareer(driver);
	page.validateFooterAtPartner(driver);
	service.validateFooterAtServices(driver);
	contact.validateFooterAtContactUs(driver);
	
	
	}
}
