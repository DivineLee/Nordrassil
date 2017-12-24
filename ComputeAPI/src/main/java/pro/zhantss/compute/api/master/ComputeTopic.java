package pro.zhantss.compute.api.master;

import pro.zhantss.infom.api.Topic;

public class ComputeTopic implements Topic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8901479321881711847L;

	private String topic;

	public ComputeTopic() {
		super();
	}

	public ComputeTopic(String topic) {
		super();
		this.topic = topic;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

}
