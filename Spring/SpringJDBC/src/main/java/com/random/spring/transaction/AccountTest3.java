package com.random.spring.transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * 声明式事务管理:基于切面的自动代理
 * @author random
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext3.xml")
public class AccountTest3 {

	@Autowired
	@Qualifier("accountService")
	private AccountService accountService;
	@Test
	public void demo(){
		accountService.transfer("aaa", "bbb", 100d);
	}
}
