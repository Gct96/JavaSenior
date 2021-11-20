package com.atguigu.java;

import com.sun.scenario.effect.Offset;
import org.junit.Test;

import java.io.*;

/**
 * 测试FileInputStream和FileOutputStream的使用
 * 结论：
 * 1.对于文本文件，使用字符流处理
 * 2.对于非文本文件，使用字节流处理
 * @author KeyboardHero
 * @create 2021-11-20 14:51
 */
public class FileInputOutputStreamTest {
    //字节流处理文本文件在内存读可能会有乱码，特别是带有中文时
    @Test
    public void testFileInputStream()  {
        FileInputStream fis = null;
        try {
            //1.造文件
            File file=new File("hello.txt");
            //2.造流
            fis = new FileInputStream(file);
            //3.读数据
            byte[] buffer=new byte[5];
            int len;//记录每次读取的字节的个数
            while((len=fis.read(buffer))!=-1){
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!=null) {
                try {
                    //4.关闭资源
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    实现对图片的复制操作
     */
    @Test
    public void testFileInputOutputStream()  {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile=new File("示例.png");
            File destFile=new File("示例1.png");
            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //复制的过程
            byte[] buffer=new byte[5];
            int len;
            while((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos!=null){
                //关闭
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //指定路径下文件的复制
    public void copyFile(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile=new File(srcPath);
            File destFile=new File(destPath);
            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //复制的过程
            byte[] buffer=new byte[1024];
            int len;
            while((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos!=null){
                //关闭
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopyFile(){
        long start=System.currentTimeMillis();
        String srcPath="D:\\迅雷下载\\lihuanying.mp4";
        String destPath="D:\\迅雷下载\\lihuanying1.mp4";
        copyFile(srcPath,destPath);
        long end=System.currentTimeMillis();

        System.out.println("复制操作花费的时间为:"+(end-start));//37480
    }
}
