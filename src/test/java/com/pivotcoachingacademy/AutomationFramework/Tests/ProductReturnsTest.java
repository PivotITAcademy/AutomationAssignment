package com.pivotcoachingacademy.AutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pivotcoachingacademy.Base.TestBase;
import com.pivotcoachingacademy.Pages.ProductReturnConfirmation;
import com.pivotcoachingacademy.Pages.ProductReturns;


public class ProductReturnsTest extends TestBase {
//	public YourStore yourStorePage;
//	public AccountLogin loginPage;
//	public MyAccount myAccountPage;
//	public SideBar sideBarPage;
	public ProductReturns productReturnPage;
	public ProductReturnConfirmation productReturnConfirmPage;
	@BeforeMethod
	public void setUp() {
		launchBrowser();
		productReturnPage = new ProductReturns();
	}

	@Test
	public void validateFirstNameWithValidInput() {
		productReturnConfirmPage=productReturnPage.inputDataToFieldsAndSubmit("Nisha", "Mohandas", "nisha@gmail.com", "123456789", "14568", "iphone", "KL3FR");
		Assert.assertEquals(productReturnConfirmPage.getThankYouMessage(), "Thank you for submitting your return request. Your request has been sent to the relevant department for processing.","Wrong Message");
	}

	@Test
	public void validateFirstNameWithEmptyInput() {
		String errorMsg=productReturnPage.getFirstNameValidationErrorMessage("", "Mohandas", "nisha@gmail.com", "123456789", "14568", "iphone", "KL3FR");
		Assert.assertEquals(errorMsg, "First Name must be between 1 and 32 characters!");
	}

	@Test
	public void validateFirstNameWithCharacterLimit() {
		String errorMsg=productReturnPage.getFirstNameValidationErrorMessage("bdskbdksbksbckbzcbzkbckzncksdfhdhfdckjdbfjkchsdkjfhkjdshfkjdhfjkdhfkjdsjkvbdjkbckjsdbcjk", "Mohandas", "nisha@gmail.com", "123456789", "14568", "iphone", "KL3FR");
		Assert.assertEquals(errorMsg, "First Name must be between 1 and 32 characters!");
	}



	@Test
	public void validateLastNameWithValidInput() {
		productReturnConfirmPage=productReturnPage.inputDataToFieldsAndSubmit("Nisha", "Mohandas", "nisha@gmail.com", "123456789", "14568", "iphone", "KL3FR");
		Assert.assertEquals(productReturnConfirmPage.getThankYouMessage(), "Thank you for submitting your return request. Your request has been sent to the relevant department for processing.","Wrong Message");
	}

	@Test
	public void validateLastNameWithEmptyInput() {
		String errorMsg=productReturnPage.getLastNameValidationErrorMessage("Nisha", "", "nisha@gmail.com", "123456789", "14568", "iphone", "KL3FR");
		Assert.assertEquals(errorMsg, "Last Name must be between 1 and 32 characters!");
	}

	@Test
	public void validateLastNameWithCharacterLimit() {
		String errorMsg=productReturnPage.getLastNameValidationErrorMessage("Nisha","bdskbdksbksbckbzcbzkbckzncksdfhdhfdckjdbfjkchsdkjfhkjdshfkjdhfjkdhfkjdsjkvbdjkbckjsdbcjk", "nisha@gmail.com", "123456789", "14568", "iphone", "KL3FR");
		Assert.assertEquals(errorMsg, "Last Name must be between 1 and 32 characters!");
	}


	@Test
	public void validateEmailAddressWithValidInput() {
		productReturnConfirmPage=productReturnPage.inputDataToFieldsAndSubmit("Nisha", "Mohandas", "nisha@gmail.com", "123456789", "14568", "iphone", "KL3FR");
		Assert.assertEquals(productReturnConfirmPage.getThankYouMessage(), "Thank you for submitting your return request. Your request has been sent to the relevant department for processing.","Wrong Message");
	}

	@Test
	public void validateEmailAddressWithEmptyInput() {
		String errorMsg=productReturnPage.getEmailValidationErrorMessage("Nisha", "Mohandas", "", "123456789", "14568", "iphone", "KL3FR");
		Assert.assertEquals(errorMsg, "E-Mail Address does not appear to be valid!");
	}

	@Test
	public void validateEmailAddressWithInvalidFormat() {
		String errorMsg=productReturnPage.getEmailValidationErrorMessage("Nisha", "Mohandas", "bdjsdbjksahfckjashfckjasfkjcsajkfcaskbcksajkbjk", "123456789", "14568", "iphone", "KL3FR");
		Assert.assertEquals(errorMsg, "E-Mail Address does not appear to be valid!");
	}

	@Test
	public void validateTelephoneNumberWithValidInput() {
		productReturnConfirmPage=productReturnPage.inputDataToFieldsAndSubmit("Nisha", "Mohandas", "nisha@gmail.com", "123456789", "14568", "iphone", "KL3FR");
		Assert.assertEquals(productReturnConfirmPage.getThankYouMessage(), "Thank you for submitting your return request. Your request has been sent to the relevant department for processing.","Wrong Message");
	}

	@Test
	public void validateTelephoneNumberWithEmptyInput() {
		String errorMsg=productReturnPage.getTelephoneValidationErrorMessage("Nisha", "Mohandas", "test@gmail.com","", "14568", "iphone", "KL3FR");
		Assert.assertEquals(errorMsg, "Telephone must be between 3 and 32 characters!");
	}

	@Test
	public void validateTelephoneNumberWithInvalidFormat() {
		String errorMsg=productReturnPage.getTelephoneValidationErrorMessage("Nisha", "Mohandas", "test@gmail.com","bdjsdbjksahfckjashfckjasfkjcsajkfcaskbcksajkbjk", "14568", "iphone", "KL3FR");
		Assert.assertEquals(errorMsg, "Telephone must be between 3 and 32 characters!");
	}

	@Test
	public void validateOrderIdWithValidInput() {
		productReturnConfirmPage=productReturnPage.inputDataToFieldsAndSubmit("Nisha", "Mohandas", "nisha@gmail.com", "123456789", "14568", "iphone", "KL3FR");
		Assert.assertEquals(productReturnConfirmPage.getThankYouMessage(), "Thank you for submitting your return request. Your request has been sent to the relevant department for processing.","Wrong Message");
	}

	@Test
	public void validateOrderIdWithEmptyInput() {
		String errorMsg=productReturnPage.getOrderIdValidationErrorMessage("Nisha", "Mohandas", "test@gmail.com","123456789", "", "iphone", "KL3FR");
		Assert.assertEquals(errorMsg, "Order ID required!");
	}

	@Test
	public void validateProductNameWithValidInput() {
		productReturnConfirmPage=productReturnPage.inputDataToFieldsAndSubmit("Nisha", "Mohandas", "nisha@gmail.com", "123456789", "14568", "iphone", "KL3FR");
		Assert.assertEquals(productReturnConfirmPage.getThankYouMessage(), "Thank you for submitting your return request. Your request has been sent to the relevant department for processing.","Wrong Message");
	}

	@Test
	public void validateProductNameWithEmptyInput() {
		String errorMsg=productReturnPage.getProductNameValidationErrorMessage("Nisha", "Mohandas", "test@gmail.com","123456789", "14568", "", "KL3FR");
		Assert.assertEquals(errorMsg, "Product Name must be greater than 3 and less than 255 characters!");
	}

	@Test
	public void validateProductNameWithCharacterLimit() {
		String errorMsg=productReturnPage.getProductNameValidationErrorMessage("Nisha", "Mohandas", "test@gmail.com","123456789", "14568", "fjksdhfkjdsgkdsfgvisdgfviuwesicugedcgbjhedgbcjwgedcfjgedbcjh", "KL3FR");
		Assert.assertEquals(errorMsg, "Product Name must be greater than 3 and less than 255 characters!");
	}


	@Test
	public void validateProductCodeWithValidInput() {
		productReturnConfirmPage=productReturnPage.inputDataToFieldsAndSubmit("Nisha", "Mohandas", "nisha@gmail.com", "123456789", "14568", "iphone", "KL3FR");
		Assert.assertEquals(productReturnConfirmPage.getThankYouMessage(), "Thank you for submitting your return request. Your request has been sent to the relevant department for processing.","Wrong Message");
	}

	@Test
	public void validateProductCodeWithEmptyInput() {
		String errorMsg=productReturnPage.getProductCodeValidationErrorMessage("Nisha", "Mohandas", "test@gmail.com","123456789", "14568", "iPhone", "");
		Assert.assertEquals(errorMsg, "Product Model must be greater than 3 and less than 64 characters!");
	}

	@Test
	public void validateReasonForReturnWithNoSelection() {
		String errorMsg=productReturnPage.getProductReturnReasonErrorMessage("Nisha", "Mohandas", "test@gmail.com","123456789", "14568", "iPhone", "KL3FR");
		Assert.assertEquals(errorMsg, "You must select a return product reason!");
	}

	@AfterMethod
	public void quit() {
		quitBrowser();
	}
}
