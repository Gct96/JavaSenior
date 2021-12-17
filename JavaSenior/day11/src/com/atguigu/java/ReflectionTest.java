package com.atguigu.java;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Class的实例对应着一个运行时类
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

    //获取Class的实例的方式
    @Test
    public void test2() throws ClassNotFoundException{
        //方式一：调用运行时类的属性 .class
        Class clazz1=Person.class;
        System.out.println(clazz1);

        //方式二：通过运行时类的对象，调用getClass()
        Person p1=new Person();
        Class clazz2=p1.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法:forName(String classPath)
        Class clazz3=Class.forName("com.atguigu.java.Person");
        System.out.println(clazz3);

        System.out.println(clazz1==clazz2);
        System.out.println(clazz1==clazz3);

        //方式四：使用类的加载器:ClassLoader(了解)
        ClassLoader classLoader=ReflectionTest.class.getClassLoader();
        Class clazz4=classLoader.loadClass("com.atguigu.java.Person");
        System.out.println(clazz4);

        System.out.println(clazz1==clazz4);

    }

    //Class实例可以是哪些结构的说明
    @Test
    public void test4(){
        Class c1=Object.class;
        Class c2=Comparable.class;
        Class c3=String[].class;
        Class c4=int[][].class;
        Class c5= ElementType.class;
        Class c6=Override.class;
        Class c7=int.class;
        Class c8=void.class;
        Class c9=Class.class;

        int[] a=new int[10];
        int[] b=new int[100];
        Class c10=a.getClass();
        Class c11=b.getClass();
        //只要数组元素类型与维度一样，就是同一个Class
        System.out.println(c10==c11);

    }
}
