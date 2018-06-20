package com.random.springtranscation.dao;
/**
 * account表的操作接口
 * @author random
 *
 */
public interface AccountDao {
	/**
	 * 将money金额转入到to账户
	 * @param to :转入的账户
	 * @param money :转入的金额
	 */
	public void increaseMoney(String to,Double money);
	/**
	 * 从from账户转出money金额
	 * @param from :转出账户
	 * @param money:转出的金额
	 */
	public void decreaseMoney(String from,Double money);
}
