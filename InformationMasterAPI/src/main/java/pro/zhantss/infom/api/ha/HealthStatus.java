package pro.zhantss.infom.api.ha;

public enum HealthStatus {
	
	OK,
	
	WARNING,
	
	FAULT,
	
	/**
	 * PUSH FROM CLUSTER MASTER
	 */
	OFFLINE

}
