package com.random.spring.ioc2.test;
/**
 * 静态工厂实例化
 * @author admin
 *
 */
public class Bean2Factory {
	public static Bean2 getBean2(){
		System.out.println("bean2");
		return new Bean2();
	}
}
