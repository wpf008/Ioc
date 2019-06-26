package com.ioc.factory;


import com.ioc.annotation.Bean;
import com.ioc.annotation.Component;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author:pengfei
 * @Description 扫描注解并实例化bean存入IOC容器
 * @Date:Created in 10:41 2019/6/26
 * @Modified by
 */
public class AnnotationBeanFactory extends AbstractBeanFactory {

    private Class primarySources;
    private Map<String, Object> beanNameContainer = new HashMap<>();//通过名字存放bean
    private Map<Class, Object> beanClassContainer = new HashMap<>();//通过类名存放bean

    public AnnotationBeanFactory(Class primarySources) {
        this.primarySources = primarySources;
        this.register();
    }


    private void register() {
        Reflections reflections = new Reflections(this.primarySources.getPackage().getName());
        Set<Class<?>> classesList = reflections.getTypesAnnotatedWith(Component.class);
        for (Class classes : classesList) {
            Method[] methods = classes.getDeclaredMethods();
            Component component = (Component) classes.getAnnotation(Component.class);
            try {
                this.beanNameContainer.put(component.value(), classes.newInstance());
                this.beanClassContainer.put(classes, classes.newInstance());
                for (Method method : methods) {
                    Bean bean = method.getAnnotation(Bean.class);
                    if (null != bean) {
                        String aliasName = bean.value();
                        if ("".equals(bean.value())) {
                            String returnTyep = method.getReturnType().getName();
                            String returnTyepName = returnTyep.substring(returnTyep.lastIndexOf(".") + 1).toLowerCase();
                            aliasName = returnTyepName;
                        }
                        if (this.beanNameContainer.containsKey(aliasName)) {
                            throw new RuntimeException("The bean has defined");
                        }
                        Object targetBean = method.invoke(classes.newInstance(), null);
                        this.beanNameContainer.put(aliasName, targetBean);
                        this.beanClassContainer.put(method.getReturnType(), targetBean);
                    }
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Map<String, Object> beanNameContainer() {
        return this.beanNameContainer;
    }

    @Override
    public Map<Class, Object> beanClassContainer() {
        return this.beanClassContainer;
    }
}
