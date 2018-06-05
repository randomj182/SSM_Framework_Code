package com.random.spring.ioc1.test;
/**
 * 入门案例HelloService的实现类
 * @author random
 *
 */
public class HelloServiceImpl implements HelloService {
	private String info;
	@Override 
	public void sayHello() {
		System.out.println("Hello Spring  " + info);
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

}
