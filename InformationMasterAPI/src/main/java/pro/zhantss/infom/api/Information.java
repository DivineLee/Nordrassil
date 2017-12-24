package pro.zhantss.infom.api;

import java.io.Serializable;

public interface Information<T extends Serializable> extends Serializable {
	
	public String getName();
	
	public String getDescription();
	
	public String getHost();
	
	public Integer getPid();
	
	public T getStatus();

}
