package com.random.spring.aopProxy.CGLib;
/**
 * CGLib代理机制:对类生成代理
 * 		不需要导包,在spring-core-4.2.4.RELEASE.jar核心包中已集成了CGLib
 * @author random
 *
 */
public class ProductDAO {
	public void add(){
		System.out.println("增加商品...");
	}
	public void update(){
		System.out.println("修改商品...");
	}
}
