package com.pivotcoachingacademy.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.pivotcoachingacademy.Base.TestBase;
import com.pivotcoachingacademy.Utils.ExcelUtils;
import com.pivotcoachingacademy.pages.AccountLogin;
import com.pivotcoachingacademy.pages.AccountLogout;
import com.pivotcoachingacademy.pages.ForgotYourPassword;
import com.pivotcoachingacademy.pages.MyAccount;
import com.pivotcoachingacademy.pages.YourStore;

public class AccountLoginTest extends TestBase {
	YourStore yourStore;
	AccountLogin accountLogin;
	MyAccount myAccount;
	ForgotYourPassword forgotYourPassword;
	AccountLogout accountLogout;
	SoftAssert sf = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		yourStore = new YourStore();
	}

	@Test(dataProvider = "invalidCredentialForLogin")
	public void validateLoginWithInvalidCredential(String email, String password) {

		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		accountLogin.loginToPortal(email, password);
		if (accountLogin.unsuccessfulLoginMessage().equals("Warning: No match for E-Mail Address and/or Password.")) {
			sf.assertEquals(accountLogin.unsuccessfulLoginMessage(),
					"Warning: No match for E-Mail Address and/or Password.");
		} else {
			sf.assertEquals(accountLogin.unsuccessfulLoginMessage(),
					"Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.",
					"unsuccessful Login");
		}
		sf.assertAll();

	}

	@Test
	public void validateLoginWithoutCredential() {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		accountLogin.loginToPortal("", "");
		if (accountLogin.unsuccessfulLoginMessage().equals("Warning: No match for E-Mail Address and/or Password.")) {
			sf.assertEquals(accountLogin.unsuccessfulLoginMessage(),
					"Warning: No match for E-Mail Address and/or Password.");
		} else {
			sf.assertEquals(accountLogin.unsuccessfulLoginMessage(),
					"Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.",
					"unsuccessful Login");
		}
		sf.assertAll();

	}

	@DataProvider(name = "invalidCredentialForLogin")
	public String[][] getDataFromExcelFile() throws Exception {
		String file = "./src\\test\\resources\\InvalidCredentialForLogin.xlsx";
		int rowCount = ExcelUtils.getRowCount(file, "sheet1");
		int columnCount = ExcelUtils.getColumnCount(file, "sheet1", rowCount);
		String[][] virtualSheet = new String[rowCount][columnCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				virtualSheet[i - 1][j] = ExcelUtils.getCellValue(file, "sheet1", i, j);
			}
		}
		return virtualSheet;
	}

	@Test
	public void validateForgottenPassword() {
		yourStore.clickMyAccountBtn();
		accountLogin = yourStore.clickLoginBtn();
		forgotYourPassword = accountLogin.clickForgotPassword();
		forgotYourPassword.enterEmail();
		accountLogin = forgotYourPassword.clickContinueBtn();
		sf.assertEquals(accountLogin.getPasswordResetLinkSuccessMessageText(),
				"An email with a confirmation link has been sent your email address.");
		sf.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}

}
