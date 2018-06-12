package com.random.spring.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.random.spring.dao.UserDAO;
import com.random.spring.vo.User;


/**
 * 参数设置到属性文件中:jdbc.properties
 * 连接池:C3P0
 * jdbcTemplate:继承自JdbcDaoSupport
 * @author random
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserTest {

	@Autowired
	@Qualifier("userDAO")
	private UserDAO userDAO;
	
	@Test
	// 新增用户
	public void demo1(){
		User user = new User();
		user.setId(2);
		user.setName("ranm");
		userDAO.add(user);
	}
	
	@Test
	// 根据id更新用户信息
	public void demo2(){
		User user = new User();
		user.setId(1);
		user.setName("radish");
		userDAO.updateById(user);
	}
	
	@Test
	// 删除用户
	public void demo3(){
		User user = new User();
		user.setId(2);
		userDAO.delete(user);
	}
	
	@Test
	// 简单查询用户数量
	public void demo4(){
		System.out.println(userDAO.findCount());
	}
	
	@Test
	// 根据id查询name
	public void demo5(){
		System.out.println(userDAO.findNameById(1));
	}
	
	@Test
	// 复杂查询根据id
	public void demo6(){
		System.out.println(userDAO.findById(2));
	}
	
	@Test
	// 复杂查询所有用户
	public void demo7(){
		List<User> users = userDAO.findAll();
		for (User user : users) {
			System.out.println(user);
		}
	}
}
