package com.pivotcoachingacademy.Base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.pivotcoachingacademy.Browsers.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public Browsers DEFAULT_BROWSER = Browsers.GOOGLE_CHROME;
	private FileInputStream fileInputStream;
	protected Properties prop;
	
	public TestBase() {
		prop=new Properties();
		try {
			fileInputStream = new FileInputStream("./src\\main\\java\\com\\pivotcoachingacademy\\config\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
		prop.load(fileInputStream);}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void launchBrowser() {
		switch (DEFAULT_BROWSER) {
		case GOOGLE_CHROME:
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case EDGE:
			//WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case FIREFOX:
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Not a valid browser");
			break;
		}

		driver.manage().window().maximize();

		// Launch a page
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");

	}

	public void quitBrowser() {
		// closing the browser
		driver.close();
	}

}
