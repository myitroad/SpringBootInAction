package com.vash.boot_demo;

import com.vash.boot_demo.dao.UserDao;
import com.vash.boot_demo.entity.TableEntity;
import com.vash.boot_demo.entity.UserAgain;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class ReadingListApplicationTests {


    @Test
    void contextLoads() {

    }

    @Autowired
    UserDao userDao;

    @Test
    void testDao() {
        List<UserAgain> allUsers = userDao.getAllUsers();
        System.err.println(allUsers);
    }

    @Test
    void testDao1() {
        List<TableEntity> allUsers = userDao.getAllEntities();
        System.err.println(allUsers);
    }


}
