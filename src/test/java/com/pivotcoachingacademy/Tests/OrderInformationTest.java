package com.pivotcoachingacademy.Tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pivotcoachingacademy.Base.TestBase;
import com.pivotcoachingacademy.Pages.AccountLoginPage;
import com.pivotcoachingacademy.Pages.HomePage;
import com.pivotcoachingacademy.Pages.MyAccountPage;
import com.pivotcoachingacademy.Pages.OrderHistoryPage;
import com.pivotcoachingacademy.Pages.OrderHistoryPage.OrderHistory;
import com.pivotcoachingacademy.Pages.OrderInformationPage;
import com.pivotcoachingacademy.Pages.OrderInformationPage.OrderInformation;
import com.pivotcoachingacademy.Pages.ProductReturnsPage;

public class OrderInformationTest extends TestBase {
	SoftAssert softAssert;
	HomePage homePage;
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;
	OrderHistoryPage orderHistoryPage;
	OrderInformationPage orderInformationPage;
	ProductReturnsPage productReturnsPage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		softAssert = new SoftAssert();
		homePage = new HomePage();
		accountLoginPage = new AccountLoginPage();
		myAccountPage = new MyAccountPage();
		orderHistoryPage = new OrderHistoryPage();
		orderInformationPage = new OrderInformationPage();
		productReturnsPage = new ProductReturnsPage();
		homePage.clickLoginLink();
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		accountLoginPage.login(username, password);
		myAccountPage.clickOrderHistoryLink();
		orderHistoryPage.clickOnViewLink("#4292", OrderHistory.ACTION, By.cssSelector("a"));
	}

	@Test
	public void validateTitle() {

		// validating title of my order information page
		softAssert.assertEquals(driver.getTitle(), "Order Information", "Title doesn't match");
		softAssert.assertAll();
	}

	@Test
	public void verifyUserIsAbleToReorderProduct() {

		// validate product is added to cart after reorder
		orderInformationPage.reorderProduct("MacBook", OrderInformation.ACTION, By.cssSelector("a:first-of-type"));
		softAssert.assertEquals(orderInformationPage.getTextFromSuccessBannerAfterReorder(),
				"Success: You have added " + orderInformationPage.getProductNameInSuccessBanner() + " to your "
						+ orderInformationPage.getShoppingCartInSuccessBanner() + "!\n×",
				"Text on success banner doesn't match");
		softAssert.assertAll();

	}

	@Test
	public void verifyUserIsAbleToReturnProduct() {
		String successMessageAfterProductReturn = properties.getProperty("successMessageAfterProductReturn");

		// validate user is able to return product by submitting form on return products
		// page
		orderInformationPage.returnProduct("MacBook Air", OrderInformation.ACTION, By.cssSelector("a:last-of-type"));

		// select reason for return by clicking on radio button on Product Returns page
		productReturnsPage.clickOnRadioBtn();

		// submit the product returns form
		productReturnsPage.clickOnSubmitBtn();

		// validate the success message after product return
		softAssert.assertEquals(productReturnsPage.getTextFromSuccessMessageAfterProductReturn(),
				successMessageAfterProductReturn, "Text on success banner doesn't match");
		softAssert.assertAll();
	}

	@Test
	public void validateSubTotal() {
		// validating subTotal is equal to sum of price of all the products
		softAssert.assertEquals(orderInformationPage.getTextFromSubTotalValue(),
				orderInformationPage.calcualteSubTotal(OrderInformation.TOTAL), "subTotal doesn't match");
		softAssert.assertAll();
	}

	@Test(dependsOnMethods = "validateSubTotal")
	public void validateTotal() {
		// validating total is equal to sum of subTotal and flat shipping rate
		softAssert.assertEquals(orderInformationPage.getTextFromTotalValue(), orderInformationPage.calcualteTotal(),
				"total doesn't match");
		softAssert.assertAll();
	}

	@Test
	public void validateContinueBtn() {
		// validating continue button is navigating user back to order history page
		orderInformationPage.clickOnContinueBtn();
		softAssert.assertEquals(driver.getTitle(), "Order History", "Title doesn't match");
		softAssert.assertAll();
	}

	@AfterMethod
	public void teardown() {
		quitBrowser();
	}
}
