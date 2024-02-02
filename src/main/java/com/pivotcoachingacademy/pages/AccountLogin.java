package com.pivotcoachingacademy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pivotcoachingacademy.Base.TestBase;

public class AccountLogin extends TestBase {
	public AccountLogin() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#input-email")
	private WebElement emailIdInputField;
	
	@FindBy(id="input-password")
	private WebElement passwordInputField;
	
	@FindBy(css = "input[value='Login']")
	private WebElement loginBtn;
	
	@FindBy(css="div.alert.alert-danger,alert-dismissible")
	private WebElement alertMessageForUnsuccessfulLogin;
	
	@FindBy(css = "div.form-group a")
	private WebElement forgotPasswordLink;
	
	@FindBy(css = "div.alert")
	private WebElement passwordResetLinkText;

	
	public void enterEmail(String email) {
		emailIdInputField.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordInputField.sendKeys(password);
	}
	public void clickLoginBtn() {
		loginBtn.click();
	}

	
	public MyAccount loginToPortal(String email, String password) {
		
			enterEmail(email);
			enterPassword(password);
		    clickLoginBtn();
		    return new MyAccount();
			}
	
	public String unsuccessfulLoginMessage() {
		return alertMessageForUnsuccessfulLogin.getText();
	}
	public ForgotYourPassword clickForgotPassword() {
		forgotPasswordLink.click();
		return new ForgotYourPassword();
	}
	public String getPasswordResetLinkSuccessMessageText() {
		return passwordResetLinkText.getText();
	}

	

}
