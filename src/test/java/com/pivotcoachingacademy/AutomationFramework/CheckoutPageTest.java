package com.pivotcoachingacademy.AutomationFramework;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pivotcoachingacademy.Base.TestBase;
import com.pivotcoachingacademy.Pages.CheckoutPage;
import com.pivotcoachingacademy.Pages.HomePage;
import com.pivotcoachingacademy.Pages.LoginPage;
import com.pivotcoachingacademy.Pages.MyAccountPage;
import com.pivotcoachingacademy.Pages.SearchResultPage;

public class CheckoutPageTest extends TestBase {
	HomePage homePage;
	LoginPage loginpage;
	MyAccountPage myaccountpage;
	SearchResultPage searchresultpage;
	CheckoutPage checkoutpage;

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		homePage = new HomePage();
	}

	@Test
	public void validateUserOnCheckoutPageAfterAddingProducts() {
		loginpage = homePage.clickOnLogin();
		myaccountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		searchresultpage = myaccountpage.enterSearchInput("macbook");
		searchresultpage.clickOnAddToCartButton();
		searchresultpage.addMoreItems();
		checkoutpage = searchresultpage.clickOnCheckout();
		Assert.assertEquals(checkoutpage.getPageTitle(), "Checkout","The title of the checkout page is not as expected.");

	}

	@Test
	public void validateIfBillingDetailsAreEnteredSuccesfully() {
		loginpage = homePage.clickOnLogin();
		myaccountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		searchresultpage = myaccountpage.enterSearchInput("macbook");
		searchresultpage.clickOnAddToCartButton();
		searchresultpage.addMoreItems();
		checkoutpage = searchresultpage.clickOnCheckout();
		checkoutpage.selectNewAddressRadioButton();
		checkoutpage.fillDetails("Rajdeep", "Kaur", "15 dudley place", "Brampton", "L6P 3H7", "Canada", "Ontario");
		Assert.assertEquals(checkoutpage.getFirstName(), "Rajdeep", "First name is incorrect");
		 Assert.assertEquals(checkoutpage.getLastName(), "Kaur", "Last name is incorrect");
		 Assert.assertEquals(checkoutpage.getAddress(), "15 dudley place", "Address is incorrect");
		Assert.assertEquals(checkoutpage.getCity(), "Brampton", "City is incorrect");
		Assert.assertEquals(checkoutpage.getPostalCode(), "L6P 3H7", "Postal code is incorrect");
		}

	@Test
	public void validateIfAddressForDeliveryIsSelected() {
		loginpage = homePage.clickOnLogin();
		myaccountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		searchresultpage = myaccountpage.enterSearchInput("macbook");
		searchresultpage.clickOnAddToCartButton();
		searchresultpage.addMoreItems();
		checkoutpage = searchresultpage.clickOnCheckout();
		checkoutpage.clickOnContinueButtonafterfillingBillingDetails();
		Assert.assertTrue(checkoutpage.isDeliveryAddressRadioButtonSelected(),"Delivery address radio button is not selected");
	}

	@Test
	public void validateIfShippingRateIsSelected() {
		loginpage = homePage.clickOnLogin();
		myaccountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		searchresultpage = myaccountpage.enterSearchInput("macbook");
		searchresultpage.clickOnAddToCartButton();
		searchresultpage.addMoreItems();
		checkoutpage = searchresultpage.clickOnCheckout();
		checkoutpage.clickOnContinueButtonafterfillingBillingDetails();
		checkoutpage.clickOnContinueButtonafterfillingDeliveryDetails();
		Assert.assertTrue(checkoutpage.isShippingRateRadioButtonSelected(),"Shipping Rate radio button is not selected");
	}

	@Test
	public void validateIfPaymentMethodIsSelected() {
		loginpage = homePage.clickOnLogin();
		myaccountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		searchresultpage = myaccountpage.enterSearchInput("macbook");
		searchresultpage.clickOnAddToCartButton();
		searchresultpage.addMoreItems();
		checkoutpage = searchresultpage.clickOnCheckout();
		checkoutpage.clickOnPaymentContinueButton();
		Assert.assertTrue(checkoutpage.isPaymentMethodRadioButtonSelected(),"payment method radio button is not selected");
	}

	@Test
	public void validateIfOrderIsConfirmedAndSuccessfullCheckout() {
		loginpage = homePage.clickOnLogin();
		myaccountpage = loginpage.clickLoginButton("rajdeepkaur451@gmail.com", "K@ur6879");
		searchresultpage = myaccountpage.enterSearchInput("macbook");
		searchresultpage.clickOnAddToCartButton();
		searchresultpage.addMoreItems();
		checkoutpage = searchresultpage.clickOnCheckout();
		checkoutpage.clickOnConfirmOrder();
		Assert.assertEquals(checkoutpage.getTextForSuccessMessage(), "Your order has been successfully processed!","Success message does not match expected text");

	}

	@AfterMethod
	public void closeDown() {
		quitBrowser();

	}

}
