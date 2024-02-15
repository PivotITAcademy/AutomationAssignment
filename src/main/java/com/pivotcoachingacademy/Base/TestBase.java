package com.pivotcoachingacademy.Base;


import java.time.Duration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pivotcoachingacademy.Browsers.Browsers;

public class TestBase {

	public static WebDriverWait wait;

	protected Properties properties = new Properties();

	public static WebDriver driver;
	public Browsers DEFAULT_BROWSER = Browsers.EDGE;

	public void launchBrowser() {
		switch (DEFAULT_BROWSER) {
		case GOOGLE_CHROME:
			driver = new ChromeDriver();
			break;

		case EDGE:
			driver = new EdgeDriver();
			break;

		case FIREFOX:
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Not a valid browser");
			break;
		}

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		try {
			FileInputStream fileInputStream = new FileInputStream("config.properties");
			//loading file data with Properties object
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Launch a page
		 driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		
	}

	public void quitBrowser() {
		// closing the browser
		driver.quit();
	}

}
