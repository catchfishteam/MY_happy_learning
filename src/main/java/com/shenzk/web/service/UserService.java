package com.shenzk.web.service;

import com.shenzk.web.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    User getUserById(int id);

    List<User> getUserList();

    int updateUser( User user);

    int insertUser( User user);

    int deleteUser( int id);
}
