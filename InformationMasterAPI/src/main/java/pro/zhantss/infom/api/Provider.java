package pro.zhantss.infom.api;

import java.io.Serializable;

public interface Provider<T extends Serializable> {

	public Boolean push(Information<T> information);

}
