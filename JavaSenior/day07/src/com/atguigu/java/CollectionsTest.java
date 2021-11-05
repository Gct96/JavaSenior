package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections:操作collection\Map的工具类
 * @author KeyboardHero
 * @create 2021-11-05 15:20
 */
public class CollectionsTest {
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(765);
        list.add(765);
        list.add(-97);
        list.add(0);

        System.out.println(list);
        //逆序
        //Collections.reverse(list);

        //随机排序
        //Collections.shuffle(list);

        //从小到大的自然排序
        //Collections.sort(list);

        //交换元素位置
        //Collections.swap(list,1,2);

        //元素个数
        int frequency = Collections.frequency(list, 765);
        System.out.println(list);
        System.out.println(frequency);
    }

    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        List dest= Arrays.asList(new Object[list.size()]);
        //复制list中的内容到新的list
        Collections.copy(dest,list);
        System.out.println(dest);
    }
}
