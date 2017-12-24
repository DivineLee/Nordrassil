package pro.zhantss.compute.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import pro.zhantss.compute.cache.Cache;

@Service
public class Compute {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Cacheable(value = Cache.CALCULATION, keyGenerator = "calculationKeyGenerator", unless="#result == null")
	public Object execute(Functor functor) {
		return this.execute(functor, true);
	}
	
	@Cacheable(value = Cache.CALCULATION, keyGenerator = "calculationKeyGenerator", unless="#result == null", condition="#cache == true")
	public Object execute(Functor functor, Boolean cache) {
		try {
			Expression expression = AviatorEvaluator.compile(functor.getExpression(), true);
			if(functor.getEnv().size() > 0) {
				return expression.execute(functor.getEnv());
			}
			return expression.execute();
		} catch (Exception e) {
			logger.error("execute error", e);
		}
		return null;
	}

}
