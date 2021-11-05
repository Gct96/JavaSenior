package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * 集合接口或集合类在jdk5时都修改为带泛型的结构
 * @author KeyboardHero
 * @create 2021-11-05 20:50
 */
public class GenericTest {
    //在集合中使用泛型的情况，以ArrayList为例
    @Test
    public void test1(){
        ArrayList<Integer> list=new ArrayList<Integer>();

        list.add(78);
        list.add(87);
        list.add(99);
        list.add(65);
        //方式一：增强for循环
        for(Integer score:list){
            int stuScore=score;
            System.out.println(stuScore);
        }
        //方式二：迭代器
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }
    }

    //在集合中使用泛型的情况，以HashMap为例
    @Test
    public void test3(){
        Map<String,Integer> map=new HashMap<String,Integer>();

        map.put("Tom",87);
        map.put("Jerry",87);
        map.put("Jack",67);

        //泛型的嵌套
        Set<Map.Entry<String,Integer>> entry=map.entrySet();

        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            String key=e.getKey();
            Integer value=e.getValue();
            System.out.println(key+"---"+value);
        }
    }
}
