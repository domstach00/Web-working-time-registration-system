package com.example.webworkingtimeregistrationsystem.dao;

import com.example.webworkingtimeregistrationsystem.model.User;

import java.util.List;

public interface UserDao {
    boolean insertUser(User user);
    List<User> selectUsers();
    User selectUser(int id);
    User selectUser(String email);
    User selectUser(String email, String password);

}
