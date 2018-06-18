package com.random.mybatis.dao;

import com.random.mybatis.po.User;

import java.util.List;
/* *
 * @author	Radish
 * @Description UserDAO接口类 数据库操作
 * @date	17:01 2018/6/17
 **/
public interface UserDAO {
    // 根据id查询用户信息
    public User findUserById(int id) throws  Exception;
    // 根据用户名称模糊查询用户列表
    public List<User> findUserByUsername(String username) throws  Exception;
    // 插入用户
    public void insertUser(User user) throws  Exception;
}
