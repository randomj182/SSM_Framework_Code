package com.random.mybatis.mapper;

import com.random.mybatis.po.Orders;
import com.random.mybatis.po.User;
import com.random.mybatis.po.UserItems;

import java.util.List;

/* *
 * @name
 * @Description  订单系列操作类
 * @date	18:21 2018/6/21
 **/
public interface OrderMapper {
    /* *
     * @name	findOrderUserList
     * @Description 一对一查询订单信息关联查询用户信息
     * @date	18:23 2018/6/21
     * @Param   []
     * @return   com.random.mybatis.po.Orders
     **/
    public List<Orders> findOrderUserList() throws Exception;

    // 一对多查询所有订单信息及订单下的订单明细信息。
    public List<Orders> findOrderDetailList() throws Exception;

    /* *
     * @name	findUserOrderDetailList
     * @Description  一对多复杂查询
     *          查询所有用户信息，关联查询订单及订单明细信息及商品信息，订单明细信息中关联查询商品信息
     *          主表为用户表
     * @date	20:56 2018/6/21
     * @Param   []
     * @return   java.util.List<com.random.mybatis.po.User>
     **/
    public List<User> findUserOrderDetailList() throws Exception;
    /* *
     * @name
     * @Description 多对多查询 显示字段：用户账号、用户名称、用户性别、商品名称、商品价格(最常见)
                企业开发中常见明细列表，用户购买商品明细列表，
                使用resultType将上边查询列映射到pojo输出。
     * @date	21:33 2018/6/21
     * @Param
     * @return
     **/
    public List<UserItems> findUserItemsList() throws Exception;
    /* *
     * @name
     * @Description 查询显示字段：用户账号、用户名称、购买商品数量、商品明细（鼠标移上显示明细）
                使用resultMap将用户购买的商品明细列表映射到user对象中。
     * @date	21:34 2018/6/21
     * @Param
     * @return
     **/
    public List<User> findUserOrderItemsList() throws Exception;
}
