package pro.zhantss.infom.api.ha;

import pro.zhantss.infom.api.Master;
import pro.zhantss.infom.api.Topic;

public interface HAMaster<T extends Topic, K extends HeartBeatListener> extends Master<T> {
	
	public Boolean listenHeartBeat(K listener);

}
