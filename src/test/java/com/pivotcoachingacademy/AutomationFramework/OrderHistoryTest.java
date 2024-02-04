package com.pivotcoachingacademy.AutomationFramework;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.pivotcoachingacademy.Pages.AccountLoginPage;
import com.pivotcoachingacademy.Pages.HomePage;
import com.pivotcoachingacademy.Pages.MyAccountPage;
import com.pivotcoachingacademy.Base.TestBase;
import com.pivotcoachingacademy.Pages.OrderHistoryPage;
import com.pivotcoachingacademy.Pages.OrderHistoryPage.OrderHistory;

public class OrderHistoryTest extends TestBase {
	SoftAssert softAssert;
	HomePage homePage;
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	OrderHistoryPage orderHistoryPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		softAssert = new SoftAssert();
		homePage = new HomePage();
		accountLoginPage = new AccountLoginPage();
		myAccountPage = new MyAccountPage();
		orderHistoryPage = new OrderHistoryPage();
		homePage.clickLoginLink();
		accountLoginPage.login("harinder@gmail.com", "Password1");
		myAccountPage.clickOrderHistoryLink();
	}

	@Test
	public void validateTitle() {
		// validating title of my order history page
		softAssert.assertEquals(driver.getTitle(), "Order History", "Title doesn't match");
		softAssert.assertAll();
	}

	@Test
	public void verifyOrderId() {
		// validating order id's of orders in the order history page
		softAssert.assertEquals(
				orderHistoryPage.getElementFromTheOrderHistoryTable("#4292", OrderHistory.ORDERID).getText(), "#4292",
				"Order Id doesn't match");
		softAssert.assertEquals(
				orderHistoryPage.getElementFromTheOrderHistoryTable("#4290", OrderHistory.ORDERID).getText(), "#4290",
				"Order Id doesn't match");
		softAssert.assertAll();
	}

	@Test
	public void verifyViewLink() {
		// validate view link is navigating user to order information page
		orderHistoryPage.clickOnViewLink("#4292", OrderHistory.ACTION, By.cssSelector("a"));
		softAssert.assertEquals(driver.getTitle(), "Order Information", "Title doesn't match");
		softAssert.assertAll();
	}

	@Test
	public void verifyContinueBtn() {
		// validating continue button is navigating user to my account page
		orderHistoryPage.clickOnContinueBtn();
		softAssert.assertEquals(driver.getTitle(), "My Account", "Title doesn't match");
		softAssert.assertAll();
	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}
