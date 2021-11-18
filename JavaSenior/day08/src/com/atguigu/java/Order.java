package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型类
 * 注：1、静态方法随类的加载而加载，早于对象创建，故静态方法中不能使用类的泛型
 *    2、 泛型方法可以声明为静态的
 * @author KeyboardHero
 * @create 2021-11-05 23:24
 */
public class Order<T>{
    String orderName;
    int orderId;

    //类的内部结构就可以使用类的泛型

    T orderT;

    public Order(){ //声明构造器时不用加<>

    }

    public Order(String orderName,int orderId,T orderT){
        this.orderName = orderName;
        this.orderId=orderId;
        this.orderT=orderT;
    }

    public T getOrderT(){
        return orderT;
    }

    public void setOrderT(T orderT){
        this.orderT=orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    //静态方法中不能使用类的泛型
    // public static void show(T orderT){
    //   System.out.println(orderT);
    //}

    //泛型方法：方法中出现泛型的结构，泛型参数与类的泛型参数没有关系
    //泛型方法可以声明为静态的
    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list=new ArrayList<>();
        for(E e:arr){
            list.add(e);
        }
        return list;
    }
}
