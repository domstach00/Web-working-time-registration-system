package com.example.webworkingtimeregistrationsystem.service;

import com.example.webworkingtimeregistrationsystem.dao.User_ProjectGroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class User_ProjectGroupService {
    private final User_ProjectGroupDao user_projectGroupDao;

    @Autowired
    public User_ProjectGroupService(@Qualifier("User_ProjectGroupAccess") User_ProjectGroupDao user_projectGroupDao) {
        this.user_projectGroupDao = user_projectGroupDao;
    }

    // TODO: User_ProjectGroupService
}
