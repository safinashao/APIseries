package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	// GET Method
	
	public void get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault(); //this method creates client connection
		HttpGet httpget = new HttpGet(url); //get request:this method will create get connection with this part. url
		CloseableHttpResponse httpResponse = httpClient.execute(httpget); //hit the GET URL
		
		//Status code
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		System.out.println("print status code: " + statusCode);
		
//		//convert responseString to an object
		
		String responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");//utf-8 is standard, must be used
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("complete response: " + responseJson);
		
		//all headers
		Header[] headerArray = httpResponse.getAllHeaders();
		//iterate the Array in HashMap cause it stores it in Key Value Pair/Format
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for(Header header : headerArray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("Headers Array-->"+allHeaders);
		
	}
	

}
