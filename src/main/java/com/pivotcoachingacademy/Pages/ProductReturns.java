package com.pivotcoachingacademy.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pivotcoachingacademy.Base.TestBase;

public class ProductReturns extends TestBase {
	public ProductReturns() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameTxtBx;

	@FindBy(id = "input-lastname")
	private WebElement lastNameTxtBx;
	@FindBy(id = "input-email")
	private WebElement emailTxtBx;
	@FindBy(id = "input-telephone")
	private WebElement telephoneTxtBx;
	@FindBy(id = "input-order-id")
	private WebElement orderIdTxtBx;
	@FindBy(id = "input-date-ordered")
	private WebElement orderDateSelectionBx;
	@FindBy(id = "input-product")
	private WebElement productNameTxtBx;
	@FindBy(id = "input-model")
	private WebElement productCodeTxtBx;
	@FindBy(id = "input-quantity")
	private WebElement quantityTxtBx;
	@FindBy(css = "form[class='form-horizontal']>fieldset:nth-of-type(2)>div:nth-of-type(4) div[class='radio']:nth-of-type(1) input")
	private WebElement deadOnArrivalRadioBtn;
	@FindBy(css = "form[class='form-horizontal']>fieldset:nth-of-type(2)>div:nth-of-type(4) div[class='radio']:nth-of-type(2) input")
	private WebElement faultyPleaseSupplyDetailsRadioBtn;
	@FindBy(css = "form[class='form-horizontal']>fieldset:nth-of-type(2)>div:nth-of-type(4) div[class='radio']:nth-of-type(3) input")
	private WebElement orderErrorRadioBtn;
	@FindBy(css = "form[class='form-horizontal']>fieldset:nth-of-type(2)>div:nth-of-type(4) div[class='radio']:nth-of-type(4) input")
	private WebElement otherPleaseSupplyDetailsRadioBtn;
	@FindBy(css = "form[class='form-horizontal']>fieldset:nth-of-type(2)>div:nth-of-type(4) div[class='radio']:nth-of-type(5) input")
	private WebElement receivedWrongItemRadioBtn;
	@FindBy(css = "form[class='form-horizontal']>fieldset:nth-of-type(2)>div:nth-of-type(5)>div>label:first-of-type")
	private WebElement yesRadioBtn;
	@FindBy(css = "form[class='form-horizontal']>fieldset:nth-of-type(2)>div:nth-of-type(5)>div>label:last-of-type")
	private WebElement NoRadioBtn;
	@FindBy(css = "form[class='form-horizontal']>fieldset:nth-of-type(2)>div:nth-of-type(6) textarea")
	private WebElement faultyTextArea;
	@FindBy(css = "input[value='Submit']")
	private WebElement submitBtn;

//ErrorMessage WebElements
	@FindBy(css = "form[class='form-horizontal']>fieldset:nth-of-type(1)>div:first-of-type>div>div")
	private WebElement firstNameErrorMsg;
	@FindBy(css = "form[class='form-horizontal']>fieldset:nth-of-type(1)>div:nth-of-type(2)>div>div")
	private WebElement lastNameErrorMsg;
	@FindBy(css = "form[class='form-horizontal']>fieldset:nth-of-type(1)>div:nth-of-type(3)>div>div")
	private WebElement emailIdErrorMsg;
	@FindBy(css = "form[class='form-horizontal']>fieldset:nth-of-type(1)>div:nth-of-type(4)>div>div")
	private WebElement telephoneErrorMsg;
	@FindBy(css = "form[class='form-horizontal']>fieldset:nth-of-type(1)>div:nth-of-type(5)>div>div")
	private WebElement orderIdErrorMsg;
	@FindBy(css = "form[class='form-horizontal']>fieldset:nth-of-type(2)>div:nth-of-type(1)>div>div")
	private WebElement productNameErrorMsg;
	@FindBy(css = "form[class='form-horizontal']>fieldset:nth-of-type(2)>div:nth-of-type(2)>div>div")
	private WebElement productCodeErrorMsg;
	@FindBy(css = "form[class='form-horizontal']>fieldset:nth-of-type(2)>div:nth-of-type(4) div:nth-of-type(6)")
	private WebElement resonErrorMsg;

	public void enterFirstName(String firstName) {
		firstNameTxtBx.sendKeys(firstName);
	}

	public void enterLastName(String lstName) {
		lastNameTxtBx.sendKeys(lstName);
	}

	public void enterEmailId(String email) {
		emailTxtBx.sendKeys(email);
	}

	public void enterTelephoneNumber(String telephone) {
		telephoneTxtBx.sendKeys(telephone);
	}

	public void enterOrderId(String orderId) {
		orderIdTxtBx.sendKeys(orderId);
	}

	public void enterOrderDate(String date) {
		orderDateSelectionBx.sendKeys(date);
	}

	public void enterProductName(String productName) {
		productNameTxtBx.sendKeys(productName);
	}

	public void enterProductCode(String code) {
		productCodeTxtBx.sendKeys(code);
	}

	public void enterQuantity(String quantity) {
		quantityTxtBx.sendKeys(quantity);
	}

	public void enterFaultyOrOtherReason(String reason) {
		faultyTextArea.sendKeys(reason);
	}

	public void clickOnDeadOnArrivalRadioBtn() {
		deadOnArrivalRadioBtn.click();
	}

	public void clickOnFaultyPleaseSupplyDetailsRadioBtn() {
		faultyPleaseSupplyDetailsRadioBtn.click();
	}

	public void clickOnOrderErrorRadioBtn() {
		orderErrorRadioBtn.click();
	}

	public void clickOnOtherPleaseSupplyDetailsRadioBtn() {
		otherPleaseSupplyDetailsRadioBtn.click();
	}

	public void clickOnReceivedWrongItemRadioBtn() {
		receivedWrongItemRadioBtn.click();
	}

	public void clickOnYesRadioBtn() {
		yesRadioBtn.click();
	}

	public void clickOnNoRadioBtn() {
		NoRadioBtn.click();
	}

	public void clickOnSubmitBtn() {
		submitBtn.submit();
	}

	public String getFirstNameValidationErrorMessage(String firstName, String lastname, String email, String telephone,
			String orderId, String productName, String productCode) {
		inputDataToFieldsAndSubmit(firstName, lastname, email, telephone, orderId, productName, productCode);
		return firstNameErrorMsg.getText();
	}

	public String getLastNameValidationErrorMessage(String firstName, String lastname, String email, String telephone,
			String orderId, String productName, String productCode) {
		inputDataToFieldsAndSubmit(firstName, lastname, email, telephone, orderId, productName, productCode);
		return lastNameErrorMsg.getText();
	}

	public String getEmailValidationErrorMessage(String firstName, String lastname, String email, String telephone,
			String orderId, String productName, String productCode) {
		inputDataToFieldsAndSubmit(firstName, lastname, email, telephone, orderId, productName, productCode);
		return emailIdErrorMsg.getText();
	}

	public String getTelephoneValidationErrorMessage(String firstName, String lastname, String email, String telephone,
			String orderId, String productName, String productCode) {
		inputDataToFieldsAndSubmit(firstName, lastname, email, telephone, orderId, productName, productCode);
		return telephoneErrorMsg.getText();
	}

	public String getOrderIdValidationErrorMessage(String firstName, String lastname, String email, String telephone,
			String orderId, String productName, String productCode) {
		inputDataToFieldsAndSubmit(firstName, lastname, email, telephone, orderId, productName, productCode);
		return orderIdErrorMsg.getText();
	}

	public String getProductNameValidationErrorMessage(String firstName, String lastname, String email,
			String telephone, String orderId, String productName, String productCode) {
		inputDataToFieldsAndSubmit(firstName, lastname, email, telephone, orderId, productName, productCode);
		return productNameErrorMsg.getText();
	}

	public String getProductCodeValidationErrorMessage(String firstName, String lastname, String email,
			String telephone, String orderId, String productName, String productCode) {
		inputDataToFieldsAndSubmit(firstName, lastname, email, telephone, orderId, productName, productCode);
		return productCodeErrorMsg.getText();
	}



	public String getProductReturnReasonErrorMessage(String firstName, String lastname, String email,
			String telephone, String orderId, String productName, String productCode) {
		enterFirstName(firstName);
		enterLastName(lastname);
		enterEmailId(email);
		enterTelephoneNumber(telephone);
		enterOrderId(orderId);
		enterProductName(productName);
		enterProductCode(productCode);
		clickOnYesRadioBtn();
		clickOnSubmitBtn();
		return resonErrorMsg.getText();
	}

	public ProductReturnConfirmation inputDataToFieldsAndSubmit(String firstName, String lastname, String email,
			String telephone, String orderId, String productName, String productCode) {
		enterFirstName(firstName);
		enterLastName(lastname);
		enterEmailId(email);
		enterTelephoneNumber(telephone);
		enterOrderId(orderId);
		enterProductName(productName);
		enterProductCode(productCode);
		clickOnDeadOnArrivalRadioBtn();
		clickOnYesRadioBtn();
		clickOnSubmitBtn();
		return new ProductReturnConfirmation();
	}
}
