package com.example.webworkingtimeregistrationsystem.service;

import com.example.webworkingtimeregistrationsystem.dao.ProjectGroupDao;
import com.example.webworkingtimeregistrationsystem.model.ProjectGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectGroupService {
    private final ProjectGroupDao projectGroupDao;

    @Autowired
    public ProjectGroupService(@Qualifier("ProjectGroupAccess") ProjectGroupDao projectGroupDao) {
        this.projectGroupDao = projectGroupDao;
    }

    public boolean insertProjectGroup(ProjectGroup projectGroup) {
        return this.projectGroupDao.insertProjectGroup(projectGroup);
    }

    public List<ProjectGroup> selectProjectGroups() {
        return this.projectGroupDao.selectProjectGroups();
    }

    public ProjectGroup selectProjectGroup(int id) {
        return this.projectGroupDao.selectProjectGroup(id);
    }

    public ProjectGroup selectProjectGroup(String projectName) {
        return this.projectGroupDao.selectProjectGroup(projectName);
    }
}
