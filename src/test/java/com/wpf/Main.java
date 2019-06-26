package com.wpf;

import com.ioc.factory.AnnotationBeanFactory;
import com.ioc.factory.BeanFactory;
import com.wpf.bean.Person;

/**
 * @Author:pengfei
 * @Description 测试入口
 * @Date:Created in 11:57 2019/6/26
 * @Modified by
 */
public class Main {

    public static void main(String[] args) {
        BeanFactory beanFactory = new AnnotationBeanFactory(Main.class);//初始化AnnotationBeanFactory
        Person p = (Person) beanFactory.getBean("person");//获取名为person的bean
        System.out.println(p);
        Person p1 = beanFactory.getBean(Person.class);//获取名为person的bean
        System.out.println(p1 == p);//默认为单例的
//        Person p2 = (Person) beanFactory.getBean("person1");//获取一个不存在的bean

    }
}
