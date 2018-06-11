package com.random.spring.aop.pointcut;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PointCutTest {
	@Autowired
	@Qualifier("orderDAOProxy")
	private OrderDAO orderDAO;
	
	@Test
	public void demo1(){
		orderDAO.add();
		orderDAO.update();
		orderDAO.find();
		orderDAO.delete();
	}
}
