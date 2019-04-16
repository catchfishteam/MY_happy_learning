package com.shenzk.web.dao;

import com.shenzk.web.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    User getUserById(@Param("id") int id);

    List<User> getUserList();

    int updateUser(@Param("user") User user);

    int insertUser(@Param("user") User user);

    int deleteUser(@Param("id") int id);

}
