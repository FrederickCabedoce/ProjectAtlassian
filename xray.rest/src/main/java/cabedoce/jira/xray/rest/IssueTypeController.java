package cabedoce.jira.xray.rest;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Base64;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cabedoce.jira.xray.object.IssueType;
import cabedoce.jira.xray.object.URIWrapper;

public class IssueTypeController {

	public List<IssueType> getIssueTypes() throws ClientProtocolException, IOException {
		List<IssueType> issueTypes = null;
		String credentials = Base64.getEncoder().encodeToString(("etownage:p2kjo10__").getBytes());
		URIWrapper uriWrapper = new URIWrapper("http", "localhost", 8080, "/rest/api/2/issuetype", null);
		HttpGet httpGet = new HttpGet(uriWrapper.getURI());
		httpGet.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + credentials);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = httpclient.execute(httpGet);

		try {
			HttpEntity entity = response.getEntity();
			if (entity != null) {

				Type founderListType = new TypeToken<List<IssueType>>() {}.getType();
				Gson gson = new Gson();
				issueTypes = (List<IssueType>) gson.fromJson(EntityUtils.toString(entity), founderListType);
			}
		} finally {
			response.close();
		}

		return issueTypes;
	}

	
}
