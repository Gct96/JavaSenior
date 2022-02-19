package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构：属性、方法、构造器
 * @author KeyboardHero
 * @create 2022-02-05 14:35
 */
public class ReflectionTest {
    /*

     */
    @Test
    public void testField() throws Exception {
        Class clazz= Person.class;
        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();
        //获取指定的属性:要求运行时类中属性声明为public
        //通常不采用此方式
        Field id = clazz.getField("id");
        //设置当前属性的值set():参数1指明哪个对象，参数2设置多少
        id.set(p,1001);
        //获取当前属性的值
        int pId=(int)id.get(p);
        System.out.println(pId);
    }
    /*
    如何操作运行时类中的指定属性
     */
    @Test
    public void testField1() throws Exception {
        Class clazz=Person.class;
        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");
        //保证当前属性是可访问的
        name.setAccessible(true);
        //设置指定对象的此属性值
        name.set(p,"Tom");

        System.out.println(name.get(p));
    }

    /*
    如何操作运行时类中的指定方法
     */
    @Test
    public void testMethod() throws Exception {
        Class clazz=Person.class;
        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();
        //获取指定的某个方法
        //getDeclaredMethod():参数1指明获取的方法的名称，参数2指明获取的方法的形参列表
        Method show = clazz.getDeclaredMethod("show", String.class);
        //保证当前方法是可访问的
        show.setAccessible(true);
        //invoke():参数1方法的调用者，参数2给方法形参赋值的实参.返回值即为对应类中调用方法的返回值
        Object returnValue = show.invoke(p, "CHN");
        System.out.println(returnValue);

        System.out.println("调用静态方法");

        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //如调用的运行时类中的方法无返回值，则此invoke()返回null
        Object returnVal = showDesc.invoke(Person.class);
        System.out.println(returnVal);//null
    }

     /*
    如何操作运行时类中的指定构造器---不常用
     */
    @Test
    public void testConstructor() throws Exception {
        Class clazz=Person.class;
        /*
        1 获取指定的构造器getDeclaredConstructor（）：参数指明构造器的参数列表
         */
        Constructor constructor = clazz.getDeclaredConstructor(String.class);
        //2 保证此构造器是可访问的
        constructor.setAccessible(true);
        //3 调用此构造器创建运行时类的对象
        Person per=(Person)constructor.newInstance("Tom");
        System.out.println(per);
    }
}
