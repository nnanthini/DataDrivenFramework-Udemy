package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base.BaseClass;

public class ListenerTest extends BaseClass implements ITestListener  {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("Listener Method - onTestStart "+result.getTestName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("Listener Method - onTestSuccess "+result.getName());
		Reporter.log("Test passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("Listener Method - onTestFailure "+result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}
	
}
