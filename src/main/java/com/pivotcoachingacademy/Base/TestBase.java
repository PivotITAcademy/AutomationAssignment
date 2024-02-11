package com.pivotcoachingacademy.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.pivotcoachingacademy.Browsers.Browsers;

public class TestBase {
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
		try {
			FileInputStream fileInputStream = new FileInputStream("config.properties");
			//loading file data with Properties object
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		// Launch a page
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");

	}

	public void quitBrowser() {
		// closing the browser
		driver.close();
	}

}
