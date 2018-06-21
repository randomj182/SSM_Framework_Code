package com.random.mybatis.po;

/**
 * @version 1.0
 * @ClassName UserOrderDetailItems
 * @Description 对多查询 显示字段：用户账号、用户名称、用户性别、商品名称、商品价格(最常见)
     *     企业开发中常见明细列表，用户购买商品明细列表，
     *      使用resultType将上边查询列映射到pojo输出。
 * @author Radish
 * @date 2018/6/21 21:46
 */
public class UserItems extends User{
    private String name;
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "UserItems{" +
                "name='" + name + '\'' +
                ", price=" + price +
                "} " + super.toString();
    }
}
