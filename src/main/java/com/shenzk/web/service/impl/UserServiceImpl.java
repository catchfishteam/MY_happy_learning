package com.shenzk.web.service.impl;

import com.shenzk.web.domain.User;
import com.shenzk.web.dao.UserDao;
import com.shenzk.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(int id){
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getUserList() {
        List<User> list =  userDao.getUserList();
        return list;
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);

    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }
}
