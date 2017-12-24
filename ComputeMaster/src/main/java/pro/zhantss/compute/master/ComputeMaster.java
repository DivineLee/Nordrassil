package pro.zhantss.compute.master;

import org.redisson.api.RMap;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.api.listener.MessageListener;

import pro.zhantss.compute.api.ComputeNodeType;
import pro.zhantss.compute.api.exception.ComputeException;
import pro.zhantss.compute.api.master.ComputeTopic;
import pro.zhantss.compute.api.provider.ComputeInfo;
import pro.zhantss.compute.master.live.ClusterInfo;
import pro.zhantss.infom.api.exception.InfoMInterruptedException;
import pro.zhantss.infom.api.ha.HAMaster;
import pro.zhantss.log.api.Logger;

public class ComputeMaster implements HAMaster<ComputeTopic, ComputeHeartBeatListener> {

	private RedissonClient redisson;

	private ClusterInfo cluster;

	private RMap<String, ComputeInfo> compiles;

	private RMap<String, ComputeInfo> evals;

	public ComputeMaster() {
		super();
	}

	public ComputeMaster(RedissonClient redisson) {
		super();
		this.redisson = redisson;
	}

	@Override
	public void start() throws InfoMInterruptedException {
		
	}

	@Override
	public void publish(ComputeTopic topic) throws InfoMInterruptedException {
		try {
			RTopic<ComputeInfo> rt = redisson.getTopic(topic.getTopic());
			rt.addListener(new MessageListener<ComputeInfo>() {

				@Override
				public void onMessage(String channel, ComputeInfo info) {
					if (info != null && info.getStatus() != null) {
						ComputeNodeType cnt = info.getStatus().getType();
						Boolean ok = false;
						if (ComputeNodeType.COMPILE.equals(cnt)) {
							ok = compiles.fastPut(info.getStatus().identity(), info);
						} else if (ComputeNodeType.EVAL.equals(cnt)) {
							ok = evals.fastPut(info.getStatus().identity(), info);
						} else {
							// TODO stop remote compute node
							ok = false;
						}
						if (ok == false) {
							Logger.warn("compute node info is invalid, identity is {}",
									new ComputeException("compute node info is invalid"), info.getStatus().identity());
						} else {
							Logger.info("compute node pass, identity is {}", info.getStatus().identity());
						}
					}
				}
			});
		} catch (Exception e) {
			throw new InfoMInterruptedException(this.getClass() + ": publich Topic fail", e);
		}
	}

	@Override
	public Boolean listenHeartBeat(ComputeHeartBeatListener listener) {
		// TODO 自动生成的方法存根
		return null;
	}

	public RedissonClient getRedisson() {
		return redisson;
	}

	public void setRedisson(RedissonClient redisson) {
		this.redisson = redisson;
	}

}
