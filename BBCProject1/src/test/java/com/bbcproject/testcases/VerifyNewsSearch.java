package com.bbcproject.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bbcproject.actiondriver.Action;
import com.bbcproject.base.BaseClass;
import com.bbcproject.pageobjects.BBCHomePage;
import com.bbcproject.utility.Log;

public class VerifyNewsSearch extends BaseClass{
	
	private BBCHomePage bbchomePage;
	private Action action;
	
	@Parameters("browser")
	@BeforeMethod()
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod()
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void verifyNewsSearch() throws Throwable {
		
		Log.startTestCase("Verify the page title for News tab");
		bbchomePage=new BBCHomePage();
		action=new Action();
		action.implicitWait(getDriver(), 20);
		bbchomePage.validateCosent();
		bbchomePage.searchNews();
		
		
	}

}
