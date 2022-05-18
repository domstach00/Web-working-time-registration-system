package com.example.webworkingtimeregistrationsystem.service;

import com.example.webworkingtimeregistrationsystem.dao.UserDao;
import com.example.webworkingtimeregistrationsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("UserAccess") UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean insertUser(User user){
        return userDao.insertUser(user);
    }

    public List<User> selectAllUsers(){
        return userDao.selectUsers();
    }

    public User selectUser(int id){
        return userDao.selectUser(id);
    }
}
