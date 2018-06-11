package com.random.spring.aspectjaop.asxml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;

/**
 * 	切面类:就是切点与增强结合
 * 
 * @author random
 *
 */
@Aspect
public class MyAspectXML {
	// 前置通知
	public void before(){
		System.out.println("前置通知...");
	}
	// 后置通知
	public void afterReturing(Object returnVal){
		System.out.println("后置通知...返回值:"+returnVal);
	}
	// 环绕通知
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("环绕前增强....");
		Object result = proceedingJoinPoint.proceed();
		System.out.println("环绕后增强....");
		return result;
	}
	// 异常通知
	public void afterThrowing(Throwable e){
		System.out.println("异常通知..."+e.getMessage());
	}
	// 最终通知
	public void after(){
		System.out.println("最终通知....");
	}
}
