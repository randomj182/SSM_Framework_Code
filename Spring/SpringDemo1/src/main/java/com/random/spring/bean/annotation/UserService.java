package com.random.spring.bean.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 注解的方式装配bean
 *      以前的方式:
 *          在Spring配置文件中写入:<bean id="UserService" class="com.random.spring.bean.lifestyle.UserService"></bean>
 *   此时:Component:描述Spring框架中Bean       @Component("userService")中只有一个值value,即可直接写入该值
 *
 *   Spring的框架中提供了与@Component注解等效的三个注解:
 *      @Repository 用于对DAO实现类进行标注           DO层
 *      @Service 用于对Service实现类进行标注          Service层
 *      @Controller 用于对Controller实现类进行标注    web层
 *      ***** 三个注解为了后续版本进行增强的.
 *      目前是和component一样的.
 */
//@Component("userService")
@Service(value="userService")
//@scope 作用范围 默认单例------销毁方法只对单例有效
//      prototype:多例
@Scope
public class UserService {
    @Value("hot")
    //普通属性      @Value(value="itcast")
    private String info;
    /*
        对象属性注入:
        选择类型注入,使用Autowired即可-------默认使用
            @Autowired
                @Autowired(required = false)    默认值为true    false:忽略异常,程序继续执行,传入空值
        选择名称注入,使用Qualifier,注意:名称必须相同,否则注入失败
            @Autowired
            @Qualifier("userDAO")
                若@Autowired(required = false)
                    @Qualifier("uDAO")--------------即:此处错误,忽略异常,程序继续执行,传入空值(一般不推荐使用)
                  则UserService{info='hot', userDAO=null}
     */
    public void sayHello(){
        System.out.println("Hello Spring annotation..."+info);
    }

    //    @Resource(name="userDAO")         该句等同于以下两句
    @Autowired(required = false)
    @Qualifier("userDAO")
    private UserDAO userDAO;

    /*@Override
    public String toString() {
        return "UserService{" +
                "info='" + info + '\'' +
                ", userDAO=" + userDAO +
                '}';
    }*/

    /*
        配置Bean初始化方法和销毁方法:
        类似于:
     *      init-method 和 destroy-method.
     *      @PostConstruct      初始化
     *      @PreDestroy     销毁
     */
    @PostConstruct
    public void setup(){
        System.out.println("初始化...");
    }
    @PreDestroy
    public void teardown(){
        System.out.println("销毁...");
    }
}
