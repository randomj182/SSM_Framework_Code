package com.random.spring.aop.nopointcut;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * 针对所有方法的增强:(不带有切点的切面)
 * 	一般不经常使用,比较麻烦
 * @author random
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {
	@Autowired
	@Qualifier("customerDAOProxy")		/*此时注入的是真实的对象,但是用配置的生成代理,应该注入代理对象*/
	private CustomerDAO customerDAO;
	
	@Test
	//传统方法测试
	public void demo1(){
		customerDAO.add();
		customerDAO.delete();
		customerDAO.update();
		customerDAO.find();
	}
}
