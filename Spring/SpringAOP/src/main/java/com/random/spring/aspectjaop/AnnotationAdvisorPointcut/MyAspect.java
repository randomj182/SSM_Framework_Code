package com.random.spring.aspectjaop.AnnotationAdvisorPointcut;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 	切面类:就是切点与增强结合
 * 
 * 
 * 第三步:使用AspectJ注解形式:分别是以下5点及这一点
 * @DeclareParents 引介通知，相当于IntroductionInterceptor (不要求掌握)
 * @author random
 *
 */
@Aspect
public class MyAspect {
	/**此处使用前置增强:
	 *    	@Before 前置通知，相当于BeforeAdvice
	 *    	* 就在方法之前执行.没有办法阻止目标方法执行的.
	 *    
	 *    注:JoinPoint打印value值...
	 */
	@Before("execution(* com.random.spring.aspectjaop.UserDAO.add(..))")
	public void before(JoinPoint joinPoint){
		System.out.println("前置增强..."+joinPoint);
	}
	/**
	 * 	@AfterReturning 后置通知，相当于AfterReturningAdvice
	 * 		后置通知,获得方法返回值.
	 * 
	 * 		注:returning中的参数必须与方法传入的参数相同
	 * @param returnVal
	 */
	@AfterReturning(value="execution(* com.random.spring.aspectjaop.UserDAO.update(..))",returning="returnVal")
	public void afterReturn(Object returnVal){
		System.out.println("后置增强...方法的返回值"+returnVal);
	}
	
	/**
	 * @Around 环绕通知，相当于MethodInterceptor
	 * 		在可以方法之前和之后来执行的,而且可以阻止目标方法的执行.
	 * @param proceedingJoinPoint
	 * @throws Throwable 
	 */
	@Around(value="execution(* com.random.spring.aspectjaop.UserDAO.find(..))")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("环绕前增强...");
		Object result = proceedingJoinPoint.proceed();
		System.out.println("环绕后增强...");
		return result;
	}
	
	/**
	 * @AfterThrowing抛出通知，相当于ThrowAdvice
	 * 
	 */
	@AfterThrowing(value="MyAspect.myPointcut()",throwing="e")
	public void afterThrowing(Throwable e){
		System.out.println("不好了,异常了..."+e.getMessage());
	}
	
	/**
	 * @After 最终final通知，不管是否异常，该通知都会执行
	 * 
	 */
	@After("MyAspect.myPointcut()")
	public void after(){
		System.out.println("最终通知");
	}
	/**
	 * 切点的定义
	 */
	@Pointcut(value="execution(* com.random.spring.aspectjaop.UserDAO.find(..))")
	private void myPointcut(){
	}
	
	/** Advisor和Aspect的区别?
	* 		Advisor:Spring传统意义上的切面:支持一个切点和一个通知的组合.
	* 		Aspect:可以支持多个切点和多个通知的组合.
	* */
}
