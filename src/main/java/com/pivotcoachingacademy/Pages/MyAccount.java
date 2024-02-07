package com.pivotcoachingacademy.Pages;

import org.openqa.selenium.support.PageFactory;

import com.pivotcoachingacademy.Base.TestBase;

public class MyAccount extends TestBase{
	public MyAccount() {
		PageFactory.initElements(driver, this);
	}
	
public void clickOnSideBarReturnPage() {
	//SideBar.getPageUsingText("Returns")
}
}
