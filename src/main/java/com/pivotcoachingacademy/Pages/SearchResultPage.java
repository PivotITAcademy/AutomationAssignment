package com.pivotcoachingacademy.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pivotcoachingacademy.Base.TestBase;

public class SearchResultPage extends TestBase {
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[id='list-view']")
	WebElement listViewButton;
	@FindBy(xpath= "(//span[text()='Add to Cart'])[1]")
	WebElement addtocartbuttonforItemFirst;
	@FindBy(xpath= "(//span[text()='Add to Cart'])[2]")
	WebElement addtocartbuttonforItemSecond;
	@FindBy(xpath= "(//span[text()='Add to Cart'])[3]")
	WebElement addtocartbuttonforItemThird;
	@FindBy(css= "div[class='alert alert-success alert-dismissible']")
	WebElement successfulAddToCartMessage;
	@FindBy(xpath= "//span[text()='Checkout']")
	WebElement checkout;

	public boolean isListButtonDisplayed() {
		listViewButton.isDisplayed();
		return true;

	}
	public void clickOnAddToCartButton() {
		addtocartbuttonforItemFirst.click();
	}
	public void addMoreItems() {
		addtocartbuttonforItemSecond.click();
		addtocartbuttonforItemThird.click();
	}
	public String getTextofSuccessMessage() {
		return successfulAddToCartMessage.getText();
	}
	public CheckoutPage clickOnCheckout() {
		checkout.click();
		return new CheckoutPage();
	}
}