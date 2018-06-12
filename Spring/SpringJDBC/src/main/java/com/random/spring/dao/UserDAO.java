package com.random.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.random.spring.vo.User;
/**
 * 数据库操作类
 * @author random
 *
 */
public class UserDAO extends JdbcDaoSupport{
	// 原本操作
	/*private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}*/
	
	/*
	 * 新增用户
	 */
	public void add(User user){
		String sql = "INSERT INTO user VALUES(?,?)";
		this.getJdbcTemplate().update(sql, user.getId(),user.getName());
	}
	/*
	 * 根据id更新用户
	 */
	public void updateById(User user){
		String sql = "UPDATE user SET name=? WHERE id=?";
		this.getJdbcTemplate().update(sql, user.getName(),user.getId());
	}
	/*
	 * 删除用户
	 */
	public void delete(User user){
		String sql = "DELETE FROM user WHERE id=?";
		this.getJdbcTemplate().update(sql, user.getId());
	}
	/*
	 * 简单查询用户数量
	 */
	public int findCount(){
		String sql = "SELECT COUNT(*) FROM user";
		/*spring3.2.2之后取消了queryForInt 包括queryForLong  全部都用queryObject代替*/
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);
	}
	
	/*
	 * 根据id查询name
	 */
	public String findNameById(int id){
		String sql = "SELECT name FROM user WHERE id=?";
		/*spring3.2.2之后取消了queryForInt 包括queryForLong  全部都用queryObject代替*/
		return this.getJdbcTemplate().queryForObject(sql, String.class,id);
	}
	
	/*
	 * 复杂查询根据id
	 */
	public User findById(int id){
		String sql = "SELECT * FROM user WHERE id=?";
		/*spring3.2.2之后取消了queryForInt 包括queryForLong  全部都用queryObject代替*/
		User user = (User)this.getJdbcTemplate().queryForObject(sql, new UserRowMapper(), id);
		return user;
	}
	
	/*
	 * 复杂查询所有用户
	 */
	public List<User> findAll(){
		String sql = "SELECT * FROM user";
		return this.getJdbcTemplate().query(sql, new UserRowMapper());
		 
	}
	
	class UserRowMapper implements RowMapper<User>{
		/**
		 * rs:结果集
		 * rowNum:行号
		 */
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			return user;
		}
		
	}
}
