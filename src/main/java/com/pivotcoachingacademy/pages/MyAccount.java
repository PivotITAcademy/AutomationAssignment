package com.pivotcoachingacademy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pivotcoachingacademy.Base.TestBase;

public class MyAccount extends TestBase {
	public MyAccount() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "#content>h2:first-of-type")
	WebElement myAccountText;
	
	@FindBy(xpath="//span[text()=\"My Account\"]")
	private WebElement myAccountBtn;
	
	@FindBy(css="ul.dropdown-menu.dropdown-menu-right>li:nth-of-type(5)>a")
	private WebElement logoutBtn;
	
	public String getMyAccountText() {
		return myAccountText.getText();
	}
	
	public void clickMyAccountBtn() {
		myAccountBtn.click();
	}
	public AccountLogout clickLogoutBtn() {
		logoutBtn.click();
		return new AccountLogout();
	}
	

}
