package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility
{

	private static final By EMAIL_TEXTBOX_LOCATOR = By.id("username");
	private static final By PASSWORD_TEXTBOX_LOCATOR = By.id("password");
	private static final By SIGNIN_BUTTON_LOCATOR = By.className("btn__primary--large");
	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public FeedPage doLoginWith(String emailId, String password)
	{
		enterText(EMAIL_TEXTBOX_LOCATOR, emailId);
		enterText(PASSWORD_TEXTBOX_LOCATOR, password);
		clickOn(SIGNIN_BUTTON_LOCATOR);
		
		FeedPage feedPage = new FeedPage(getDriver());
		return feedPage;
		
	}

}
