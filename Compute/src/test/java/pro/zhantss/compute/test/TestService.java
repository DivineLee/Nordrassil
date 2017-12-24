package pro.zhantss.compute.test;

import java.util.Map;

import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import pro.zhantss.compute.cache.Cache;

@Service
public class TestService {
	
	@Autowired
	private RedissonClient clinet;
	
	public void test() {
		Map<String, String> map = clinet.getMap(Cache.USUALLY);
		map.put("name", "redisson.redis");
		System.out.println(map.get("name"));
	}
	
	public void test2() {
		Map<String, String> map = clinet.getMap(Cache.USUALLY);
		map.put("name2", "redisson.redis2");
		System.out.println(map.get("name2"));
	}
	
	public void test3() {
		RMap<String, Author> map = clinet.getMap(Cache.USUALLY);
		map.put("zhantss", new Author("詹立新", "man", 25));
		System.out.println(map.get("zhantss"));
	}
	
	@Cacheable(value=Cache.USUALLY, key="#name")
	public Author get(String name) {
		return new Author(name, "man", 25);
	}

}
