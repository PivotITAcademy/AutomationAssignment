package com.pivotcoachingacademy.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pivotcoachingacademy.Base.TestBase;

public class OrderInformationPage extends TestBase {
	public OrderInformationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.buttons.clearfix a")
	WebElement continueBtn;

	@FindBy(css = "div.alert.alert-success.alert-dismissible")
	WebElement successBannerAfterReorder;

	@FindBy(css = "div.alert a:first-of-type")
	WebElement produtNameInSuccessBanner;

	@FindBy(css = "div.alert a:last-of-type")
	WebElement shoppingCartInSuccessBanner;

	@FindBy(css = "tfoot tr:first-of-type td:nth-of-type(3)")
	WebElement subTotalValue;

	@FindBy(css = "tfoot tr:last-of-type td:nth-of-type(3)")
	WebElement totalValue;

	@FindBy(css = "tfoot tr:nth-of-type(2) td:nth-of-type(3)")
	WebElement flatShippingRate;

	public void clickOnContinueBtn() {
		continueBtn.click();
	}

	public String getTextFromSuccessBannerAfterReorder() {
		return successBannerAfterReorder.getText();
	}

	public String getProductNameInSuccessBanner() {
		return produtNameInSuccessBanner.getText();
	}

	public String getShoppingCartInSuccessBanner() {
		return shoppingCartInSuccessBanner.getText();
	}

	public String getTextFromSubTotalValue() {
		return subTotalValue.getText();
	}
	
	public String getTextFromTotalValue() {
		return totalValue.getText();
	}
	
	public String getTextFromflatShippingRate() {
		return flatShippingRate.getText();
	}

	private static double subTotal = 0.0d;

	public String calcualteSubTotal(OrderInformation column) {
		List<WebElement> rowsInTable = driver.findElements(By.cssSelector("div.table-responsive tbody tr "));

		for (int i = 0; i < rowsInTable.size(); i++) {
			List<WebElement> cells = rowsInTable.get(i).findElements(By.cssSelector("td"));
			String productNameText = cells.get(0).getText();
			String price = getElementFromTheOrderDetailsTable(productNameText, column).getText();
			String priceWithoutDollarAndComma = price.replaceAll("[$,]", "");
			double newPrice = Double.parseDouble(priceWithoutDollarAndComma);
			subTotal = subTotal + newPrice;
		}
		// add comma to double value and convert it to string
		String strSubTotal = String.format("%,.2f", subTotal).toString();
		System.out.println("$" + strSubTotal);
		return "$" + strSubTotal;
	}

	public String calcualteTotal() {
		double flatShippingRate = Double.parseDouble(getTextFromflatShippingRate().replace("$", ""));
		double total = subTotal + flatShippingRate;
		System.out.println(subTotal);
		// add comma to double value and convert it to string
		String strTotal = String.format("%,.2f", total).toString();
		return ("$" + strTotal);
	}
	
	public WebElement getElementFromTheOrderDetailsTable(String productName, OrderInformation column) {

		int columnIndex = getIndexForColumn(column);

		List<WebElement> rowsInTable = driver.findElements(By.cssSelector("div.table-responsive tbody tr "));

		for (int i = 0; i < rowsInTable.size(); i++) {
			List<WebElement> cells = rowsInTable.get(i).findElements(By.cssSelector("td"));

			String productNameText = cells.get(0).getText();
			System.out.println(productNameText);

			if (productNameText.equals(productName)) {
				System.out.println(cells.get(columnIndex));
				return cells.get(columnIndex);
			}
		}

		System.out.println("Column name was not found!!!");
		return null;
	}

	public int getIndexForColumn(OrderInformation column) {
		List<WebElement> headers = driver.findElements(By.cssSelector("div.table-responsive thead tr td"));

		for (WebElement webElement : headers) {
			String headerText = webElement.getText();
			if (headerText.equals(column.getName())) {
				return headers.indexOf(webElement);
			}
		}
		System.out.println("Column does not exist.....");
		return -1;
	}

	public enum OrderInformation {

		ORDERDETAILS("Order Details"),
		PAYMENTADDRESS("Payment Address"),
		SHIPPINGADDRESS("Shipping Address"),
		PRODUCTNAME("Product Name"),
		MODEL("Model"),
		QUANTITY("Quantity"),
		PRICE("Price"),
		TOTAL("Total"),
		ACTION(""),
		DATEADDED("Date Added"),
		STATUS("Status"),
		COMMENT("Comment");

		String name;

		private OrderInformation(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	public void reorderProduct(String productName, OrderInformation column, By locator) {
		getElementFromTheOrderDetailsTable(productName, column).findElement(locator).click();
	}

	public ProductReturnsPage returnProduct(String productName, OrderInformation column, By locator) {
		getElementFromTheOrderDetailsTable(productName, column).findElement(locator).click();
		return new ProductReturnsPage();
	}

}
