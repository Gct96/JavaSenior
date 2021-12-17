package com.atguigu.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author KeyboardHero
 * @create 2021-12-04 14:13
 */
public class ReflectionTest {
    @Test
    public void test1() throws Exception {
        Class clazz = Person.class;
        //1.通过反射，创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(p.toString());
        //2.通过反射，调用对象指定的属性、方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());

        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        //通过反射，可以调用Person类的私有结构
        //调用私有的构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1=(Person)cons1.newInstance("Jerry");
        System.out.println(p1);

        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"Jack");
        System.out.println(p1);

        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("ShowNation", String.class);
        showNation.setAccessible(true);
        String nation=(String) showNation.invoke(p1,"中国");
        System.out.println(nation);
    }

    //获取class的实例的方式
    @Test
    public void test3() throws ClassNotFoundException{
        //方式一：调用运行时类的属性 .class
        Class clazz1=Person.class;
        System.out.println(clazz1);

        //方式二：通过运行时类的对象，调用getClass()
        Person p1=new Person();
        Class clazz2=p1.getClass();
        System.out.println(clazz2);

        //方式三：调用class的静态方法:forName(String classPath)
        Class clazz3=Class.forName("com.atguigu.java.Person");
        clazz3=Class.forName("java.lang.String");
        System.out.println(clazz3);

        //方式四：使用类的加载器:ClassLoader(了解)
        ClassLoader classLoader=ReflectionTest.class.getClassLoader();
        Class clazz4=classLoader.loadClass("com.atguigu.java.Person");
        System.out.println(clazz4);

        System.out.println(clazz1==clazz4);



    }

}
