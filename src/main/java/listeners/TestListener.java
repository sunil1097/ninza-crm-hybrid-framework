package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.ninza.crm.base.utility.BaseTest;
import com.ninza.crm.generic.utility.ScreenShotUtility;

public class TestListener implements ITestListener {
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("test suit started ");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
	String testName =result.getMethod().getMethodName();
	WebDriver driver = BaseTest.sdriver;
	
	String screenshotPath = ScreenShotUtility.takeScreenShot(driver,testName);
	Reporter.log(testName+ "Failed",true);
	Reporter.log("screenShotSaved at :"+ screenshotPath, true);
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}



}
