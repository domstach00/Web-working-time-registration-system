package com.example.webworkingtimeregistrationsystem.api;

import com.example.webworkingtimeregistrationsystem.model.Role;
import com.example.webworkingtimeregistrationsystem.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/role")
@RestController
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public boolean insertRole(@RequestBody Role role) {
        return this.roleService.insertRole(role);
    }

    @GetMapping("all")
    public List<Role> selectRoles() {
        return this.roleService.selectRoles();
    }

    @GetMapping
    public Role selectRole(int id) {
        return this.roleService.selectRole(id);
    }

    @GetMapping("accesslvl")
    public int getAccessLevel(@RequestParam int id) {
        return this.roleService.getAccessLevel(id);
    }

}
