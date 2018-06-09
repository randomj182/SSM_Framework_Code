package com.random.spring.bean.lifestyle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    /**
     *  bean:实例对象
     *  beanName:在配置文件中配置的累的额标识.
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第五步:初始化之前执行...");
        return bean;
    }

    @Override
    /**
     * 后处理bean
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第八步:初始化之后执行...");
        // 动态代理:
        if(beanName.equals("CustomerService")){
            Object proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if("add".equals(method.getName())){
                        System.out.println(System.currentTimeMillis());
                        Object result = method.invoke(bean,args);
                        System.out.println(System.currentTimeMillis());
                        return result;
                    }
                    return method.invoke(bean,args);
                }
            });
            return proxy;
        }
        return bean;
    }
}
