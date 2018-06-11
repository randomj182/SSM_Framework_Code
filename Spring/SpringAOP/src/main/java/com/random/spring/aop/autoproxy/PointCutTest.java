package com.random.spring.aop.autoproxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.random.spring.aop.nopointcut.CustomerDAO;
import com.random.spring.aop.nopointcut.CustomerDAOImpl;
import com.random.spring.aop.pointcut.OrderDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PointCutTest {
	@Autowired
	@Qualifier("orderDAO")
	private OrderDAO orderDAO;
	@Autowired
	@Qualifier("customerDAO")
	private CustomerDAO customerDAO;
	@Test
	public void demo1(){
		orderDAO.add();orderDAO.delete();
		customerDAO.add();
	}
}
