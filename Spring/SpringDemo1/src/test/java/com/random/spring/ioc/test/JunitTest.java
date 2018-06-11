package com.random.spring.ioc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.random.spring.web.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext1.xml")
public class JunitTest {
	@Autowired
	private UserService userService;
	@Test
	public void Test1(){
		userService.sayHello();
	}
}
