package com.atguigu.java1;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**Annotation的使用示例?
 * 1、生成文档相关的注解
 * 2、编译时进行格式检查（内置的3个基本注解）
 *    2.1 override限定重写父类方法
 *    2.2 deprecated用于表示所修饰的元素已过时
 *    2.3 suppressWarnings抑制编译器警告
 * 3、跟踪代码依赖性，实现替代配置文件功能
 *
 * 如何自定义注解?
 * 1、注解声明为@interface
 * 2、内部定义成员，通常使用value表示
 * 3、可以指定成员的默认值，使用default定义
 * 4、如果自定义注解没有成员，表明是一个标识作用
 * 5、如果注解有成员，在使用注解时，需要指明成员的值
 *
 * JDK中的元注解?
 * 元注解：对现有的注解进行解释说明的注解
 *      Retention  指定Annotation的生命周期，只有声明为runtime的注解才能通过反射获取
 *      Target   指定Annotation能修饰哪些元素
 *      Documented 指定Annotation类将被javadoc工具提取成文档
 *      Inherited   指定的Annotation将具有继承性
 *
 * JDK8新特性
 * 可重复注解 @Repeatable,成员值为MyAnnotations.class
 *           Target和Retention等元注解要和MyAnnotations相同
 * 类型注解
 *
 * @author KeyboardHero
 * @create 2021-10-16 15:31
 */
public class AnnotationTest {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        int num=10;
        @SuppressWarnings({"unused","rawtypes"})
        ArrayList list=new ArrayList();
    }

    @Test
    public void testGetAnnotation(){
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }
    }

}
@MyAnnotation(value = "hi")
class Person{

}

class Student extends Person{

}

class Generic<@MyAnnotation T>{
    public void show() throws @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> list=new ArrayList<>();
        int num=(@MyAnnotation int)10L;
    }
}