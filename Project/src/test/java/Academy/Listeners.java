package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;

public class Listeners extends base implements ITestListener {

	ExtentReports extent = ExtentReporterNG.getReportObject();
	ExtentTest test;
	//For parallel execution status in extent report we are providing below code 
	
	ThreadLocal<ExtentTest> extenttest1 = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) 
	
	{
		
	    test = extent.createTest(result.getMethod().getMethodName());
	    extenttest1.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		extenttest1.get().log(Status.PASS, "Test is passed wowww.super shankar.");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//failure logs will be retrieved and sent to extent report with variable "test"
		
		extenttest1.get().fail(result.getThrowable());
		
	//To get the driver also to get the screenshot(Below code can be used as reference)	
	WebDriver driver = null;
	
	//Getting the method name 
	
		String testmethodname =result.getMethod().getMethodName();
	
	try {
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (Exception e) 
	{
		
	}
	
	
	try {
		//To show the screenshot in the extent report 
		extenttest1.get().addScreenCaptureFromPath(getscreenshot(testmethodname,driver), result.getMethod().getMethodName());
		
		//To pass the failed method name to the base class to create the screenshot with failed method name .png
		
		
	
	} catch (IOException e) {
	
		e.printStackTrace();
	}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();

	}

		
	}
	
	
