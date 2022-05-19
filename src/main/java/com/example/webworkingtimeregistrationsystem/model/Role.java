package com.example.webworkingtimeregistrationsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Role {
    private int idU;
    private String RoleName;
    private int AccessLevel;

    public Role(@JsonProperty("roleName") String roleName,
                @JsonProperty("accessLevel") int accessLevel) {
        RoleName = roleName;
        AccessLevel = accessLevel;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public int getAccessLevel() {
        return AccessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        AccessLevel = accessLevel;
    }
}