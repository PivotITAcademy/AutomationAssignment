package com.pivotcoachingacademy.Utils;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.pivotcoachingacademy.Base.TestBase;

public class Utils extends TestBase {

	public static int getRandomInteger(int length) {
		Random random = new Random();
		return random.nextInt(length);
	}

	public static String getRandomString(int length) {
		return RandomStringUtils.random(length);
	}

	public static String getRandomEmail() {
		String suffix = RandomStringUtils.random(5);
		return "testemail_" + suffix + "@gmail.com";
	}

	public static String getRandomPassword() {
		return "Password" + new Random().nextInt(1);
	}

	public static Date getCurrentTime() {
		return new Date();
	}

	public void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void takeScreenshot(String testName) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		// wrapping driver with takescreenshot interface and then calling
		// getScreenshotAs method which takes type of output as argument which is file
		// type
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// copying file from random memory to the local memory(we are storing in folder
			// name FailedTestScreenShots
			FileUtils.copyFile(screenshotFile,
					new File("./FailedTestScreenShots\\" + testName + "_" + timeStamp + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void datePicker(WebElement orderDateButton,WebElement datePickerPopUp,WebElement datePcikerMonthAndYear,WebElement datePcikerLeftArrow, WebElement datePcikerRightArrow,String tarDate,String formatDate) {
		Calendar cal = Calendar.getInstance();
		String targetDate = tarDate;
		//date in the format "yyyy-MMM-dd"
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatDate);
		orderDateButton.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(datePickerPopUp));
		try {
			dateFormat.setLenient(false);
			Date formatedDate = dateFormat.parse(targetDate);
			cal.setTime(formatedDate);
			int tarDay = cal.get(Calendar.DAY_OF_MONTH);
			int tarMonth = cal.get(Calendar.MONTH);
			int tarYear = cal.get(Calendar.YEAR);
			String monthAndYearFromPicker =datePcikerMonthAndYear.getText();
			cal.setTime(new SimpleDateFormat("MMM yyyy").parse(monthAndYearFromPicker));
			int actMonth = cal.get(Calendar.MONTH);
			int actYear = cal.get(Calendar.YEAR);
			while(tarMonth<actMonth || tarYear<actYear) {
				datePcikerLeftArrow.click();
				monthAndYearFromPicker =datePcikerMonthAndYear.getText();
				cal.setTime(new SimpleDateFormat("MMM yyyy").parse(monthAndYearFromPicker));
				actMonth = cal.get(Calendar.MONTH);
				actYear = cal.get(Calendar.YEAR);
			}
			while(tarMonth>actMonth || tarYear>actYear) {
				datePcikerRightArrow.click();
				monthAndYearFromPicker =datePcikerMonthAndYear.getText();
				cal.setTime(new SimpleDateFormat("MMM yyyy").parse(monthAndYearFromPicker));
				actMonth = cal.get(Calendar.MONTH);
				actYear = cal.get(Calendar.YEAR);
			}
			driver.findElement(By.xpath("//div[@class='datepicker-days']//td[not(contains(@class,'old') or contains(@class,'new')) and contains(text(),"
					+ tarDay + ")]")).click();

		} catch (ParseException e) {
			System.out.println("Invalid Date is provided");
			e.printStackTrace();
		}
	}
}
