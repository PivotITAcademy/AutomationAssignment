package com.pivotcoachingacademy.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pivotcoachingacademy.Base.TestBase;

public class MyAccountPage extends TestBase {
	public MyAccountPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "div[id='content']>h2:first-of-type")
	WebElement myAccountHeading;
	@FindBy(css = "input[name='search']")
	WebElement searchInput;
	@FindBy(css = "i[class='fa fa-search']")
	WebElement searchbutton;
	public String getTextOfHeading() {
		return myAccountHeading.getText();
	}

	public SearchResultPage enterSearchInput(String searchText) {
		searchInput.sendKeys(searchText);
		searchbutton.click();
		return new SearchResultPage();
	}

}
