package utility;

import api.APIClient;

public class TestRail {
	
	public TestRail(String domain,String userName,String password){
		APIClient client = new APIClient(domain);
		client.setUser(userName);
		client.setPassword(password);		
	}
	
	
}
