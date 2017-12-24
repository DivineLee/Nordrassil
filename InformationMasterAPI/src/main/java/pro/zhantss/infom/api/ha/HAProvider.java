package pro.zhantss.infom.api.ha;

import java.io.Serializable;

import pro.zhantss.infom.api.Provider;

public interface HAProvider<T extends Serializable> extends Provider<T> {
	
	public Boolean heartbeat(HertBeat<T> hb);

}
