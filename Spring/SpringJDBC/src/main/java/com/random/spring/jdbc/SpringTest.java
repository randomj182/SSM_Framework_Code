package com.random.spring.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {
	/*@Test
	public void demo1(){
		// 创建连接池
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// 设置参数
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/data");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		// 使用JDBC模板
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("create table user(id int primary key auto_increment,name varchar(20))");
	}*/
	
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Test
	public void demo2(){
		jdbcTemplate.execute("create table gds(id int primary key auto_increment,name varchar(20))");
	}

}
