package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KeyboardHero
 * @create 2021-11-05 23:38
 */
public class SubOrder extends Order<Integer>{ //SubOrder不再是泛型类
    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list=new ArrayList<>();
        for(E e:arr){
            list.add(e);
        }
        return list;
    }
}
