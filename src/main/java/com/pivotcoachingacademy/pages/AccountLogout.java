package com.pivotcoachingacademy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pivotcoachingacademy.Base.TestBase;

public class AccountLogout extends TestBase {
	public AccountLogout() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div#content>h1")
	private WebElement accountLogoutText;
	
	@FindBy(css="#column-right>div>a:first-of-type")
	private WebElement sideNavLoginBtn;
	
	public String getTextForAccountLogout() {
		return accountLogoutText.getText();
	}
	
	public AccountLogin clickOnSideNavLogin() {
		sideNavLoginBtn.click();
		return new AccountLogin();
	}

}
