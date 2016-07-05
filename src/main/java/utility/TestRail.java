package utility;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import api.APIClient;
import api.APIException;

public class TestRail {
	String userName;
	String domain;
	String password;
	
	public TestRail(String domain,String userName,String password){
		this.userName = userName;
		this.domain = domain;
		this.password = password;
	}
	
	public void getCase(String id) throws MalformedURLException, IOException, APIException{
		APIClient client = new APIClient(domain);
		client.setUser(userName);
		client.setPassword(password);
		JSONObject c = (JSONObject) client.sendGet("get_case/"+id);
		System.out.println(c.toString());
//		System.out.println(c.get("title"));
	}
	
	@SuppressWarnings("unchecked")
	public void addResult(String id, String res) throws MalformedURLException, IOException, APIException{
		APIClient client = new APIClient(domain);
		client.setUser(userName);
		client.setPassword(password);
		Map data = new HashMap();
		data.put("status_id", new Integer(res));
		data.put("comment", "This test worked fine!");
		JSONObject r = (JSONObject) client.sendPost("add_result/"+id, data);
		System.out.println(r.toJSONString());
	}
	
}
