package com.wpf.bean;

import com.ioc.annotation.Bean;
import com.ioc.annotation.Component;

/**
 * @Author:pengfei
 * @Description
 * @Date:Created in 11:59 2019/6/26
 * @Modified by
 */
@Component
public class MyBean {

    @Bean(value = "person")
    public Person getPerson() {
        return new Person("wpf",12);
    }

}
