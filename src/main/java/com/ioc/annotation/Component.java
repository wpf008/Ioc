package com.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author:pengfei
 * @Description 用@Component注解表示使用IOC容器来管理这个类
 * @Date:Created in 10:32 2019/6/26
 * @Modified by
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    String value() default "";
}
