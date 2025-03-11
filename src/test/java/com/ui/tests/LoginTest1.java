package com.ui.tests;

import org.openqa.selenium.By;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;

public class LoginTest1
{
	public static void main(String[] args) 
	{
		
		HomePage homePage = new HomePage(Browser.EDGE, false);
		homePage.goToWebsite("https://www.linkedin.com/");
		homePage.maximizeWindow();
		
		By openInAPPNotificationCloseLocator = By.cssSelector("#close-small");
		homePage.clickOn(openInAPPNotificationCloseLocator);
		
		By signInLinkLocator = By.linkText("Sign in");
		homePage.clickOn(signInLinkLocator);
		
		By emailTextBoxLocator = By.id("username");
		homePage.enterText(emailTextBoxLocator, "smurthy1298@gmail.com");
		
		By passwordTextBoxLocator = By.id("password");
		homePage.enterText(passwordTextBoxLocator, "Sathya@1298");
		
		By signInButtonLocator = By.className("btn__primary--large");
		homePage.clickOn(signInButtonLocator);
		
		LoginPage loginPage = homePage.goToLoginPage();
		loginPage.doLoginWith("smurthy1298@gmail.com", "Sathya@1298");
		
	}
}
