package com.random.mybatis.test;

import com.random.mybatis.dao.UserDAO;
import com.random.mybatis.dao.UserDaoImpl;
import com.random.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserDAOImplTest {
    //会话工厂
    private SqlSessionFactory sqlSessionFactory;
    //创建工厂
    @Before
    public void init() throws IOException {

        //配置文件(SqlMapConfig.xml)
        String resource = "SqlMapConfig.xml";

        //加载配置文件到输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建会话工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void testFindUserById() throws Exception {
        UserDAO userDAO = new UserDaoImpl(sqlSessionFactory);

        User user = userDAO.findUserById(1);
        System.out.println(user);
    }
}
