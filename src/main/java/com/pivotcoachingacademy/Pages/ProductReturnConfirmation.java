package com.pivotcoachingacademy.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pivotcoachingacademy.Base.TestBase;

public class ProductReturnConfirmation extends TestBase{
	public ProductReturnConfirmation() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div[id='content'] p:first-of-type")
	private WebElement thankYouMessage;
	
	public String getThankYouMessage() {
		return thankYouMessage.getText();
	}
}
