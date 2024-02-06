package com.pivotcoachingacademy.AutomationFramework;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pivotcoachingacademy.Base.TestBase;
import com.pivotcoachingacademy.Pages.HomePage;
import com.pivotcoachingacademy.Pages.LoginPage;
import com.pivotcoachingacademy.Pages.MyAccountPage;

public class LoginPageTest extends TestBase {
	HomePage homePage;
	LoginPage loginpage;
	MyAccountPage myaccountpage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		homePage = new HomePage();
	}

	@Test
	public void validateLoginCredentials() {
		loginpage = homePage.clickOnLogin();
		myaccountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		Assert.assertEquals(myaccountpage.getTextOfHeading(), "My Account", "User login attempt failed");

	}

	@AfterMethod
	public void closeDown() {
		quitBrowser();

	}

}
