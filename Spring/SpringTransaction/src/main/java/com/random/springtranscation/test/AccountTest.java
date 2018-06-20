package com.random.springtranscation.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.random.springtranscation.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class AccountTest {
	@Autowired
	@Qualifier("accountService")
	private AccountService accountService;
	@Test
	public void demo1(){
		accountService.transfer("ccc", "bbb", 2000);
	}
	
}
