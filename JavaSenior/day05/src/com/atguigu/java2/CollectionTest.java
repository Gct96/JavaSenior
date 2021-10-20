package com.atguigu.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 集合框架
 * ---Collection接口：单列集合、存储一个个对象
 *    --list接口：存储有序的、可重复的数据
 *      --ArrayList\LinkedList\Vector
 *    --Set接口：存储无序的、不可重复的数据
 *      --HashSet\LinkedHashSet\TreeSet
 * ---Map接口：双列集合、存储一对对数据
 *      --HashMap\LinkedHashMap\TreeMap\Hashtable
 * @author KeyboardHero
 * @create 2021-10-20 22:13
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll= new ArrayList();
        //add(Object e):将元素e添加到集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add(123);//自动装箱
        coll.add(new Date());
        System.out.println(coll.size());//4

        //addAll():将另一集合中元素添加到当前集合中
        Collection coll1=new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);
        System.out.println(coll.size());//6
        System.out.println(coll);

        //isEmpty():判断当前集合是否为空
        System.out.println(coll.isEmpty());

        //clear():清空集合元素
        coll.clear();
        System.out.println(coll.isEmpty());
    }
}
