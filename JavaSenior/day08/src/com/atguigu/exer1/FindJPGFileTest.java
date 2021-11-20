package com.atguigu.exer1;

import org.junit.Test;

import java.io.File;

/**
 * @author KeyboardHero
 * @create 2021-11-19 16:43
 */
public class FindJPGFileTest {
    //找出文件目录中的所有jpg文件
    @Test
    public void test1(){
        File srcFile=new File("D:\\IDEA-workspace\\JavaSenior\\JavaSenior\\day08\\io\\io1\\io2");
        String[] fileNames=srcFile.list();
        for(String fileName:fileNames){
            if(fileName.endsWith(".jpg")){
                System.out.println(fileName);
            }
        }
    }
}
