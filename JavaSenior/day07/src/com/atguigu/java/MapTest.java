package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * Map:双列数据，存储key-value对的数据
 *    --HashMap:线程不安全、效率高、存储Null的key和value
 *      --LinkedHashMap:可以按照添加的顺序遍历
 *    --TreeMap:保证按照添加的键值对进行排序，实现排序遍历
 *    --Hashtable：线程安全、效率低不能存储Null的key和value
 *      --Properties 处理配置文件
 *
 * Map的结构理解
 *    Map中的key：无序，不可重复，使用set存储所有的key-->key所在的类要重写equals()和hashcode
 *    Map中的value:无序，可重复，使用collection存储所有的value-->value所在的类要重写equals()
 *    一个key-value构成了一个entry对象
 *    Map中的entry：无序、不可重复，使用set存储所有的entry
 *
 * Map中定义的方法
 * @author KeyboardHero
 * @create 2021-10-24 11:32
 */
public class MapTest {
    @Test
    public void test1(){
        //Put()
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        map.put("AA",87);
        System.out.println(map);
        //putAll()
        Map map1 = new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);
        map.putAll(map1);
        System.out.println(map);

        //remove(Object key)
        map.remove("CC");
        System.out.println(map);

        //clear()
        map.clear();
        System.out.println(map.size());

    }

    @Test
    public void test2(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);

        //get(Object key)
        System.out.println(map.get(45));

        //containsKey(Object key)
        boolean isExist = map.containsKey("BB");
        System.out.println(isExist);

        //containsValue(Object value)
        isExist=map.containsValue(123);
        System.out.println(isExist);
    }

    @Test
    public void test3(){
        /*
        元视图操作
        Set keySet():返回所有key构成的Set集合
        Collection values():返回所有values构成的Collection集合
        Set entrySet():返回所有key-value对构成的Set集合
         */
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);

        //keySet() 遍历所有的key集
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //values() 遍历所有的value集
        Collection values = map.values();
        for(Object o:values){
            System.out.println(o);
        }

        //entrySet遍历所有的key-value
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while ((iterator1.hasNext())){
            Object obj = iterator1.next();
            Map.Entry entry=(Map.Entry)obj;
            System.out.println(entry.getKey()+"-->"+entry.getValue());
        }
    }
}
