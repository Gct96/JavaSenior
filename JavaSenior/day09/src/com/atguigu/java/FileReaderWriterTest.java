package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 一、流的分类
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.流的角色：节点流、处理流
 *
 * 二、流的体系结构
 * 抽象基类           节点流（文件流）         处理流（缓冲流）
 * InputStream        FileInputStream       BufferedInputStream
 * OutputStream       FileOutputStream      BufferedOutputStream
 * Reader             FileReader            BufferedReader  readline()
 * Writer             FileWriter            BufferedWriter
 * @author KeyboardHero
 * @create 2021-11-19 19:55
 */
public class FileReaderWriterTest {
    /*
    将day09下的hello.txt文件内容读入到程序中，并输出到控制台
     */
    @Test
    public void testFileReader()  {
        FileReader fr=null;
        try {
            //1.实例化File类的对象，指明操作的文件,文件一定要存在，否则报错
            File file=new File("hello.txt");//相较于当前Module
            //2.提供具体的流
            fr =new FileReader(file);
            //3.数据的读入
            //read()返回读入的一个字符，如果达到文件末尾，返回-1
            int data = fr.read();
            while(data!=-1){
                System.out.print((char)data);
                data=fr.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭操作
            if(fr!=null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*从内存中写出数据到硬盘文件里
       说明：
       1.输出操作，对应的File可以不存在，会自动创建，
          如存在，FileWriter(file,false)则覆盖写。
          FileWriter(file,true)则追加写
     */
    @Test
    public void testFileWriter()  {
        FileWriter fw= null;
        try {
            //1.提供File类的对象，指明写出到的文件
            File file=new File("hello1.txt");
            //2.提供流
            fw = new FileWriter(file,false);
            //3.写出的操作
            fw.write("I have a dream!\n");
            fw.write("you need to have a dream!");
            //4.流资源的关闭
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fw!=null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFileReaderFileWriter(){
        //2.提供读写节点流
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.创建File类的对象
            File file1 = new File("hello.txt");
            File file2 = new File("hello2.txt");
            fr=new FileReader(file1);
            fw=new FileWriter(file2);
            int data;
            while((data=fr.read())!=-1){
                fw.write((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
