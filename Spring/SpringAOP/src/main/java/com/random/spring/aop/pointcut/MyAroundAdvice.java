package com.random.spring.aop.pointcut;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 增强的类:
 * 	 使用的是环绕增强:功能最强,即可充当前置增强、后置增强
 * @author random
 *
 */
public class MyAroundAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		System.out.println("环绕前增强");
		// 执行目标对象的方法
		Object result = methodInvocation.proceed();		
		System.out.println("环绕后增强");
		return result;
	}

}
