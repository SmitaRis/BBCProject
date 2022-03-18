package com.bbcproject.testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bbcproject.actiondriver.Action;
import com.bbcproject.base.BaseClass;
import com.bbcproject.pageobjects.BBCHomePage;
import com.bbcproject.utility.Log;

public class VerifyDayDate extends BaseClass{
	
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
	public void verifyDayDate() throws Throwable {
		Log.startTestCase("Verify the day and date");
		bbchomePage=new BBCHomePage();
		action=new Action();
		action.implicitWait(getDriver(), 20);
		bbchomePage.validateCosent();
		String date=action.getCurrentTime();
		action.screenShot(getDriver(), date);
	}
	
		

}
