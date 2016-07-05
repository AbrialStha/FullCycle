package utility;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import api.APIException;

public class Listners implements ITestListener {
	String domain = "https://testabiral.testrail.net/";
	String userName = "abiral.okarin@gmail.com";
	String password = "test123";
	TestRail tr = new TestRail(domain,userName,password);
	Helper helper = new Helper();

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("The execution of the main test starts now :"+result.getName());
		System.out.println("------------------------------------------------------");
		System.out.println( result.toString() );
		System.out.println("---------------------------------------------------------");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// This is calling the printTestResults method
		try {
			printTestResults(result);
		} catch (IOException | APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// This is calling the printTestResults method
		try {
			printTestResults(result);
		} catch (IOException | APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		try {
			printTestResults(result);
		} catch (IOException | APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("------------------------------------------------------");
		System.out.println( result.toString() );
		System.out.println("---------------------------------------------------------");

	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("About to begin executing Test " + context.getName(), true);

	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("Completed executing test " + context.getName(), true);
		System.out.println("------------------------------------------------------");
		System.out.println( context.toString() );
		System.out.println("---------------------------------------------------------");

	}

	// This will provide the information on the test

	private void printTestResults(ITestResult result) throws MalformedURLException, IOException, APIException {
		String id;
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
			
			id = Helper.getTestId( result.getName() );
			
			/**
			 * addResult(id,res) and 1 is for pass
			 */
			tr.addResult(id, "1");
			
			break;

		case ITestResult.FAILURE:

			status = "Failed";
			
			id = Helper.getTestId( result.getName() );
			
			/**
			 * addResult(id,res) and 5 is for fail
			 */
			tr.addResult(id, "5");

			break;

		case ITestResult.SKIP:

			status = "Skipped";

		}

		Reporter.log("Test Status: " + status, true);

	}

}
