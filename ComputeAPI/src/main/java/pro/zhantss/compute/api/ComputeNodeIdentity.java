package pro.zhantss.compute.api;

import java.io.Serializable;

public class ComputeNodeIdentity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7780668595010981597L;

	private String protocol;

	private String host;

	private Integer port;

	private String token;

	private ComputeNodeType type;
	
	public String identity() {
		return this.protocol + "://" + this.host + ":" + this.port;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public ComputeNodeType getType() {
		return type;
	}

	public void setType(ComputeNodeType type) {
		this.type = type;
	}

}
