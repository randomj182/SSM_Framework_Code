package com.random.spring.ioc2.test;
/**
 * 实例工厂实例化
 * @author admin
 *
 */
public class Bean3Factory {
	public Bean3 getBean3(){
		System.out.println("bean3");
		return new Bean3();
	}
}
