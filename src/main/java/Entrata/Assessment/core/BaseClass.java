package Entrata.Assessment.core;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Entrata.Assessment.utils.Constants;

public class BaseClass {
	

	public static WebDriver driver;
    public static Logger log;
    

	@BeforeTest
	public void beforeTestMethod() {

		log = LogManager.getLogger(this.getClass());   
		//This line initializes a Logger instance for current class - Takes class dynamically
		// We can use log.info or log.dubug.  Choose log levels strategically - for any line needs logging
	}
	

	@SuppressWarnings("deprecation")
	@Parameters({ "browser" }) // We are passing browser name from testng.xml as parameter
	@BeforeMethod
	public void beforeMethodMethod(String browser) {
		
		log.info("Before driver setup");
		DriverManager.setupDriver(browser);
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void afterMethodMethod() {

		DriverManager.quitDriver();
		
	}
	// This metehod is to store screenshots in the screenshots folder in the project directory and get path for reports 
	public String captureScreen (String tname) throws IOException { 
		
        
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Timestamp to differentiate the each screenshot 
        String screenshotName = tname + "_" + timeStamp + ".png";
        String screenshotPath = System.getProperty("user.dir") + "/test-output/screenshots/" + screenshotName;
        
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(screenshotPath);
        
        // Ensure the directory exists
        destinationFile.getParentFile().mkdirs();
        
        FileUtils.copyFile(screenshot, destinationFile);
        return screenshotPath; //Returns the path of the screenshot
}


}
