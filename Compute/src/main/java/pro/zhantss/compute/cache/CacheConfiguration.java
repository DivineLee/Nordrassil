package pro.zhantss.compute.cache;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.redisson.api.RedissonClient;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pro.zhantss.compute.core.Functor;

@Configuration
@EnableCaching
public class CacheConfiguration {

	@Autowired
	private Cache cache;

	private static String defaultGenerator(Object target, Method method, Object... params) {
		StringBuilder sb = new StringBuilder();
		sb.append(target.getClass().getName());
		sb.append(method.getName());
		for (Object obj : params) {
			sb.append(obj.toString());
		}
		return sb.toString();
	}

	@Bean
	public KeyGenerator calculationKeyGenerator() {
		return new org.springframework.cache.interceptor.KeyGenerator() {
			
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuilder sb = new StringBuilder();
				if("pro.zhantss.compute.core.Compute.execute".equals(target.getClass().getName() + "." +  method.getName())) {
					try {
						Functor functor = (Functor) params[0];
						String exp = functor.getExpression();
						LinkedHashMap<String, Object> envs = functor.getEnv();
						if(exp != null) {
							sb.append(exp.toString());
						}
						if(envs != null) {
							Iterator<Entry<String, Object>> it = envs.entrySet().iterator();
							sb.append("[");
							while(it.hasNext()) {
								Entry<String, Object> e = it.next();
								sb.append(e.getKey());
								sb.append("=");
								sb.append(e.getValue() == null ? "" : e.getValue().toString());
								if(it.hasNext()) sb.append(",");
							}
							sb.append("]");
						}
						return sb.toString();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				return CacheConfiguration.defaultGenerator(target, method, params);
			}
		};
	}

	@Bean
	public CacheManager cacheManager(RedissonClient redisson) {
		Map<String, CacheConfig> config = new HashMap<String, CacheConfig>();
		// config.put("skvmap", new CacheConfig(24*60*1000, 12*60*1000));
		// config.put("anymap", new CacheConfig(24*60*1000, 12*60*1000));
		config.put(Cache.CALCULATION, cache.getCalculation());
		config.put(Cache.REMOTE, cache.getRemote());
		config.put(Cache.USUALLY, cache.getUsually());
		return new RedissonSpringCacheManager(redisson, config);
	}

}
