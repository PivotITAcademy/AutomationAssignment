package com.pivotcoachingacademy.Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pivotcoachingacademy.Base.TestBase;

public class OrderHistoryPage extends TestBase {

	public OrderHistoryPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "tr:first-of-type a")
	WebElement viewLink;

	@FindBy(css = "div.buttons.clearfix a")
	WebElement continueBtn;

	public MyAccountPage clickOnContinueBtn() {
		continueBtn.click();
		return new MyAccountPage();
	}

	public WebElement getElementFromTheOrderHistoryTable(String orderId, OrderHistory column) {

		int columnIndex = getIndexForColumn(column);

		List<WebElement> rowsInTable = driver
				.findElements(By.cssSelector("table.table.table-bordered.table-hover tbody tr"));

		for (int i = 0; i < rowsInTable.size(); i++) {
			List<WebElement> cells = rowsInTable.get(i).findElements(By.cssSelector("td"));

			String orderIdText = cells.get(0).getText();

			if (orderIdText.equals(orderId)) {
				return cells.get(columnIndex);
			}
		}

		System.out.println("Column name was not found!!!");
		return null;
	}

	public int getIndexForColumn(OrderHistory column) {
		List<WebElement> headers = driver
				.findElements(By.cssSelector("table.table.table-bordered.table-hover thead tr td"));

		for (WebElement webElement : headers) {
			String headerText = webElement.getText();
			if (headerText.equals(column.getOrderId())) {
				return headers.indexOf(webElement);
			}
		}
		System.out.println("Column does not exist.....");
		return -1;
	}

	public enum OrderHistory {

		ORDERID("Order ID"),
		CUSTOMER("Customer"),
		NUMBEROFPRODUCTS("No. of Products"),
		STATUS("Status"),
		TOTAL("Total"),
		DATEADDED("Date Added"),
		ACTION("");

		String orderID;

		private OrderHistory(String orderID) {
			this.orderID = orderID;
		}

		public String getOrderId() {
			return orderID;
		}
	}
	public OrderInformationPage clickOnViewLink(String orderId, OrderHistory column, By locator) {
		getElementFromTheOrderHistoryTable(orderId, column).findElement(locator).click();
		return new OrderInformationPage();
	}
}
