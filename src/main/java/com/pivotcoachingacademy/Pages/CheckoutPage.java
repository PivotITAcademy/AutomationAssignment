package com.pivotcoachingacademy.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.pivotcoachingacademy.Base.TestBase;

public class CheckoutPage extends TestBase {

	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='payment_address'][value='new']")
	WebElement newAddressRadioButton;
	@FindBy(css = "input[name='firstname']")
	WebElement firstname;
	@FindBy(css = "input[name='lastname']")
	WebElement lastname;
	@FindBy(css = "input[name='address_1']")
	WebElement address1;
	@FindBy(css = "input[name='city']")
	WebElement City;
	@FindBy(css = "input[name='postcode']")
	WebElement postalcode;
	@FindBy(css = "select[name='country_id']")
	WebElement country;
	@FindBy(css = "select[name='zone_id']")
	WebElement state;
	@FindBy(xpath = "(//input[@value='Continue'])[1]")
	WebElement continueButtonAfterBilling;
	@FindBy(xpath = "(//input[@value='Continue'])[2]")
	WebElement continueButtonAfterDelivery;
	@FindBy(xpath = "(//input[@value='Continue'])[3]")
	WebElement continueButtonAfterPayement;
	@FindBy(xpath = "(//input[@value='Continue'])[4]")
	WebElement continueButtonAfterShipping;
	@FindBy(xpath = "(//input[@type='radio'])[3]")
	WebElement radioButtonForDeliveryAddress;
	@FindBy(xpath = "(//input[@type='radio'])[5]")
	WebElement radioButtonForshippingRate;
	@FindBy(xpath = "(//input[@type='radio'])[6]")
	WebElement radioButtonForradioButton;
	@FindBy(css = "input[type='checkbox']")
	WebElement checkbox;
	@FindBy(css = "input[value='Confirm Order']")
	WebElement confirmOrder;
	@FindBy(css = "div[id='content']>p")
	WebElement successMessage;

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void selectNewAddressRadioButton() {
		newAddressRadioButton.click();
	}

	private void enterFirstname(String firstName) {
		firstname.sendKeys(firstName);
	}

	private void enterlastname(String lastName) {
		lastname.sendKeys(lastName);
	}

	private void enterAddress(String address) {
		address1.sendKeys(address);
	}

	private void enterCity(String city) {
		City.sendKeys(city);
	}

	private void enterPostalCode(String pCode) {
		postalcode.sendKeys(pCode);
	}

	private void selectCountry(String countryName) {
		country.click();
		Select select = new Select(country);
		select.selectByVisibleText(countryName);
	}

	private void selectState(String State) {
		state.click();
		Select select = new Select(state);
		select.selectByVisibleText(State);
	}

	public void fillDetails(String firstName, String lastName, String address, String city, String pCode,
			String CountryName, String State) {
		enterFirstname(firstName);
		enterlastname(lastName);
		enterAddress(address);
		enterCity(city);
		enterPostalCode(pCode);
		selectCountry(CountryName);
		selectState(State);
	}

	public boolean isDeliveryAddressRadioButtonSelected() {
		return radioButtonForDeliveryAddress.isSelected();
	}

	public boolean isShippingRateRadioButtonSelected() {
		return radioButtonForshippingRate.isSelected();
	}

	public boolean isPaymentMethodRadioButtonSelected() {
		return radioButtonForradioButton.isSelected();
	}

	public void clickOnContinueButtonafterfillingBillingDetails() {
		continueButtonAfterBilling.click();
		;
	}

	public void clickOnContinueButtonafterfillingDeliveryDetails() {
		continueButtonAfterDelivery.click();
		;
	}

	public void clickOnContinueButtonafterShippingDetails() {
		continueButtonAfterShipping.click();
	}

	public String getTextForSuccessMessage() {
		return successMessage.getText();
	}

	public void clickOnPaymentContinueButton() {
		clickOnContinueButtonafterfillingBillingDetails();
		clickOnContinueButtonafterfillingDeliveryDetails();
		continueButtonAfterPayement.click();
	}

	public void clickOnConfirmOrder() {
		clickOnPaymentContinueButton();
		checkbox.click();
		clickOnContinueButtonafterShippingDetails();
		confirmOrder.click();
	}

	public String getFirstName() {
		return firstname.getAttribute("value");
	}

	public String getLastName() {
		return lastname.getAttribute("value");
	}

	public String getAddress() {
		return address1.getAttribute("value");
	}

	public String getCity() {
		return City.getAttribute("value");
	}

	public String getPostalCode() {
		return postalcode.getAttribute("value");
	}

}
