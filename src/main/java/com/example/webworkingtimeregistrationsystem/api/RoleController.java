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
    @CrossOrigin(origins = "http://localhost:8080")
    public boolean insertRole(@RequestBody Role role) {
        return this.roleService.insertRole(role);
    }

    @GetMapping("all")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<Role> selectRoles() {
        return this.roleService.selectRoles();
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public Role selectRole(int id) {
        return this.roleService.selectRole(id);
    }

    @GetMapping("accesslvl")
    @CrossOrigin(origins = "http://localhost:8080")
    public int getAccessLevel(@RequestParam int id) {
        return this.roleService.getAccessLevel(id);
    }

}
