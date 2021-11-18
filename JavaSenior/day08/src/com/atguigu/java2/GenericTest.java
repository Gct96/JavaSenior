package com.atguigu.java2;

import org.junit.Test;

import java.util.*;

/**
 * @author KeyboardHero
 * @create 2021-11-08 17:23
 */
public class GenericTest {
    /*
    1.泛型在继承方面的体现
     */
    @Test
    public void test1(){
        Object obj=null;
        String str=null;
        obj=str;

        Object[] arr1=null;
        String[] arr2=null;
        arr1=arr2;

        //编译不过
//        Date date=new Date();
//        str=date;

        //编译不过 无子父类关系
        List<Object> list1=null;
        List<String> list2=new ArrayList<String>();
//        list1=list2;
    }

    @Test
    public void test2(){
        AbstractList<String> list1=null;
        List<String> list2=null;
        ArrayList<String> list3=null;

        list1=list3;
        list2=list3;

        List<String> list4=new ArrayList<>();
    }

    @Test
    public void test3(){
        List<Object> list1=null;
        List<String> list2=null;

        List<?> list=null;

        list=list1;
        list=list2;

//        print(list1);
//        print(list2);

        //
        List<String> list3=new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list=list3;
        
        //添加：对于list<?>就不能向其内部添加数据。
//        list.add("DD")；
//        list.add("?");
        list.add(null);

        //获取 读取的数据类型为Object
        Object o = list.get(0);
        System.out.println(o);
    }
    public void print(List<?> list){
        Iterator<?> iterator=list.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    /*
    有限制条件的通配符的使用
     */
    @Test
    public void test4(){
        List<? extends Person> list1=null;
        List<? super Person> list2=null;

        List<Student> list3=null;
        List<Person> list4=null;
        List<Object> list5=null;

        list1=list3;
        list1=list4;
        //list1=list5; list5不继承Person

        // list2=list3;
        list2=list4;
        list2=list5;

        //读取数据：
        list1=list4;
        Person p = list1.get(0);
        //编译不通过
        //Student s=list1.get(0);

        list2=list4;
        Object obj = list2.get(0);
        //编译不通过
        //Person obj=list2.get(0);

        //写入数据
        //编译不通过
        //list1.add(new Student());
        list2.add(new Person());
        list2.add(new Student());



    }
}
