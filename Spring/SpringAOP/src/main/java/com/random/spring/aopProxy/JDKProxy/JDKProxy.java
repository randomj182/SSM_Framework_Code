package com.random.spring.aopProxy.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理:对实现了接口的类生成代理
 * 使用JDK动态代理机制生成动态代理对象
 * @author random
 *
 */
public class JDKProxy implements InvocationHandler {
	private UserDAO userDAO;

	public JDKProxy(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}
	public UserDAO createUserDAO(){
		UserDAO proxy = (UserDAO)Proxy.newProxyInstance(userDAO.getClass()
				.getClassLoader(), userDAO.getClass().getInterfaces(), this);
		return proxy;	
	}
	@Override
	//调用目标对象的任何一个方法都相当于调用invoke方法();
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if("add".equals(method.getName())){
			//记录日志
			System.out.println("记录日志...");
			Object result = method.invoke(userDAO, args);
			return result;
		}
		return method.invoke(userDAO, args);
	}
	
	
	
}
