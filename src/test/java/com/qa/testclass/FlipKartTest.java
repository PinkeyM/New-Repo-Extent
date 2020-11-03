package com.qa.testclass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.qa.base.TestBaseClass;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPageClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class FlipKartTest extends TestBaseClass  {
	LoginPageClass LoginObj;
	HomePage HomeObj;
	public ExtentReports extent;
	public ExtentTest extentTest;

	
	public FlipKartTest() throws IOException {
		super();
		
	}
	@BeforeTest
	public void extenttest() {
		extent= new ExtentReports(System.getProperty("user.dir")+"/test-output/extentreport.html", true);//here true means if any
		//existing file is there, it will replace by new file.
	extent.addSystemInfo("User Name", "PinkeyM");
	extent.addSystemInfo("OS" , "Windows 10");
	}
	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();
	}
	
	public static String screenshot(WebDriver driver, String screenshotname) throws Exception {
		String DateName= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());// here new Date() will current date
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination= System.getProperty("user.dir")+ "/FailedTestsScreenshots/"+screenshotname + DateName+".png";
		File finalDestination=  new File(destination);
		FileUtils.copyFile(source,finalDestination);
		return destination;
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		init();
		LoginObj= new LoginPageClass();
		}
	
	
	
	@Test
	public void titlename() {
		String tit=LoginObj.getTitle();
		System.out.println(tit);
		Assert.assertEquals(tit, " Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}	
			
	
	@AfterMethod
	public void tear(ITestResult result) throws Exception {
		if(result.getStatus()==ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "Test case is failed" +result.getName() );	// to add  name in extent report
			extentTest.log(LogStatus.FAIL, "Test case is failed" +result.getThrowable() );// to add error/exception in extent report
			String ScreenshotPath= FlipKartTest.screenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ScreenshotPath));// to add screenshot in extent report.
		}
		
		else if(result.getStatus()==ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test case skipped is" + result.getName());
			
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test case skipped is" + result.getName());
		}
		extent.endTest(extentTest);
		driver.close();
	}
	
}	


