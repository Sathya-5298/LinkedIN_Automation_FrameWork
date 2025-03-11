package com.ui.tests;

import static com.constants.Browser.*;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ui.pages.HomePage;
import com.ui.utility.BrowserUtility;
import com.ui.utility.LambdaTestUtility;
import com.ui.utility.LoggerUtility;

public class BaseTest 
{
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;
	
	@Parameters({"browser","isLambdaTest","isHeadless"})
	@BeforeMethod(description = "Loads the Homepage")
	public void setUp(@Optional("chrome") String browser,@Optional("false") boolean isLambdaTest,@Optional("true") boolean isHeadless, ITestResult result)
	
	{
		this.isLambdaTest = isLambdaTest;
		WebDriver lambdaDriver;
		if(isLambdaTest)
		{
			lambdaDriver = LambdaTestUtility.intializeLambdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
		}
		else
		{
			logger.info("Loads the Homepage");
			homePage = new HomePage(valueOf(browser.toUpperCase()),isHeadless);
		}
	}
	
	public BrowserUtility getInstance()
	{
		return homePage;
	}
	
	@AfterMethod(description = "Tear Down the browse")
	public void tearDown()
	{
		if(isLambdaTest)
		{
			LambdaTestUtility.quitSession();
		}
		else
		{
			homePage.quit();
		}
	}

}
