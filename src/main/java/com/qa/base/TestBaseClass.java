package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public TestBaseClass() throws IOException {
		prop= new Properties();
		FileInputStream ip= new FileInputStream("C:\\Users\\Pinkeym\\Java Testing\\ExtentReportScreeshots\\src\\main\\java\\com\\qa\\config\\config.properties");
		prop.load(ip);
	}
	public static void init() {
		String browsername=prop.getProperty("Browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pinkeym\\Documents\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(prop.getProperty("URL"));
			System.err.println(":aaded");
			
		}
	}
	

}
