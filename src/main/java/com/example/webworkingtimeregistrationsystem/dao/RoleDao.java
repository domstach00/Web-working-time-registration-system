package com.example.webworkingtimeregistrationsystem.dao;

import com.example.webworkingtimeregistrationsystem.model.Role;

import java.util.List;

public interface RoleDao {
    boolean insertRole(Role role);
    List<Role> selectRoles();
    Role selectRole(int id);
    int getAccessLevel(int idRole);
}
