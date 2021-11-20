package com.atguigu.exer1;

import java.io.File;

/**
 * 遍历指定目录所有文件名称，包括子文件目录中的文件
 * 拓展：计算指定目录占用空间的大小
 *       删除指定文件目录及其下的所有文件
 * @author KeyboardHero
 * @create 2021-11-19 16:54
 */
public class ListFilesTest {
    public static void main(String[] args) {
        //递归文件目录
        //1.创建目录对象
        File dir=new File("D:\\IDEA-workspace\\JavaSenior\\JavaSenior\\day08");

        //2.打印目录的子文件
        printSubFile(dir);
    }

    public static void printSubFile(File dir){
        File[] subFiles=dir.listFiles();

        for(File f:subFiles){
            if(f.isDirectory()){//文件目录
                printSubFile(f);    //递归
            }else{//文件
                System.out.println(f.getAbsolutePath());
            }
        }
    }

    //拓展1
    public long getDirectorySize(File file){
        //file是文件，那么直接返回file.length()
        //file是目录，把它的下一级的所有大小加起来就说它的总大小
        long size=0;
        if(file.isFile()){
            size+=file.length();
        }else{
            File[] all=file.listFiles();//获取file的下一级
            for(File f: all){
                size+=getDirectorySize(f);//f的大小
            }
        }
        return size;
    }

    //拓展2
    public void deleteDirectory(File file){
        //如果file是文件 直接delete
        //如果file是目录，先删下一级，再删自己
        if(file.isDirectory()){
            File[] all=file.listFiles();
            //循环删除的是file的下一级
            for(File f: all){
                deleteDirectory(f);
            }
        }
        file.delete();
    }
}
