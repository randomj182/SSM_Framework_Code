package com.random.spring.transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * 声明式事务管理:基于注解的的事务管理
 * @author random
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext4.xml")
public class AccountTest4 {

	@Autowired
	@Qualifier("accountService")
	private AccountService accountService;
	@Test
	public void demo(){
		accountService.transfer("aaa", "bbb", 100d);
	}
}
