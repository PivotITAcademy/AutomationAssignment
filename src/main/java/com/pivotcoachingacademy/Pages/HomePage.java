package com.pivotcoachingacademy.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pivotcoachingacademy.Base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccountDropDown;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement registerLink;

	@FindBy(xpath = "//a[text()='Login']")
	WebElement loginLink;

	public void openDropDown() {
		myAccountDropDown.click();
	}

	public AccountLoginPage clickLoginLink() {
		openDropDown();
		loginLink.click();
		return new AccountLoginPage();
	}

}
