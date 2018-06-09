package com.random.spring.bean.annotation;

import org.springframework.stereotype.Component;

/**
 * 注解的方式装配bean
 *      以前的方式:
 *          在Spring配置文件中写入:<bean id="UserService" class="com.random.spring.bean.lifestyle.UserService"></bean>
 */
@Component("userService")
public class UserService {
    public void sayHello(){
        System.out.println("Hello Spring annotation...");
    }
}
