package com.pivotcoachingacademy.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pivotcoachingacademy.Base.TestBase;

public class LoginPage extends TestBase {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='email']")
	WebElement loginInput;
	@FindBy(css = "input[name='password']")
	WebElement passwordInput;
	@FindBy(css = "input[value='Login']")
	WebElement loginBtn;

	private void enterEmail(String email) {
		loginInput.sendKeys(email);
	}

	private void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public MyAccountPage clickLoginButton(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		loginBtn.click();
		return new MyAccountPage();
	}
}