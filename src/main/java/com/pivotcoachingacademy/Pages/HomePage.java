package com.pivotcoachingacademy.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pivotcoachingacademy.Base.TestBase;

public class HomePage extends TestBase {
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "li.dropdown>a>i")
	WebElement MyAccount;
	@FindBy(xpath = "//a[text()='Login']")
	WebElement Login;

	private void clickOnMyAccount() {
		MyAccount.click();
	}

	public LoginPage clickOnLogin() {
		clickOnMyAccount();
		Login.click();
		return new LoginPage();
	}
}