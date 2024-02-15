package com.pivotcoachingacademy.AutomationFramework.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.pivotcoachingacademy.Base.TestBase;
import com.pivotcoachingacademy.Pages.AccountLogin;
import com.pivotcoachingacademy.Pages.MyAccount;
import com.pivotcoachingacademy.Pages.Returns;
import com.pivotcoachingacademy.Pages.SideBar;
import com.pivotcoachingacademy.Pages.SideNavigationBarClass;
import com.pivotcoachingacademy.Pages.YourStore;

public class ReturnsTest extends TestBase {
	public YourStore yourStorePage;
	public AccountLogin loginPage;
	public MyAccount myAccountPage;
	public SideNavigationBarClass sideBarPage;
	public Returns returns;
	public Class<?> returningObjectPage;
	
	@BeforeMethod
	public void setUp() {
		launchBrowser();
		yourStorePage = new YourStore();
	}
	
	public void validateSideBarNavigationLink() {
		sideBarPage = new SideNavigationBarClass();
		yourStorePage.clickLoginBtn();
		loginPage = yourStorePage.clickLoginBtn();
		myAccountPage = loginPage.clickLoginBtn("nishatest123@gmail.com", "Password123");
		returningObjectPage=sideBarPage.getSideBarLinkfromCommonLocator(SideBar.Returns);
		returningObjectPage.cast(returns);
		
		Assert.assertEquals(driver.getTitle(), "My Wish List", "Wrong Page Loaded");
	}

	@AfterMethod
	public void quit() {
		quitBrowser();
	}
}
