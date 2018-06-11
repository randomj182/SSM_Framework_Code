package com.random.spring.aopProxy.CGLib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * 使用CGLib生成代理对象:如果一个类没有实现接口,就使用CGLib代理
 * @author random
 *
 */
public class CGLibProxy implements MethodInterceptor {
	private ProductDAO productDAO;

	public CGLibProxy(ProductDAO productDAO) {
		super();
		this.productDAO = productDAO;
	}
	public ProductDAO createProductDAO(){
		// 使用CGLib生成代理:
		// 1.创建核心类
		Enhancer enhancer = new Enhancer();
		// 2.为其设置父类
		enhancer.setSuperclass(productDAO.getClass());
		// 3.设置回调
		enhancer.setCallback(this);
		// 4.创建代理
		return (ProductDAO)enhancer.create();
	}
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		if("add".equals(method.getName())){
			//记录日志
			System.out.println("记录日志........");
			// 调用父类
			Object result = methodProxy.invokeSuper(proxy, args);
			return result;
		}
		return methodProxy.invokeSuper(proxy, args);
	}
	
	
	
}
