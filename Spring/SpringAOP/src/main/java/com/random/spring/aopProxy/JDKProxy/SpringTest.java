package com.random.spring.aopProxy.JDKProxy;
import org.junit.Test;
public class SpringTest {
	@Test
	// 常规方法
	public void demo1(){
		UserDAO userDAO = new UserDAOImpl();
		userDAO.add();
		userDAO.update();
	}
	
	@Test
	// 生成JDK动态代理对象测试
	public void demo2(){
		UserDAO userDAO = new UserDAOImpl();
		UserDAO proxy = new JDKProxy(userDAO).createUserDAO();
		proxy.add();
		proxy.update();
	}
	
}
