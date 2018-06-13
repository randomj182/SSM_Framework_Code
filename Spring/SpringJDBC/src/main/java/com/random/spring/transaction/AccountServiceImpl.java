package com.random.spring.transaction;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImpl implements AccountService{
	
	private AccountDAO accountDAO;
	private TransactionTemplate transactionTemplate;
	
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	/*第四步:在业务层代码上使用模板:*/
	@Override
	public void transfer(String from, String to, Double money) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				accountDAO.out(from, money);
				int d = 1/0;
				accountDAO.in(to, money);
			}
		});
	}

}
