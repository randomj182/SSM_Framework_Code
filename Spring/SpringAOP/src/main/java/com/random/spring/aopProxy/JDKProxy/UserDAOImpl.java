package com.random.spring.aopProxy.JDKProxy;

public class UserDAOImpl implements UserDAO {

	@Override
	public void add() {
		System.out.println("增加用户...");
	}

	@Override
	public void update() {
		System.out.println("修改用户...");
	}

}
