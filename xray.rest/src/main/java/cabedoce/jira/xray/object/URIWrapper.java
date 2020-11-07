package cabedoce.jira.xray.object;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;

public class URIWrapper  {

	private URI uri;
	
	private String scheme;
	
	private String host;
	
	private int port;
	
	private String path;
	
	private Map<String, String> parameters;
	
	private static Logger logger = Logger.getLogger(URIWrapper.class);

	public URIWrapper(String scheme, String host, int port, String path, Map<String, String> parameters) {
		this.scheme = scheme;
		this.host = host;
		this.port = port;
		this.path = path;
		this.parameters = parameters;
		buildURI();
	}
	
	public URIWrapper(String url) {
		this.uri = URI.create(url);
	}
	
	private void buildURI(){
		URIBuilder uriBuilder = new URIBuilder();
		uriBuilder.setScheme(scheme);
		uriBuilder.setHost(host);
		uriBuilder.setPort(port);
		uriBuilder.setPath(path);
		getParameters().forEach((k,v) -> {
			uriBuilder.setParameter(k, v);
		});
		try {
			this.uri = uriBuilder.build();
		} catch (URISyntaxException e) {
			logger.error("Error while trying to build URI.");
			e.printStackTrace();
		}
	}
	
	public URI getURI() {
		return uri;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
		buildURI();
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
		buildURI();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
		buildURI();
	}

	public Map<String, String> getParameters() {
		if(parameters == null) {
			parameters = new HashMap<String,String>();
		}
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
		buildURI();
	}
	
	
	
}
