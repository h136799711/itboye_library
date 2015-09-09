package com.itboye.network;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Request;

public class HttpClient {

	public HttpClient() {
		
	}
	
	
	
	public static String post(String url,List<NameValuePair> params) throws ClientProtocolException, IOException{
		
		
		HttpEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
		String content = Request.Post(url)
		.version(HttpVersion.HTTP_1_1)
		.body(entity)
		.execute().returnContent().asString();
		
		return content;
		
	}
	
}
