package com.random.spring.aspectjaop.asxml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext2.xml")
public class MyAspectXMLTest {
	
	@Autowired
	@Qualifier("productDAO")
	private ProductDAO productDAO;
	@Test
	public void demo1(){
		productDAO.add();
		productDAO.delete();
		productDAO.find();
		productDAO.update();
	}
}
