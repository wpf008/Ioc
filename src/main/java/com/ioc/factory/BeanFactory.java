package com.ioc.factory;

/**
 * @Author:pengfei
 * @Description 提供了IOC容器最基本的操作
 * @Date:Created in 10:28 2019/6/26
 * @Modified by
 */
public interface BeanFactory {
    Object getBean(String var1);//by beanName get bean

    <T> T getBean(Class<T> var1);//by beanClass get bean

    boolean containsBean(String var1);// by beanName contains Bean
}
