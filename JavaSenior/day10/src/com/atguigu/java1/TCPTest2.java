package com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 * 实现TCP的网络编程
 * 客户端发送文件给服务端，服务端将文件保存在本地。并返回“发送成功”给客户端
 * @author KeyboardHero
 * @create 2021-12-03 20:18
 */
public class TCPTest2 {
    @Test
    public void client() throws IOException {
        Socket socket=new Socket(InetAddress.getByName("127.0.0.1"),9090);
        OutputStream os=socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("示例.png"));
        byte[] buffer=new byte[1024];
        int len;
        while((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        //停止传输数据
        socket.shutdownOutput();
        //接受到服务器端的反馈并输出到控制台
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        byte[] buffer1=new byte[20];
        int len1;
        while((len1=is.read(buffer))!=-1){
            baos.write(buffer,0,len1);
        }
        System.out.println(baos.toString());
        is.close();
        baos.close();
        fis.close();
        os.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(9090);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("示例2.png"));
        byte[] buffer=new byte[1024];
        int len;
        while((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        //服务器端给予反馈
        OutputStream os = socket.getOutputStream();
        os.write("服务器端已收到照片！".getBytes());

        os.close();
        fos.close();
        is.close();
        socket.close();
        ss.close();
    }


}
