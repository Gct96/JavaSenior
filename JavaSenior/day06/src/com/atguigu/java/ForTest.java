package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * foreach JDK5.0新增，用于遍历集合和数组
 * @author KeyboardHero
 * @create 2021-10-22 10:43
 */
public class ForTest {
    @Test
    public void test1(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        for(Object obj:coll){
            System.out.println(obj);
        }
    }

    @Test
    public void test2(){
        int[] arr=new int[]{1,2,3,4,5};
        for(int i:arr){
            System.out.println(i);
        }
    }

    @Test
    public void test3(){
        String[] arr=new String[]{"MM","MM","MM"};
//      for (int i = 0; i < arr.length; i++) {
//          arr[i]="GG";
//      }
        for(String s:arr){
            s="GG";
        }
        for (int i = 0; i < arr.length; i++) {  //"MM"
            System.out.println(arr[i]);
        }
    }
}
