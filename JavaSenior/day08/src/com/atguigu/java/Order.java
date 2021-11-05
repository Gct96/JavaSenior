package com.atguigu.java;

/**
 * 自定义泛型类
 * @author KeyboardHero
 * @create 2021-11-05 23:24
 */
public class Order<T>{
    String orderName;
    int orderId;

    //类的内部结构就可以使用类的泛型

    T orderT;

    public Order(){

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
}
