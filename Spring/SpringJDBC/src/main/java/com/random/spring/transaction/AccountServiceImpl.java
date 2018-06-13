package com.random.spring.transaction;

public class AccountServiceImpl implements AccountService{
	
	private AccountDAO accountDAO;
	
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	@Override
	public void transfer(String from, String to, Double money) {
		accountDAO.out(from, money);
		int d = 1/0;
		accountDAO.in(to, money);
	}

}
