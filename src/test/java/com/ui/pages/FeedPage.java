package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utility.BrowserUtility;

public final class FeedPage extends BrowserUtility
{
	private static final By PROFILE_NAME_LOCATOR = By.cssSelector(".profile-card-member-details h3");
	public FeedPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public String getProfileName()
	{
		return getVisibleText(PROFILE_NAME_LOCATOR);
	}

}
