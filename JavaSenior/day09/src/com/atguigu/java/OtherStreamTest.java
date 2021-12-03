package com.atguigu.java;

import org.junit.Test;

import java.io.*;
import java.util.Locale;

/**
 * 其他流的使用
 * 1、标准的输入、输出流
 * 2、打印流
 * 3、数据流
 *
 * @author KeyboardHero
 * @create 2021-11-22 9:54
 */
public class OtherStreamTest {

    /*
    1.1标准的输入、输出流
    System.in:标准的输入流，默认从键盘输入
    System.out:标准的输出流，默认从控制台输出
    1.2
    System类的setIn(InputStream is)/setOut(PrintStream ps)方式重新指定输入和输出的流
     */
    public static void main(String[] args) {
        BufferedReader br = null;//缓冲流
        try {
            InputStreamReader isr = new InputStreamReader(System.in);//转换流
            br = new BufferedReader(isr);

            while (true) {
                System.out.println("请输入字符串：");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    2.打印流：PrintStream 和 PrintWriter
    提供了一系列重载的print()和println()方法
    system.out返回的是PrintStream的实例

     */
    @Test
    public void test2() {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("D:\\IDEA-workspace\\JavaSenior\\JavaSenior\\day09\\IO\\text.txt"));
            ps = new PrintStream(fos, true);
            if (ps != null) {
                System.setOut(ps);
            }
            for (int i = 0; i <= 255; i++) {
                System.out.print((char) i);
                if (i % 50 == 0) {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /*
    3.数据流
    3.1. DataInputStream和DataOutputStream
    3.2.作用：读取或写出基本数据类型的变量或字符串
    练习：将内存中的字符串、基本数据类型的变量写到文件中
     */
    @Test
    public void test3() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
        dos.writeUTF("汤姆");//字符串
        dos.flush();
        dos.writeInt(23);
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();

        dos.close();
    }

    /*
    将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量
     */
    @Test
    public void test4() throws IOException {
        DataInputStream dis=new DataInputStream(new FileInputStream("data.txt"));
        String name = dis.readUTF();
        int age=dis.readInt();
        boolean isMale=dis.readBoolean();

        System.out.println("name="+name);
        System.out.println("age="+age);
        System.out.println("isMale="+isMale);

        dis.close();
    }

}
