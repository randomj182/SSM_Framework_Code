package com.random.mybatis.mapper;

import com.random.mybatis.po.OrderCustom;
import com.random.mybatis.po.Orders;
import com.random.mybatis.po.User;

import java.util.List;
/**
 * 订单自定义mapper接口
 * @author	random
 * @Description
 * @date	17:27 2018/6/18
 **/
public interface OrdersMapperCustom {
    //一对一查询,查询订单关联查询用户,使用resultType
    public List<OrderCustom> findOrderUserList() throws Exception;

    //一对一查询,使用resultMap
    public List<Orders> findOrderUserListResultMap() throws Exception;

    // 一对多查询，使用resultMap
    public List<Orders> findOrderAndOrderDetails() throws Exception;

    // 一对多查询，使用resultMap
    public List<User> findUserOrderDetail() throws Exception;
}
