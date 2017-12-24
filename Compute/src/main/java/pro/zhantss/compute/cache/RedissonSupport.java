package pro.zhantss.compute.cache;

import java.io.IOException;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonSupport {

	@Bean
	public RedissonClient redisson() throws IOException {
		//Config config = Config.fromYAML(this.getClass().getClassLoader().getResourceAsStream("redisson.yml"));
		Config config = Config.fromYAML(this.getClass().getClassLoader().getResourceAsStream("redisson2.yml"));
		return Redisson.create(config);
	}

}
