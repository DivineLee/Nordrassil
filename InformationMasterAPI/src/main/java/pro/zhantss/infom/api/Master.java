package pro.zhantss.infom.api;

import pro.zhantss.infom.api.exception.InfoMInterruptedException;

public interface Master<T extends Topic> {

	public void start() throws InfoMInterruptedException;

	public void publish(T topic) throws InfoMInterruptedException;

}
