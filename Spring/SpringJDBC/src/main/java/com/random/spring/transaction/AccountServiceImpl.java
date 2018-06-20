package com.random.spring.transaction;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
/**
 * 业务层实现类
 * @author random
 *
 */
/*
 * 基于注解的事务管理需加入以下此句
 */
@Transactional
public class AccountServiceImpl implements AccountService{
	
	private AccountDAO accountDAO;
	//手动编码方式实现事务管理
	
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	public void transfer(String from, String to, Double money) {
		accountDAO.out(from, money);
		//int d = 1/0;
		accountDAO.in(to, money);
	}
	//手动编码方式实现事务管理
	/*第四步:在业务层代码上使用模板:*/
	/*@Override
	public void transfer(String from, String to, Double money) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				accountDAO.out(from, money);
				int d = 1/0;
				accountDAO.in(to, money);
			}
		});
	}*/

}
