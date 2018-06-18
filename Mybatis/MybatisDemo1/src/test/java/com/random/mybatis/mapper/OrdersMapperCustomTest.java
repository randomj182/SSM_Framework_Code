package com.random.mybatis.mapper;

import com.random.mybatis.po.OrderCustom;
import com.random.mybatis.po.Orders;
import com.random.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @version 1.0
 * @ClassName OrdersMapperCustomTest
 * @Description TODO
 * @author Radish
 * @date 2018/6/18 17:33
 */
public class OrdersMapperCustomTest {
    private SqlSessionFactory sqlSessionFactory;

    // 创建工厂
    @Before
    public void init() throws IOException{
        // 配置文件(SqlMapConfig.xml)
        String resource = "SqlMapConfig.xml";

        // 加载配置文件到输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建回话工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    // 一对一查询使用resultType
    public void testFindOrderUserList() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建mapper代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
        // 调用方法
        List<OrderCustom> list = ordersMapperCustom.findOrderUserList();
        System.out.println(list);
    }

    @Test
    // 一对一查询使用resultMap
    public void testFindOrderUserListResultMap() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建mapper代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
        // 调用方法
        List<Orders> list = ordersMapperCustom.findOrderUserListResultMap();
        System.out.println(list.get(0).getId());
    }

    @Test
    // 一对多查询使用resultMap
    public void testFindOrderAndOrderDetails() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建mapper代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
        // 调用方法
        List<Orders> list = ordersMapperCustom.findOrderAndOrderDetails();
        System.out.println(list);
    }

    @Test
    // 一对多查询使用resultMap
    public void testFindUserOrderDetail() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建mapper代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
        // 调用方法
        List<User> list = ordersMapperCustom.findUserOrderDetail();
        System.out.println(list);
    }
}
