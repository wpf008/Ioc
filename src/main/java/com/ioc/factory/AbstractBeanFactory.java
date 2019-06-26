package com.ioc.factory;

/**
 * @Author:pengfei
 * @Description 抽象BeanFactory 实现了IOC容器最基本的操作
 * @Date:Created in 10:42 2019/6/26
 * @Modified by
 */
public abstract class AbstractBeanFactory implements BeanFactory, BeanContainer {

    public Object getBean(String var1) {
        if (containsBean(var1)) {
            return beanNameContainer().get(var1);
        } else {
            throw new RuntimeException("No Such bean..");
        }
    }


    public <T> T getBean(Class<T> var1) {
        if (beanClassContainer().containsKey(var1)) {
            return (T) beanClassContainer().get(var1);
        } else {
            throw new RuntimeException("No Such bean..");
        }
    }

    public boolean containsBean(String var1) {
        return beanNameContainer().containsKey(var1);
    }
}
