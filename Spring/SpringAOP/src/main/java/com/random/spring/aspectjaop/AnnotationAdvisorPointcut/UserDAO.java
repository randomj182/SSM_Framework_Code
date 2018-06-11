package com.random.spring.aspectjaop.AnnotationAdvisorPointcut;
/**
 * Spring的AspectJ的AOP
 * 基于注解:
 * 	  第二步:编写被增强的类:
 * @author random
 *
 */
public class UserDAO {
	public void add() {
		System.out.println("新增用户...");
	}
	public int update() {
		System.out.println("修改用户...");
		return 21;
	}
	public void find() {
		System.out.println("查询用户...");
		int d = 1/0;
	}
	public void delete() {
		System.out.println("删除用户...");
	}
}
