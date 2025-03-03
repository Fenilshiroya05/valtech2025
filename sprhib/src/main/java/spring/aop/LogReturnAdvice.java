package spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LogReturnAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object retValue, Method method, Object[] args, Object tar) throws Throwable {
		System.out.println("Method = "+method.getName()+" Returned "+retValue);
	}

}
