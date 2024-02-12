package com.pivotcoachingacademy.Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pivotcoachingacademy.Browsers.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriverWait wait;
	public static WebDriver driver;
	public Browsers DEFAULT_BROWSER = Browsers.EDGE;

	public void launchBrowser() {
		switch (DEFAULT_BROWSER) {
		case GOOGLE_CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Not a valid browser");
			break;
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Launch a page
		// driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		
	}

	public void quitBrowser() {
		// closing the browser
		driver.quit();
	}

}
