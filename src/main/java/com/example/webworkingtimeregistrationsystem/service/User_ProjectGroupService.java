package com.example.webworkingtimeregistrationsystem.service;

import com.example.webworkingtimeregistrationsystem.dao.User_ProjectGroupDao;
import com.example.webworkingtimeregistrationsystem.model.ProjectGroup;
import com.example.webworkingtimeregistrationsystem.model.User;
import com.example.webworkingtimeregistrationsystem.model.User_ProjectGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User_ProjectGroupService {
    private final User_ProjectGroupDao user_projectGroupDao;

    @Autowired
    public User_ProjectGroupService(@Qualifier("User_ProjectGroupAccess") User_ProjectGroupDao user_projectGroupDao) {
        this.user_projectGroupDao = user_projectGroupDao;
    }

    public boolean insertUser_ProjectGroup(User_ProjectGroup user_projectGroup) {
        return this.user_projectGroupDao.insertUser_ProjectGroup(user_projectGroup);
    }

    public List<User_ProjectGroup> selectU_PGs() {
        return this.user_projectGroupDao.selectUPGs();
    }

    public List<User> selectUsersInProject(int idU) {
        return this.user_projectGroupDao.selectUsersInProject(idU);
    }

    public List<ProjectGroup> selectProjectsWithUser(int idPg) {
        return this.user_projectGroupDao.selectProjectsWithUser(idPg);
    }
}
