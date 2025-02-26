package spring.aop;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.aop.MethodBeforeAdvice;

import antlr.collections.List;

public class CounterAdvice implements MethodBeforeAdvice{
	
	private Map<String,Integer> counters; 
	
	

	public Map<String, Integer> getCounters() {
		return counters;
	}

	public void setCounters(Map<String, Integer> counters) {
		this.counters = counters;
	}

	public void any() {
		System.out.println("Counters Intializing...");
		counters = new HashMap<String, Integer>();
	}
	
	public void any1() {
		System.out.println("Counters ="+counters);
		//counters = new HashMap<String, Integer>();
	}


	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Method = "+method.getName()+" With args = "+ Arrays.toString(args));
		String methodName = method.getName();
		if(counters.containsKey(methodName)) {
			counters.put(methodName, counters.get(methodName)+1);
		}else {
			counters.put(methodName,1);
		}
	}

}
