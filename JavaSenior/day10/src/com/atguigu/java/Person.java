package com.atguigu.java;

import java.io.Serializable;

/**
 * Person类需要满足如下要求，方可序列化
 * 1.实现接口:Serializable
 * 2.提供一个序列版本号的属性serialVersionUID,正负都可
 * 3.内部所有属性也必须是可序列化的。（默认的基本数据类型都是可序列化的）
 * 注：static和transient类型的常量不可序列化和反序列化
 * @author KeyboardHero
 * @create 2021-11-22 15:19
 */
public class Person implements Serializable {
    public static final long serialVersionUID=-486466546L;
    private String name;
    private int age;
    private Account acct;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, Account acct) {
        this.name = name;
        this.age = age;
        this.acct = acct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", acct=" + acct +
                '}';
    }
}
