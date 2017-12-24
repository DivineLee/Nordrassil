package pro.zhantss.infom.api.ha;

public interface HertBeat<T> {
	
	public HealthStatus getStatus();
	
	public T with();

}
