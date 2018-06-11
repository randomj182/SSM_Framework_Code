package com.random.spring.aop.nopointcut;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
/**
 * 第三步:编写增强的代码:(前置增强)
 * @author random
 *
 */
public class MyBeforeAdvice implements MethodBeforeAdvice{

	@Override
	/**
	 * method:执行的方法
	 * args:参数
	 * target:目标对象
	 */
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("前置增强....");
	}

}
