package cabedoce.jira.xray.object;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class URIWrapperTest {

	@Test
	public void testUriWrapperConstructorNullParameters() {
		URIWrapper uriWrapper = new URIWrapper("http", "localhost", 8080, "rest/api/2/issuetype", null);

		
		assertTrue(uriWrapper.getHost().equalsIgnoreCase("localhost"));
	}
	
	@Test
	public void testUriWrapperConstructorURIHasScheme() {
		Map<String, String> parameters = new HashMap<>();
		parameters.put("key", "value");
		parameters.put("second", "thirst");
		URIWrapper uriWrapper = new URIWrapper("http", "localhost", 8080, "/rest/api/2/issuetype", parameters);
		
		assertTrue(uriWrapper.getURI().getScheme().equalsIgnoreCase("http"));
	}
	
	@Test
	public void testUriWrapperConstructorURIHasHost() {
		Map<String, String> parameters = new HashMap<>();
		parameters.put("key", "value");
		parameters.put("second", "thirst");
		URIWrapper uriWrapper = new URIWrapper("http", "localhost", 8080, "/rest/api/2/issuetype", parameters);
		
		assertTrue(uriWrapper.getURI().getHost().equalsIgnoreCase("localhost"));
	}
	
	@Test
	public void testUriWrapperConstructorURIHasPort() {
		Map<String, String> parameters = new HashMap<>();
		parameters.put("key", "value");
		parameters.put("second", "thirst");
		URIWrapper uriWrapper = new URIWrapper("http", "localhost", 8080, "/rest/api/2/issuetype", parameters);
		
		assertTrue(uriWrapper.getURI().getPort() == 8080);
	}
	
	@Test
	public void testUriWrapperConstructorURIHasPath() {
		Map<String, String> parameters = new HashMap<>();
		parameters.put("key", "value");
		parameters.put("second", "thirst");
		URIWrapper uriWrapper = new URIWrapper("http", "localhost", 8080, "/rest/api/2/issuetype", parameters);
		
		assertTrue(uriWrapper.getURI().getRawPath().equalsIgnoreCase("/rest/api/2/issuetype"));
	}
	
	@Test
	public void testUriWrapperConstructorURIHasParameters() {
		Map<String, String> parameters = new HashMap<>();
		parameters.put("key", "value");
		parameters.put("second", "thirst");
		URIWrapper uriWrapper = new URIWrapper("http", "localhost", 8080, "/rest/api/2/issuetype", parameters);
		
		assertTrue(uriWrapper.getURI().getRawQuery().equalsIgnoreCase("key=value&second=thirst"));
	}
	
}
