package com.random.spring.aop.nopointcut;
/**
 * 针对所有方法的增强:(不带有切点的切面)
 * 第二步:编写被代理对象:
 * 	  CustoemrDaoImpl实现类
 * @author random
 *
 */
public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public void add() {
		System.out.println("新增客户...");
	}

	@Override
	public void update() {
		System.out.println("修改客户...");
	}

	@Override
	public void delete() {
		System.out.println("删除客户...");
	}

	@Override
	public void find() {
		System.out.println("查询客户...");
	}

}
