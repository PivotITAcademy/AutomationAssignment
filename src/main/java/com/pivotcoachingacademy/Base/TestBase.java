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

public class TestBase {
	protected Properties prop;
	FileInputStream fileInputStream;
	public TestBase() {
		prop=new Properties();
		try {
			fileInputStream = new FileInputStream("./src\\test\\java\\com\\pivotcoachingcademy\\config\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
		prop.load(fileInputStream);}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver driver;
	public Browsers DEFAULT_BROWSER = Browsers.EDGE;

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
