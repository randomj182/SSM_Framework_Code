package com.random.spring.transaction;

public interface AccountService {
	/**
	 * 转账方法
	 * @param from :从哪转出
	 * @param to:转入的人
	 * @param money:转账金额
	 */
	public void transfer(String from,String to,Double money);
}
