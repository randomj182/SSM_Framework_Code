package com.random.spring.aspectjaop.asxml;
/**
 * 被增强的类
 * @author random
 *
 */
public class ProductDAO {
	public int add() {
		System.out.println("新增商品...");
		int a = 10 / 0;
		return 21;
	}
	public void update() {
		System.out.println("修改商品...");
	}
	public void find() {
		System.out.println("查询商品...");
	}
	public void delete() {
		System.out.println("删除商品...");
	}
}
