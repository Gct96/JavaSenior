package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之二：转换流的使用
 * 1.转换流：属于字符流
 *   InputStreamReader  将一个字节的输入流转换为字符的输入流
 *   OutputStreamWriter 将一个字符的输出流转换为字节的输出流
 * 2.作用：提供字节流与字符流之间的转换
 * @author KeyboardHero
 * @create 2021-11-20 16:56
 */
public class InputStreamReaderTest {
    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream("hello.txt");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

        char[] cbuf = new char[5];
        int len;
        while ((len = isr.read(cbuf)) != -1) {
            String str = new String(cbuf, 0, len);
            System.out.print(str);
        }
        isr.close();
    }

    /*
    综合使用InputStreamReader\OutputStreamWriter，可以实现转码
     */
    @Test
    public void test2() throws IOException {
        //造文件
        File file1=new File("hello.txt");
        File file2=new File("hello3_gbk.txt");
        //造流
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        OutputStreamWriter osw=new OutputStreamWriter(fos,"gbk");
        //读写
        char[] cbuf=new char[5];
        int len;
        while((len=isr.read(cbuf))!=-1){
            osw.write(cbuf,0,len);
        }
        isr.close();
        osw.close();
    }

}
