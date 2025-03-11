package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.models.User;
import com.ui.utility.LoggerUtility;


@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends BaseTest
{
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	
	  @Test(description = "Verify login with valid credentails", groups =
	  {"e2e","smoke","sanity","Regression"}, dataProviderClass =
	  com.ui.dataproviders.LoginDataProvider.class, dataProvider =
	  "LoginTestDataProvider") 
	  public void loginTest(User user) {
	  assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),
	  user.getPassword()).getProfileName(), "SathyaMurthy Devalapalli"); }
	  
//	  @Test(description = "Verify login with valid credentails", groups =
//	  {"e2e","smoke","sanity","Regression"}, dataProviderClass =
//	  com.ui.dataproviders.LoginDataProvider.class, dataProvider =
//	  "LoginTestCSVDataProvider", retryAnalyzer =
//	  com.ui.listeners.MyRetryAnalyzer.class) 
//	  public void loginCSVTest(User user) {
//	  assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),
//	  user.getPassword()).getProfileName(), "SathyaMurthy Devalapalli"); }
//	 
//	
//	@Test(description = "Verify login with valid credentails", groups = {"e2e","smoke","sanity","Regression"},
//			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider",
//			retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class
//			)
//	public void loginExcelTest(User user)
//	{
//		
//		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getProfileName(), "SathyaMurthy Devalapalli");
//		
//	}
	
}
