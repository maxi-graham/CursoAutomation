package com.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private enum browsers {
		FIREFOX, CHROME
	};
	
	public static WebDriver LevantarBrowser (String browserName, String URL) {
		WebDriver driver = null; 
		switch (browsers.valueOf(browserName)) {
		case CHROME:{
			System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		case FIREFOX:{
			System.setProperty("webdriver.gecko.driver", "C:/driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		default: {
			System.out.println("Browser equivocado");
			System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		}
		driver.get(URL);
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void cerrarBrowser (WebDriver driver) {
		driver.quit();
	}
}
