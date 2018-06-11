package com.random.spring.aop.nopointcut;
/**
 * 第一步:引入spring-aop
 * 针对所有方法的增强:(不带有切点的切面)
 * 第二步:编写被代理对象:
 * 	  CustomerDao接口
 * @author random
 *
 */
public interface CustomerDAO {
	public void add();
	public void update();
	public void delete();
	public void find();
}
