package pro.zhantss.compute.core;

import java.util.LinkedHashMap;

import com.google.common.collect.Maps;

public class Functor {
	
	private String expression;

	private LinkedHashMap<String, Object> env;

	public Functor() {
		this.env = Maps.newLinkedHashMap(); 
	}

	public Functor(String expression) {
		super();
		this.expression = expression;
	}

	public Functor(String expression, LinkedHashMap<String, Object> env) {
		super();
		this.expression = expression;
		this.env = Maps.newLinkedHashMap(env);
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public LinkedHashMap<String, Object> getEnv() {
		return env;
	}

	public void setEnv(LinkedHashMap<String, Object> env) {
		this.env = env;
	}

}
