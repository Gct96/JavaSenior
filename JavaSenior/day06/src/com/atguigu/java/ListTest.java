package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  --list接口：存储有序的、可重复的数据
 *    ArrayList 作为List接口的主要实现类
 *      --JDK7 情况下
 *         ArrayList list=new ArrayList()//创建长度是10的Object[]数组elementData
 *         list.add(123)// elementData[0]=new Integer(123)
 *         //扩容时默认为原来的1.5倍，需要将原有数组中的数据复制到新的数组中
 *         //可以用带参的构造器指明大小
 *      --JDK8 情况下
 *         ArrayList list=new ArrayList()//底层Object[]数组elementData初始化为{}。
 *         list.add(123)//第一次调用add()时，底层才创建了长度10的数组
 *
 *
 *
 *    LinkedList 对于频繁的插入和删除，使用此类效率高，底层使用双向链表存储
 *         LinkedList list=new LinkedList():内部声明了Node类型的first和last属性，默认值null
 *         list.add(123);//将123封装到Node中，创建Node对象
 *
 *    Vector古老实现类，线程安全的，效率低
 *         JDK7和8中通过Vector()构造器创建对象时，底层都创建了长度10的数组，
 *         在扩容方面，默认扩容为原来的2倍
 *
 *    总结常用方法
 *    增 add(Object obj)
 *    删 remove(Object obj)、remove(int index),默认是index
 *    改 set(int index,Object ele)
 *    查 get(int index)
 *    插 add(int index,Object ele)
 *    长度 size()
 *    遍历 Iterator迭代器、foreach、for
 *
 *
 *
 *
 * @author KeyboardHero
 * @create 2021-10-22 15:31
 */
public class ListTest {
    @Test
    public void test1(){
        ArrayList list=new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);

        System.out.println(list);

        //void add(int index,Object ele):在index位置插入ele元素
        list.add(1,"BB");
        System.out.println(list);

        //boolean addAll(int index,Collection eles):从index开始将eles中的所有元素添加进来
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list.size());//9

        //Object get(index)：获取指定index位置的元素
        System.out.println(list.get(1));
    }

    @Test
    public void test2(){
        ArrayList list=new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);

        //int indexOf(Object obj):返回obj首次出现的位置,如不存在，返回-1
        int index = list.indexOf(456);
        System.out.println(index);

        //int lastIndexOf(Object obj):返回obj末次出现的位置,如不存在，返回-1
        System.out.println(list.lastIndexOf(456));

        //Object remove(int index):删除指定index位置的元素，并返回此元素
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);

        //Object set(int index,Object ele):设置指定index位置的元素为ele
        list.set(1,"CC");
        System.out.println(list);

        //list subList(int fromIndex,int toIndex):返回子集合，不包含右区间
        List subList = list.subList(2, 4);
        System.out.println(subList);

    }
}
