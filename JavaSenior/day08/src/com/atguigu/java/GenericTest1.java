package com.atguigu.java;

import org.junit.Test;

/**如何自定义泛型结构：泛型类、泛型接口、泛型方法
 * 1、关于自定义泛型类、泛型接口
 * @author KeyboardHero
 * @create 2021-11-05 23:29
 */
public class GenericTest1 {
    @Test
    public void test1() {
        //如果定义了泛型类，实例化没有指明类的泛型，则默认Object

        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");
        //如定义了泛型，建议实例化时指明泛型
        Order<String> order1 = new Order<>("orderAA", 1001, "order:AA");
        order1.setOrderT("AA:Hello");
    }

    @Test
    public void test2(){
        SubOrder sub = new SubOrder();
        //由于子类在继承带泛型的父类时，指明了泛型类型，则实例化子类对象时，不再需要指明泛型。
        sub.setOrderT(1122);
    }
}
