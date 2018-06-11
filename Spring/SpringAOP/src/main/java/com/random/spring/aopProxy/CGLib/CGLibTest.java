package com.random.spring.aopProxy.CGLib;

import org.junit.Test;

public class CGLibTest {
	@Test
	// 常规方法测试
	public void demo1(){
		ProductDAO productDAO = new ProductDAO();
		productDAO.add();
		productDAO.update();
	}
	
	@Test
	// 常规方法测试
	public void demo2(){
		ProductDAO productDAO = new ProductDAO();
		ProductDAO proxy = new CGLibProxy(productDAO).createProductDAO();
		proxy.add();
		proxy.update();
	}
}
