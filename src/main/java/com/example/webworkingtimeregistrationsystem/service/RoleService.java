package com.example.webworkingtimeregistrationsystem.service;

import com.example.webworkingtimeregistrationsystem.dao.RoleDao;
import com.example.webworkingtimeregistrationsystem.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleDao roleDao;

    @Autowired
    public RoleService(@Qualifier("RoleAccess") RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public boolean insertRole(Role role) {
        return this.roleDao.insertRole(role);
    }

    public List<Role> selectRoles() {
        return this.roleDao.selectRoles();
    }

    public Role selectRole(int id) {
        return this.roleDao.selectRole(id);
    }

    public int getAccessLevel(int idRole) {
        return this.roleDao.getAccessLevel(idRole);
    }
}
