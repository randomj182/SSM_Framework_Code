package com.random.spring.aspectjaop.AnnotationAdvisorPointcut;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class MyAspectTest {
	@Autowired
	@Qualifier("userDAO")
	private UserDAO userDAO;
	@Test
	public void demo1(){
		userDAO.add();
		userDAO.delete();
		userDAO.update();
		userDAO.find();		
	}
}
