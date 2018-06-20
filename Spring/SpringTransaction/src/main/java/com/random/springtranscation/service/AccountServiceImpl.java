package com.random.springtranscation.service;

import com.random.springtranscation.dao.AccountDao;

public class AccountServiceImpl implements AccountService {
	
	private AccountDao accountDao;
	@Override
	public void transfer(String from, String to, double money) {
		accountDao.decreaseMoney(from, money);
		accountDao.increaseMoney(to, money);
	}
	public AccountDao getAccountDao() {
		return accountDao;
	}
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
}
