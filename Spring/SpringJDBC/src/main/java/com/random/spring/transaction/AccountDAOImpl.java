package com.random.spring.transaction;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDAOImpl extends JdbcDaoSupport implements AccountDAO{
	/**
	 * 转出的方法
	 * @param from:转出的人
	 * @param money:要转账的金额
	 */
	@Override
	public void out(String from, Double money) {
		String sql = "UPDATE account SET money = money-? WHERE name = ?";
		this.getJdbcTemplate().update(sql,money,from);
 	}
	/**
	 * 转入的方法
	 * @param to:转入的人
	 * @param money:要转账的金额
	 */
	@Override
	public void in(String to, Double money) {
		String sql = "UPDATE account SET money = money+? WHERE name = ?";
		this.getJdbcTemplate().update(sql,money,to);
	}

}
