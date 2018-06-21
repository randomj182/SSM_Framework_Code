package com.random.mybatis.test;

import com.random.mybatis.mapper.OrderMapper;
import com.random.mybatis.po.Orders;
import com.random.mybatis.po.User;
import com.random.mybatis.po.UserItems;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @version 1.0
 * @ClassName OrderMapperTest
 * @Description  测试类
 * @author Radish
 * @date 2018/6/21 20:17
 */
public class OrderMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
    }
    @Test
    // 测试一对一查询订单信息关联查询用户信息
    public void testFindOrderUserList() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Orders> orders = orderMapper.findOrderUserList();
        System.out.println(orders);
    }

    @Test
    // 测试一对多查询所有订单信息及订单下的订单明细信息。
    public void testFindOrderDetailList() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Orders> orders = orderMapper.findOrderDetailList();
        System.out.println(orders);
    }

    @Test
    /*
    *  一对多复杂查询
    *  查询所有用户信息，关联查询订单及订单明细信息及商品信息，订单明细信息中关联查询商品信息
    * */
    public void testFindUserOrderDetailList() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<User> userList = orderMapper.findUserOrderDetailList();
        for (User user:userList
             ) {
            System.out.println(user);
        }
    }
    @Test
    /*
     *  多对多查询 显示字段：用户账号、用户名称、用户性别、商品名称、商品价格(最常见)
     企业开发中常见明细列表，用户购买商品明细列表，
     使用resultType将上边查询列映射到pojo输出。
     * */
    public void testFindUserItemsList() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<UserItems> userList = orderMapper.findUserItemsList();
        for (User user:userList
                ) {
            System.out.println(user);
        }
    }
}
