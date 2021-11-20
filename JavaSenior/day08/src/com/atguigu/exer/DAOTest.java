package com.atguigu.exer;

import java.util.List;

/**
 * @author KeyboardHero
 * @create 2021-11-19 10:46
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao=new DAO<User>();

        dao.save("1001",new User(1001,34,"Jack"));
        dao.save("1002",new User(1002,20,"Mike"));
        dao.save("1003",new User(1003,25,"Tom"));

        dao.update("1003",new User(1003,30,"Jerry"));

        dao.delete("1002");
        List<User> list = dao.list();
        System.out.println(list);


    }
}
