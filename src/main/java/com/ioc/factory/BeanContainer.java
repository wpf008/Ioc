package com.ioc.factory;

import java.util.Map;

/**
 * @Author:pengfei
 * @Description 存放bean的容器即IOC容器
 * @Date:Created in 10:38 2019/6/26
 * @Modified by
 */
public interface BeanContainer {

    Map<String, Object> beanNameContainer();

    Map<Class, Object> beanClassContainer();

}
