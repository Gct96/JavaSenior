package com.atguigu.java1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 实例化InetAddress：两个方法getByName\getLocalHost
 *      两个常用方法：getHostName、getHostAddress
 * @author KeyboardHero
 * @create 2021-12-03 17:08
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);

            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);

            //getHostName() 域名
            System.out.println(inet2.getHostName());
            //getHostAddress() 地址
            System.out.println(inet2.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
