package com.pivotcoachingacademy.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.pivotcoachingacademy.Base.TestBase;
import com.pivotcoachingacademy.pages.YourStore;

public class YourStoreTest extends TestBase {
	YourStore yourStore;
	
	@BeforeMethod
	public void setUp() {
		launchBrowser();
		yourStore = new YourStore();
	}

	

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}

}
