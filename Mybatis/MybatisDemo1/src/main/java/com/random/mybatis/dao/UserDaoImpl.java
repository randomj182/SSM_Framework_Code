package com.random.mybatis.dao;

import com.random.mybatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDAO {
    private SqlSessionFactory sqlSessionFactory;
    // 将SQLSessionFactory注入

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) throws Exception {
        // 创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 根据id查询用户信息
        User user = sqlSession.selectOne("test.findUserById",id);
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findUserByUsername(String username) throws Exception {
        // 创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 根据id查询用户信息
        List<User> userList = sqlSession.selectList("test.findUserByName","%小明%");
        sqlSession.close();
        return  userList;
    }

    @Override
    public void insertUser(User user) throws Exception {
        // 创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 根据id查询用户信息
        sqlSession.insert("test.insertUser",user);
        sqlSession.commit();
        sqlSession.close();
    }
}
