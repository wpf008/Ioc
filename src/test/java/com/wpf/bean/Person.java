package com.wpf.bean;

/**
 * @Author:pengfei
 * @Description
 * @Date:Created in 11:59 2019/6/26
 * @Modified by
 */
public class Person {

    private String name;
    private Integer age;


    public Person() {

    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


    public void get(){
        System.out.println("hi");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
