package mycode;

import java.io.IOException;
import java.net.MalformedURLException;



import api.APIException;
import utility.TestRail;

public class TestGet {
	public static void main(String[] args) throws MalformedURLException, IOException, APIException {
//		String domain = "https://fusemachines.testrail.net/";
//		String userName = "abiral@fusemachines.com";
//		String id = "39";
//		String password = "test123";
		String domain = "https://testabiral.testrail.net/";
		String userName = "abiral.okarin@gmail.com";
		String id = "1";
		String password = "test123";
		
		TestRail tr = new TestRail(domain,userName,password);
		tr.getCase(id);
		tr.addResult(id, "1");
	}	
	
}
