package pro.zhantss.compute.cache;

import org.redisson.spring.cache.CacheConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value="classpath:cache.yml", factory=pro.zhantss.support.resource.YamlPropertyLoaderFactory.class)
@ConfigurationProperties(prefix="compute.cache")
public class Cache {

	private CacheConfig calculation;

	private CacheConfig remote;

	private CacheConfig usually;
	
	public final static String CALCULATION = "CALCULATION";
	public final static String REMOTE = "REMOTE";
	public final static String USUALLY = "USUALLY";

	public Cache() {
		super();
	}

	public CacheConfig getCalculation() {
		return calculation;
	}

	public void setCalculation(CacheConfig calculation) {
		this.calculation = calculation;
	}

	public CacheConfig getRemote() {
		return remote;
	}

	public void setRemote(CacheConfig remote) {
		this.remote = remote;
	}

	public CacheConfig getUsually() {
		return usually;
	}

	public void setUsually(CacheConfig usually) {
		this.usually = usually;
	}

}
