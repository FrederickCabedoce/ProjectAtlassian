package cabedoce.jira.xray.rest;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import cabedoce.jira.xray.object.IssueType;

public class IssueTypeControllerTest {
	
	@Test
	public void testFetchIssueType() throws ClientProtocolException, IOException {
		IssueTypeController issueTypeController = new IssueTypeController();
		
		List<IssueType> issueTypes = issueTypeController.getIssueTypes();
		
		issueTypes.forEach(k -> {
			System.out.println(k.getName());
		});
	}

}
