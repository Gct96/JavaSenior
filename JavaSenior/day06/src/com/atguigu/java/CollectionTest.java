package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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

    @Test
    public void test2(){
        //3.remove(object obj):
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        coll.remove(123);
        coll.remove(new Person("Jerry",20));
        System.out.println(coll);

        //4.removeAll(Collection coll):从当前集合中移除coll1中的所有元素
        Collection coll1= Arrays.asList(123,456);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        //5.retainAll(Collection coll1)取交集，并返回给调用者
        Collection coll1=Arrays.asList(123,456,789);
        coll.retainAll(coll1);
        System.out.println(coll);//123,456
    }

    @Test
    public void test4(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));
        //6.hashCode():返回当前对象哈希值
        System.out.println(coll.hashCode());
        //7.集合-->数组：toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //8.数组-->集合:调用Arrays类的静态方法asList()
        //注意：基本数据类型会识别为一个元素！！！
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        //iterator():返回iterator接口的实例，用于遍历集合元素，放在IteratorTest.java中

    }



}
