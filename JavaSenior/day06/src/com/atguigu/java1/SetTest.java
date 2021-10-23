package com.atguigu.java1;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * --Set接口：存储无序的、不可重复的数据
 *     HashSet：作为Set接口的主要实现类，线程不安全，可以存null值
 *     LinkedHashSet：作为HashSet的子类，遍历其内部数据时，可以按照添加的顺序遍历
 *     TreeSet：可以按照对象的指定属性，进行排序
 * @author KeyboardHero
 * @create 2021-10-23 10:00
 */
public class SetTest {
    //无序性：不等于随机性，存储的数据在底层数组中并非按照索引顺序添加
    //而是根据hash值添加
    //不可重复性：保证添加的元素按照equals()判断时，不能返回true。先算hash值，再equals()判断
    @Test
    public void test1(){
        Set set=new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom",12));
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        set.add(129);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //LinkedHashSet作为HashSet的子类，在添加数据的同时每个数据还维护了两个引用
    //对于频繁的遍历操作效率比较高
    @Test
    public void test2(){
        Set set=new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom",12));
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        set.add(129);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //一道Set的面试题，先算hash值，再equals()判断
    @Test
    public void test3(){
        HashSet set = new HashSet();
        Person1 p1 = new Person1(1001,"AA");
        Person1 p2 = new Person1(1002,"BB");

        set.add(p1);
        set.add(p2);
        System.out.println(set);//两条数据

        p1.name="CC";
        set.remove(p1);
        System.out.println(set);//还是两条数据，删除失败因为修改后的p1的hash值已改变

        set.add(new Person1(1001,"CC"));
        System.out.println(set);//三条数据

        set.add(new Person1(1001,"AA"));
        System.out.println(set);//四条数据，虽然hash值一样，但不equals






    }


}
