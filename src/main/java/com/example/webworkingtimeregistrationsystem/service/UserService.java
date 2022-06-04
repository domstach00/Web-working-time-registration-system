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
        return this.userDao.insertUser(user);
    }

    public List<User> selectUsers(){
        return this.userDao.selectUsers();
    }

    public User selectUser(int id){
        return this.userDao.selectUser(id);
    }

    public User selectUser(String email) {
        return this.userDao.selectUser(email);
    }

    public User selectUser(String email, String password) {
        return this.userDao.selectUser(email, password);
    }

    public boolean updateUser(User user) {
        return this.userDao.updateUser(user);
    }
}
