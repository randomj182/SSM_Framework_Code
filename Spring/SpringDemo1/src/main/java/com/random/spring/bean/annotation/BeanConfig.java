package com.random.spring.bean.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 基于java类配置的方式装配bean
 *      一般不会使用
 *      除非类的构造十分复杂
 */
@Configuration
public class BeanConfig {
    @Bean(name = "car")
    public Car showCar(){
        Car car = new Car();
        car.setName("大众");
        car.setPrice(20000.0);
        return car;
    }
    @Bean(name = "product")
    public Product initProduct(){
        Product product = new Product();
        product.setName("空调");
        product.setPrice(20000.0);
        return product;
    }
}
