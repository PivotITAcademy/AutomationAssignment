package com.pivotcoachingacademy.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pivotcoachingacademy.Base.TestBase;



public class AccountLogin extends TestBase{
	public AccountLogin() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	private WebElement emailInputField;

	@FindBy(id = "input-password")
	private WebElement passwordInputField;

	@FindBy(css = "input[value='Login']")
	private WebElement loginBtn;

	@FindBy(css = "div.form-group a")
	private WebElement forgotPasswordLink;

	@FindBy(css = "div.alert")
	private WebElement passwordResetLinkText;

	public void enterEmail(String email) {
		emailInputField.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordInputField.sendKeys(password);
	}

	public MyAccount clickLoginBtn(String email,String Password) {
		enterEmail(email);
		enterPassword(Password);
		loginBtn.click();
		return new MyAccount();
	}


}
