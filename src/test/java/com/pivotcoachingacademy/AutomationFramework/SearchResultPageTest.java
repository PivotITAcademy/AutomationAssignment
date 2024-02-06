package com.pivotcoachingacademy.AutomationFramework;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pivotcoachingacademy.Base.TestBase;
import com.pivotcoachingacademy.Pages.HomePage;
import com.pivotcoachingacademy.Pages.LoginPage;
import com.pivotcoachingacademy.Pages.MyAccountPage;
import com.pivotcoachingacademy.Pages.SearchResultPage;

public class SearchResultPageTest extends TestBase {
	HomePage homePage;
	LoginPage loginpage;
	MyAccountPage myaccountpage;
	SearchResultPage searchresultpage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		homePage = new HomePage();
	}

	@Test
	public void validateSearchFunctionality() {
		loginpage = homePage.clickOnLogin();
		myaccountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		searchresultpage = myaccountpage.enterSearchInput("macbook");
		Assert.assertTrue(searchresultpage.isListButtonDisplayed(), "You are not searching a valid product");

	}
	@Test
	public void validateAddToCart() {
		loginpage = homePage.clickOnLogin();
		myaccountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		searchresultpage = myaccountpage.enterSearchInput("macbook");
		searchresultpage.clickOnAddToCartButton();
		Assert.assertEquals(searchresultpage.getTextofSuccessMessage().replaceAll("\\s+", " ").trim(), "Success: You have added MacBook to your shopping cart! ×".trim(),"Product is not added to cart");
	}

	@AfterMethod
	public void closeDown() {
		quitBrowser();

	}

}
