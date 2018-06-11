package com.random.spring.aop.pointcut;
/**
 * 带切面的切面:(针对目标对象的某些方法进行增强)
 * @author random
 *
 */
public class OrderDAO {
	public void add() {
		System.out.println("新增订单...");
	}
	public void update() {
		System.out.println("修改订单...");
	}
	public void find() {
		System.out.println("查询订单...");
	}
	public void delete() {
		System.out.println("删除订单...");
	}

}
