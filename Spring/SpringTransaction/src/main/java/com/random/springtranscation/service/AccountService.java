package com.random.springtranscation.service;
/**
 * 账户先关业务
 * @author random
 *
 */
public interface AccountService {
	/**
	 * 实现两个账户之间的转账服务
	 * @param from	:转出账户
	 * @param to	:转入账户
	 * @param money	:转账金额
	 */
	public void transfer(String from ,String to,double money);
}
