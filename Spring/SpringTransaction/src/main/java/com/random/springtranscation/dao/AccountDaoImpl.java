package com.random.springtranscation.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
/**
 * 实现AccountDao接口
 * @author random
 *
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	@Override
	/**
	 * 将money金额转入到to账户
	 */
	public void increaseMoney(String to, Double money) {
		String sql = "UPDATE account SET money = money+? WHERE name=?";
		this.getJdbcTemplate().update(sql, money, to);
	}

	@Override
	/**
	 * 从from账户转出money金额
	 * @param from :转出账户
	 * @param money:转出的金额
	 */
	public void decreaseMoney(String from, Double money) {
		String sql = "UPDATE account SET money = money-? WHERE name=?";
		this.getJdbcTemplate().update(sql, money, from);
	}

}
