package com.ui.pages;

import static com.constants.Env.QA;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.ui.utility.BrowserUtility;
import static com.ui.utility.PropertiesUtil.*;
import com.ui.utility.JSONUtil;
import com.ui.utility.LoggerUtility;

public final class HomePage extends BrowserUtility
{
	
	private static final By OPEN_IN_APP_NOTIFICATION_POPUP_LOCATOR = By.cssSelector("#close-small");
	private static final By SIGN_IN_LINK_LOCATOR = By.linkText("Sign in");
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	public HomePage(Browser browserName, boolean isheadless) 
	{
		super(browserName,isheadless);
		goToWebsite(readProperty(QA, "URL"));
		maximizeWindow();
	}
	
	public HomePage(WebDriver browserName) 
	{
		super(browserName);
		goToWebsite(JSONUtil.readJson(QA).getUrl());
		maximizeWindow();
	}
	
	public LoginPage goToLoginPage()
	{
		logger.info("Clicking on Sign In page");
		clickOn(OPEN_IN_APP_NOTIFICATION_POPUP_LOCATOR);
		clickOn(SIGN_IN_LINK_LOCATOR);
		
		return new LoginPage(getDriver());
	}

}
