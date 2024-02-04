package com.pivotcoachingacademy.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pivotcoachingacademy.Base.TestBase;

public class ProductReturnsPage extends TestBase {
	public ProductReturnsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.radio:last-of-type input")
	WebElement radioBtnForReasonOfReturn;
	
	@FindBy(css = "input[type='submit']")
	WebElement submitBtn;

	@FindBy(css = "#content p:first-of-type")
	WebElement successMessageAfterProductReturn;
	
	public void clickOnRadioBtn() {
		radioBtnForReasonOfReturn.click();
	}

	public void clickOnSubmitBtn() {
		submitBtn.submit();
	}

	public String getTextFromSuccessMessageAfterProductReturn() {
		return successMessageAfterProductReturn.getText();
	}

}
