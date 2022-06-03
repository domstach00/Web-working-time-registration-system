package com.example.webworkingtimeregistrationsystem.api;

import com.example.webworkingtimeregistrationsystem.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/role")
@RestController
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    // TODO: RoleController
}
