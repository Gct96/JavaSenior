package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author KeyboardHero
 * @create 2021-10-20 22:41
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        //contains(Object obj):判断当前集合是否包含obj
        boolean contains=coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));
        System.out.println(coll.contains(new Person("Jerry",20)));

        //containsAll(Collection coll1):判断coll1中的所有元素是否都存在于当前集合中
        Collection coll1=new ArrayList();
        coll1.add(123);
        coll1.add(4567);
        System.out.println(coll.containsAll(coll1));

    }
}
