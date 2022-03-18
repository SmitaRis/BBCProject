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


public class BBCHomePageTest extends BaseClass{
	
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
	public void verifyHomePage() throws Throwable {
		
		Log.startTestCase("Verify the Home Button of BBC news");
		bbchomePage=new BBCHomePage();
		action=new Action();
		action.implicitWait(getDriver(), 20);
		bbchomePage.validateCosent();
		boolean alert=action.Alert(getDriver());
		Log.info("Verify if Home Button is visible");
		Thread.sleep(20);
		boolean home=bbchomePage.validateHomeButton();
		Assert.assertTrue(home);
		Log.info("verify the welcome text is visible");
		boolean welcometext=bbchomePage.validateWelcomeText();
		Thread.sleep(20);
		Assert.assertTrue(welcometext);
		Log.info("verify the sport is visible");
		boolean sportText=bbchomePage.validateSportText();
		Assert.assertTrue(sportText);
		Thread.sleep(20);
		String actualURL=bbchomePage.getCurrURL();
	    String expectedURL="https://www.bbc.com/";
	    Log.info("verifying the actual and expected url");
	    Assert.assertEquals(actualURL, expectedURL);
	    
		
		
	}
}
