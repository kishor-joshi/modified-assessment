package com.atmecs.scripts;

import org.testng.annotations.Test;

import com.atmecs.blogs.Blogs;
import com.atmecs.blogs.BlogValidation;
import com.atmecs.utils.BaseClass;

public class ValidateBlog extends BaseClass {
	Blogs blog=new Blogs();
	BlogValidation validate=new  BlogValidation();
	
	@Test
public void validatebloger() throws Exception {
	blog.navigateToBlog(driver);
	blog.validateBlog(driver);
	validate.validateBreadCrumb(driver);
	validate.validateDate(driver);
	
	
}
}
