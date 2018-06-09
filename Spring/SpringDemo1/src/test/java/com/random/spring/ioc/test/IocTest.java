package com.random.spring.ioc.test;

import com.random.spring.bean.lifestyle.CustomerService;
import com.random.spring.bean.propertyInjection.Car;
import com.random.spring.bean.propertyInjection.Car2;
import com.random.spring.bean.propertyInjection.Person;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.random.spring.ioc1.test.HelloService;
import com.random.spring.ioc1.test.HelloServiceImpl;
import com.random.spring.ioc2.test.Bean1;
import com.random.spring.ioc2.test.Bean2;
import com.random.spring.ioc2.test.Bean2Factory;
import com.random.spring.ioc2.test.Bean3;

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
		HelloService service = (HelloService)(applicationContext.getBean("HelloService"));
		service.sayHello();
	}
	
	@Test
	/** ApplicationContext类继承了BeanFactory
	 *  BeanFactory延迟加载,使用到这个类,getBean()方法的时候才加载
	 *  ApplicationContext类加载文件的 时候,就创建了所有类
	 */
	public void Ioc1Test3(){
		BeanFactory factory  = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		HelloService service = (HelloService)(factory.getBean("HelloService"));
		service.sayHello();
	}
	
	@Test
	// 构造方法实例化
	public void ioc2Test1(){
		// 创建一个工厂类
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Bean1 bean1 = (Bean1)(applicationContext.getBean("bean1"));
		System.out.println(bean1);;
	}
	@Test
	// 静态工厂实例化
	public void ioc2Test2(){
		// 创建一个工厂类
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Bean2 bean2 = (Bean2)(applicationContext.getBean("bean2"));
		System.out.println(bean2);
	}
	@Test
	// 静态工厂实例化
	public void ioc2Test3(){
		// 创建一个工厂类
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Bean3 bean3 = (Bean3)(applicationContext.getBean("bean3"));
		System.out.println(bean3);
	}
	
	
	@Test
	/** 
	 * bean的scope作用范围-singleton
	 */
	public void ioc2Test4(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// 单例模式 ,只被实例化一次
		Bean1 bean1 = (Bean1)(applicationContext.getBean("singletonbean"));
		System.out.println(bean1);
		Bean1 bean2 = (Bean1)(applicationContext.getBean("singletonbean"));
		System.out.println(bean2);
	}
	
	@Test
	/** 
	 * bean的scope作用范围-prototype
	 */
	public void ioc2Test5(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// 多例模式,每获得一次创建一个新的类
		Bean1 bean1 = (Bean1)(applicationContext.getBean("prototypebean"));
		System.out.println(bean1);
		Bean1 bean2 = (Bean1)(applicationContext.getBean("prototypebean"));
		System.out.println(bean2);
	}

	@Test
	/**
	 * bean的生命周期
	 */
	public void beanLifestyleTest(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CustomerService CustomerService = (CustomerService)(applicationContext.getBean("CustomerService"));
		CustomerService.add();
		CustomerService.find();

		((ClassPathXmlApplicationContext) applicationContext).close();
	}

	@Test
	/**
	 * bean的属性注入-------构造方法注入
	 */
	public void beanPropertyInjectionTest1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Car car = (Car)(applicationContext.getBean("Car"));
		System.out.println(car);
	}
	@Test
	/**
	 * bean的属性注入-------setting方法注入普通属性
	 */
	public void beanPropertyInjectionTest2(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Car2 car2 = (Car2)(applicationContext.getBean("Car2"));
		System.out.println(car2);
	}
	@Test
	/**
	 * bean的属性注入-------setting方法注入普通属性及对象
	 */
	public void beanPropertyInjectionTest3(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Person person = (Person)(applicationContext.getBean("Person"));
		System.out.println(person);
	}


}
