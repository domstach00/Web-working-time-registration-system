package com.example.webworkingtimeregistrationsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class ProjectGroup {
    private int idPG;
    @NotBlank
    private String projectName;

    public ProjectGroup(@JsonProperty("projectName") String projectName) {
        this.projectName = projectName;
    }

    public int getIdPG() {
        return idPG;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


}