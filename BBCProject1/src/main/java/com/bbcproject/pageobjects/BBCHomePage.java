package com.bbcproject.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.bbcproject.actiondriver.Action;
import com.bbcproject.base.BaseClass;
import com.bbcproject.utility.Log;

public class BBCHomePage extends BaseClass{
	
Action action= new Action();
	
	@FindBy(xpath="(//span[text()='Home'])[1]")
	private WebElement homeButton;
	
	@FindBy(xpath = "//span[text()='Welcome to BBC.com']")
	private WebElement bbcText;
	
	@FindBy(xpath = "//a[text()='News']")
	private WebElement newsText;
	
	@FindBy(xpath = "(//a[text()='Sport'])[1]")
	private WebElement sportText;
	
	@FindBy(xpath = "//p[text()='Consent']")
	private WebElement cosent;
	
	@FindBy(xpath = "//a[text()='Search BBC']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//input[@name='q']")
	private WebElement searchBox;
	
	@FindBy(xpath = "//button[@data-testid='test-search-submit']")
	private WebElement searchKey;
	
	
	@FindBy(xpath = "(//span[text()='News'])[1]")
	private WebElement newsTab;
	
	@FindBy(xpath = "//*[text()='Naomi Wolf: US publisher cancels book release after accuracy concerns']")
	private WebElement searchResult;
	
	public BBCHomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateHomeButton() throws Throwable {
		return action.isDisplayed(getDriver(), homeButton);
	}
	public void validateCosent() throws Throwable {
		
		try {
			if(action.findElement(getDriver(), cosent))
			{
				action.click(getDriver(), cosent);
				//action.wait(2000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean validateWelcomeText() throws Throwable {
		return action.isDisplayed(getDriver(), bbcText);
	}
	
	public boolean validateSportText() throws Throwable {
		return action.isDisplayed(getDriver(), sportText);
	}
	
	public String getCurrURL() throws Throwable {
		String homePageURL=action.getCurrentURL(getDriver());
		return homePageURL;
	}
	
	public void clickOnNewsTab() throws InterruptedException
	{
		action.click(getDriver(), newsTab);
		
	}
	
	public String getCurrURLNewsTab() throws Throwable {
		String newsPageURL=action.getCurrentURL(getDriver());
		return newsPageURL;
	}
	
	public void searchNews() throws InterruptedException
	{
		action.click(getDriver(), searchButton);
		action.type(searchBox, "houghton mifflin harcourt");
		action.click(getDriver(), searchKey);
		boolean result=action.findElement(getDriver(), searchResult);
		try {
			if(result)
			{
				System.out.println("Test passed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
    

}
