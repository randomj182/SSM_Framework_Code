package com.random.spring.transaction;

public interface AccountDAO {
	/**
	 * 转出的方法
	 * @param from:转出的人
	 * @param money:要转账的金额
	 */
	public void out(String from ,Double money);
	/**
	 * 转入的方法
	 * @param to:转入的人
	 * @param money:要转账的金额
	 */
	public void in(String in,Double money);
}
