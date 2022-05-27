package com.example.webworkingtimeregistrationsystem.dao;

import com.example.webworkingtimeregistrationsystem.model.ProjectGroup;

import java.util.List;

public interface ProjectGroupDao {
    // TODO: ProjectGroupDao
    boolean insertProjectGroup(ProjectGroup projectGroup);
    List<ProjectGroup> selectProjectGroups();
    ProjectGroup selectProjectGroup(int id);
    ProjectGroup slectProjectGroup(String projectName);
}
