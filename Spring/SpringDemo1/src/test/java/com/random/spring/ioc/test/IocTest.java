package com.random.spring.ioc.test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.random.spring.ioc1.test.HelloService;
import com.random.spring.ioc1.test.HelloServiceImpl;

public class IocTest {
	@Test
	// 传统方式-----造成程序紧密耦合
	public void ioc1Test1(){
		HelloService helloService = new HelloServiceImpl();
		helloService.sayHello();
	}
	@Test
	// Spring开发
	public void ioc1Test2(){
		// 创建一个工厂类
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		HelloService service = (HelloService)applicationContext.getBean("HelloService");
		service.sayHello();
	}
	
	@Test
	/** ApplicationContext类继承了BeanFactory
	 *  BeanFactory延迟加载,使用到这个类,getBean()方法的时候才加载
	 *  ApplicationContext类加载文件的 时候,就创建的了所有类
	 */
	public void Ioc1Test3(){
		// 创建一个工厂类
		BeanFactory factory  = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		HelloService service = (HelloService)(factory.getBean("HelloService"));
		service.sayHello();
	}
}
