package com.example.webworkingtimeregistrationsystem.service;

import com.example.webworkingtimeregistrationsystem.dao.ProjectGroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProjectGroupService {
    private final ProjectGroupDao projectGroupDao;

    @Autowired
    public ProjectGroupService(@Qualifier("ProjectGroupAccess") ProjectGroupDao projectGroupDao) {
        this.projectGroupDao = projectGroupDao;
    }

    // TODO: ProjectGroupService
}
