package com.random.spring.ioc.test;

import com.random.spring.bean.annotation.Car;
import com.random.spring.bean.annotation.Product;
import com.random.spring.bean.annotation.UserService;
import com.random.spring.bean.bothXMLandAnnotation.CustomerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注解的方式装配bean
 */
public class AnnotationTest {
    @Test
    /*
        装配普通属性及对象属性
     */
    public void annotationTest1(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "applicationContext1.xml");
        UserService userService = (UserService) (applicationContext.getBean("userService"));
        //userService.sayHello();
        System.out.println(userService);
        applicationContext.close();
    }
    @Test
    /*
        使用scope作用范围测试单例及多例
     */
    public void annotationTest2(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "applicationContext1.xml");
        UserService userService = (UserService) (applicationContext.getBean("userService"));
        //userService.sayHello();
        System.out.println(userService);
        UserService userService2 = (UserService) (applicationContext.getBean("userService"));
        //userService.sayHello();
        System.out.println(userService2);
        applicationContext.close();
    }

    @Test
    /*
        基于java类配置的方式装配bean
     */
    public void annotationTest3(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "applicationContext1.xml");
        Car car = (Car) (applicationContext.getBean("car"));
        Product product = (Product) (applicationContext.getBean("product"));
        //userService.sayHello();
        System.out.println(car);
        System.out.println(product);
        applicationContext.close();
    }

    @Test
    /*
        结合XML和annotation注入属性
     */
    public void annotationTest4(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "applicationContext1.xml");
        CustomerService customerService = (CustomerService) (applicationContext.getBean("customerService"));
        System.out.println(customerService);
        applicationContext.close();
    }
}
