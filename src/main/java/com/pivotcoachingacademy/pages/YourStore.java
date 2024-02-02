package com.pivotcoachingacademy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pivotcoachingacademy.Base.TestBase;

public class YourStore extends TestBase{
	
	public YourStore() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountBtn;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginBtn;
	
	public YourStore clickMyAccountBtn() {
		myAccountBtn.click();
		return new YourStore();
	}
	
	public AccountLogin clickLoginBtn() {
		loginBtn.click();
		return new AccountLogin();
	}
	

}
