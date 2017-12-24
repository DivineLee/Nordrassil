package pro.zhantss.compute.api.provider;

import pro.zhantss.compute.api.ComputeNodeIdentity;
import pro.zhantss.infom.api.Information;

public class ComputeInfo implements Information<ComputeNodeIdentity>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5076788570058043130L;
	
	private String name;
	
	private String description;
	
	private String host;

	private Integer pid;
	
	private ComputeNodeIdentity identity;

	@Override
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getHost() {
		return this.host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public Integer getPid() {
		return this.pid;
	}
	
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Override
	public ComputeNodeIdentity getStatus() {
		return this.identity;
	}
	
	public void setIdentity(ComputeNodeIdentity identity) {
		this.identity = identity;
	}

}
