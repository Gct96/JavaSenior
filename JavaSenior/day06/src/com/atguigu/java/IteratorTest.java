package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历,使用迭代器接口
 * 内部方法hasNext和next搭配使用
 * @author KeyboardHero
 * @create 2021-10-21 16:52
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        Iterator iterator = coll.iterator();
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        Iterator iterator=coll.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
            }
        }

        Iterator iterator1=coll.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }


}
