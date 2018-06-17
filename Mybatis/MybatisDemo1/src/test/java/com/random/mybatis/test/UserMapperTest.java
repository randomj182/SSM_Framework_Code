package com.random.mybatis.test;

import com.random.mybatis.mapper.UserMapper;
import com.random.mybatis.po.User;
import com.random.mybatis.po.UserCustom;
import com.random.mybatis.po.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserMapperTest {
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
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void testFindUserByName() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList =userMapper.findUserByName("小明");
        System.out.println(userList);
    }

    @Test
    public void testInsertUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 创建插入数据对象
        User user = new User();
        user.setUsername("lisi");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("浙江宁波");

        userMapper.insertUser(user);
        sqlSession.commit();
        sqlSession.close();
    }
    //通过包装类型查询用户信息
    @Test
    public void testFindUserList() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 创建插入数据对象
        UserQueryVo userQueryVo = new UserQueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(27);
        ids.add(28);
        userQueryVo.setIds(ids);
        UserCustom userCustom = new UserCustom();
        userCustom.setUsername("小明");
        userQueryVo.setUserCustom(userCustom);

        List<User> userList = userMapper.findUserList(userQueryVo);
        sqlSession.close();
        System.out.println(userList);
    }

    // 返回查询记录总数
    @Test
    public void testFindUserCount() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 创建插入数据对象
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setUsername("小明");
        userQueryVo.setUserCustom(userCustom);

        int count = userMapper.findUserCount(userQueryVo);
        sqlSession.close();
        System.out.println(count);
    }

    // 使用resultMap进行结果映射
    @Test
    public void testFindUserListResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 创建插入数据对象
        UserQueryVo userQueryVo = new UserQueryVo();

        UserCustom userCustom = new UserCustom();
        userCustom.setUsername("小明");
        userQueryVo.setUserCustom(userCustom);

        List<User> userList = userMapper.findUserListResultMap(userQueryVo);
        sqlSession.close();
        System.out.println(userList);
    }
}
