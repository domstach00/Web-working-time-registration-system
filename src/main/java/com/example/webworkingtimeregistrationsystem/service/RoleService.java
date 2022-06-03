package com.example.webworkingtimeregistrationsystem.service;

import com.example.webworkingtimeregistrationsystem.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleDao roleDao;

    @Autowired
    public RoleService(@Qualifier("RoleAccess") RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    // TODO: RoleService
}
