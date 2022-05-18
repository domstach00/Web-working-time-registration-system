package com.example.webworkingtimeregistrationsystem.dao;

import com.example.webworkingtimeregistrationsystem.model.User;

import java.util.List;

public interface UserDao {
    boolean insertUser(User user);
    List<User> selectUsers();

}
