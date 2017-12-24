package pro.zhantss.compute.master.live;

import org.redisson.api.annotation.REntity;
import org.redisson.api.annotation.RId;

@REntity
public class ClusterInfo {
	
	@RId
	private String id;
	
	private String compiles;
	
	private String evals;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompiles() {
		return compiles;
	}

	public void setCompiles(String compiles) {
		this.compiles = compiles;
	}

	public String getEvals() {
		return evals;
	}

	public void setEvals(String evals) {
		this.evals = evals;
	}
	
}
