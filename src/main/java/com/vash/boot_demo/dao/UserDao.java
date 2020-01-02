package com.vash.boot_demo.dao;

import com.vash.boot_demo.entity.TableEntity;
import com.vash.boot_demo.entity.UserAgain;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    @Select("select * from user")
    List<UserAgain> getAllUsers();

    @Select("select * from user_table")
    List<TableEntity> getAllEntities();
}
