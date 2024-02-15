package com.pivotcoachingacademy.AutomationFramework.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.pivotcoachingacademy.Base.TestBase;
import com.pivotcoachingacademy.Pages.AccountLogin;
import com.pivotcoachingacademy.Pages.MyAccount;
import com.pivotcoachingacademy.Pages.SideBar;
import com.pivotcoachingacademy.Pages.YourStore;



public class MyAccountTest extends TestBase{
	public YourStore yourStorePage;
	public AccountLogin loginPage;
	public MyAccount myAccountPage;
	public SideBar sideBarPage;


	@BeforeMethod
	public void setUp() {
		launchBrowser();
		yourStorePage = new YourStore();
	}
	
	@AfterMethod
	public void quit() {
		quitBrowser();
	}
}
