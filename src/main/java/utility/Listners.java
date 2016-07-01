package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("The execution of the main test starts now :"+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// This is calling the printTestResults method
		printTestResults(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// This is calling the printTestResults method
		printTestResults(result);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		printTestResults(result);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("About to begin executing Test " + context.getName(), true);

	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("Completed executing test " + context.getName(), true);

	}

	// This will provide the information on the test

	private void printTestResults(ITestResult result) {

		Reporter.log("Test Method resides in "
				+ result.getTestClass().getName(), true);

		if (result.getParameters().length != 0) {

			String params = null;

			for (Object parameter : result.getParameters()) {

				params += parameter.toString() + ",";

			}

			Reporter.log(
					"Test Method had the following parameters : " + params,
					true);

		}

		String status = null;

		switch (result.getStatus()) {

		case ITestResult.SUCCESS:

			status = "Pass";

			break;

		case ITestResult.FAILURE:

			status = "Failed";

			break;

		case ITestResult.SKIP:

			status = "Skipped";

		}

		Reporter.log("Test Status: " + status, true);

	}

}
