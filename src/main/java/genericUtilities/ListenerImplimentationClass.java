package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * this class provides implementation to ITestListnerinterface of TestNG
 * 
 * @author Namrata
 *
 */
public class ListenerImplimentationClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"====Test execution started==");
		test=report.createTest(testScriptName);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"====passed==");
		test.log(Status.PASS, testScriptName+"====passed==");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"====failed==");
		test.log(Status.FAIL, testScriptName+"====failed==");
		test.log(Status.INFO,result.getThrowable());
		
		//screenshoot
		String screenShotName = testScriptName + new javaFileUtilities().getSystemDate();
		//exception for failure
		System.out.println(result.getThrowable());
		
		webDriverUtilities w=new webDriverUtilities();
		try {
			String path = w.takeScreenShot(BaseClass.sdriver, screenShotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"====skipped==");
		
		test.log(Status.SKIP, testScriptName+"====skipped==");
		test.log(Status.INFO,result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("====suite execution started==");
		ExtentSparkReporter html = new ExtentSparkReporter(".\\ExtendsReports\\Report-"+new javaFileUtilities().getSystemDate()+".html");
		//ExtentSparkReporter html = new ExtentSparkReporter(".\\ExtentReport\\Report-"+new javaFileUtilities().getSystemDate()+".html");
		
		html.config().setTheme(Theme.DARK);
		html.config().setDocumentTitle("Execution Report");
		html.config().setReportName("vtiger Execution Report");
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("Base Browser", "Firefox");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter name", "Namrata");
		
		
		
		
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("====suite execution finished==");
		//report generation
		report.flush();
		
	}

}
