package com.pivotcoachingacademy.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.pivotcoachingacademy.Base.TestBase;
import com.pivotcoachingacademy.pages.AccountLogin;
import com.pivotcoachingacademy.pages.AccountLogout;
import com.pivotcoachingacademy.pages.MyAccount;
import com.pivotcoachingacademy.pages.YourStore;

public class MyAccountTest extends TestBase {
	YourStore yourStore;
	AccountLogin accountLogin;
	MyAccount myAccount;
	AccountLogout accountLogout;
	SoftAssert sf= new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		launchBrowser();
		yourStore =new YourStore();
	}
	@Test
	public void validateLoginWithValidCredential() {
		yourStore.clickMyAccountBtn();
		accountLogin=yourStore.clickLoginBtn();
		myAccount=accountLogin.loginToPortal("riti@gmail.com", "Password2");
		sf.assertEquals(myAccount.getMyAccountText(), "My Account");
		sf.assertAll();
	}
	
	@Test
	public void validateLoginAfterSuccessfulLogoutFromSideNavigation() {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		myAccount = accountLogin.loginToPortal("riti@gmail.com", "Password2");
		myAccount.clickMyAccountBtn();
		accountLogout = myAccount.clickLogoutBtn();
		sf.assertEquals(accountLogout.getTextForAccountLogout(), "Account Logout");
		accountLogin = accountLogout.clickOnSideNavLogin();
		myAccount = accountLogin.loginToPortal("riti@gmail.com", "Password2");
		sf.assertEquals(myAccount.getMyAccountText(), "My Account");
		sf.assertAll();
	}
	
	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}


}
