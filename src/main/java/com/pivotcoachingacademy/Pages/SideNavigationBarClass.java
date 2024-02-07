package com.pivotcoachingacademy.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pivotcoachingacademy.Base.TestBase;

public class SideNavigationBarClass extends TestBase {
	public SideNavigationBarClass() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "div[class='list-group'] a")
	private WebElement sideBarCommonLocator;
	
	public Class<?> getSideBarLinkfromCommonLocator(SideBar page) {
		List<WebElement> sideBarList = null;
		try {
			sideBarList = driver.findElements((By) sideBarCommonLocator);

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		for (WebElement element : sideBarList) {
			if (element.getText().equals(page.getPageName())) {
				element.click();
				return page.getPageClass();
			}
		}
		return null;

	}
}
