package cabedoce.http;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import cabedoce.jira.xray.object.URIWrapper;

public class HttpRequest {
	
	private URIWrapper uriWrapper;
	
	private HttpGet httpGet;
	
	public HttpRequest(String uri) {
		uriWrapper = new URIWrapper(uri);
	}
	
	public void sendRequest() {
		
	}

}
