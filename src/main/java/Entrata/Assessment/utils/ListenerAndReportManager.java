package Entrata.Assessment.utils;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Entrata.Assessment.core.BaseClass;

public class ListenerAndReportManager implements ITestListener, IAnnotationTransformer {

		public ExtentSparkReporter sparkReporter; 
		public static ExtentReports extent;
		public ExtentTest logger;
		
		public String reportName;
		public Method testMethod;
		

		@Override
		public void transform(ITestAnnotation annotation, @SuppressWarnings("rawtypes") Class testClass, @SuppressWarnings("rawtypes") Constructor testConstructor, Method testMethod) {

			// Configure test retries using the RetryAnalyzer
			annotation.setRetryAnalyzer(RetryAnalyzer.class);
		}
		
		
		@Override
		public void onStart(ITestContext context) {
			 
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(0));
			
			reportName = "Test-Report - " + timeStamp + ".html" ;

			//Creates an ExtentSparkReporter instance, specifying the path to the HTML report file.
			sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/ExtentReport.html");
			sparkReporter.config().setDocumentTitle("Automation assesemnt");
			sparkReporter.config().setReportName("Automation tests results by Prathamesh");
			sparkReporter.config().setTheme(Theme.DARK);

			//Creates an ExtentReports instance and attaches the previously configured ExtentSparkReporter.
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Application", "Landing Page Entrata");
			extent.setSystemInfo("Environment", "Production");
			extent.setSystemInfo("User Name", System.getProperty("user.name"));

			// Getting the os & browser from the TestNG.xml file
			String os = context.getCurrentXmlTest().getParameter("os");
			extent.setSystemInfo("OS", os);

			String browser = context.getCurrentXmlTest().getParameter("browser");
			extent.setSystemInfo("Browser", browser);

		}
		
		//This method will execute on test failure.
		@Override
		public void onTestFailure(ITestResult result) {
			
			// Create ExtentTest for the current test case with name and status markup
			logger = extent.createTest("Test case method : " + result.getName());
			
			//// Log failure details if the test case failed in Red colour in reports
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test case failed " , ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test case failed " , ExtentColor.RED));

			// Captures a screenshot and adds it to the extent report
			try {
				String imgPath = new BaseClass().captureScreen(result.getName());
				logger.addScreenCaptureFromPath(imgPath);
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		
		
		// This method will execute on test skip.
		@Override
		public void onTestSkipped(ITestResult result) {
			
			logger = extent.createTest("Test case method : " + result.getName());
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test case skipped ", ExtentColor.ORANGE));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test case failed " , ExtentColor.ORANGE));

			try {
				String imgPath = new BaseClass().captureScreen(result.getName());
				logger.addScreenCaptureFromPath(imgPath);
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		
		// This method will execute on test success.
		@Override
		public void onTestSuccess(ITestResult result) {

			logger = extent.createTest("Test case method : " + result.getName());
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test case passed ", ExtentColor.GREEN));

			try {
				String imgPath = new BaseClass().captureScreen(result.getName());
				logger.addScreenCaptureFromPath(imgPath);
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		
         // This method will run after all tests complete.
		@Override
		public void onFinish(ITestContext context) {

			//Completes the test report generation process.
			extent.flush();
			
		}	
		

}
