package com.example.webworkingtimeregistrationsystem.dao;

import com.example.webworkingtimeregistrationsystem.model.ProjectGroup;
import com.example.webworkingtimeregistrationsystem.model.User;
import com.example.webworkingtimeregistrationsystem.model.User_ProjectGroup;

import java.util.List;

public interface User_ProjectGroupDao {
    boolean insertUser_ProjectGroup(User user, ProjectGroup projectGroup);
    List<User_ProjectGroup> selectUPGs();
    List<User> usersInProject(int idU);
    List<ProjectGroup> projectsWithUser(int idPg);
}
