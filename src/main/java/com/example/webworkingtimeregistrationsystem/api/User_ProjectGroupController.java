package com.example.webworkingtimeregistrationsystem.api;

import com.example.webworkingtimeregistrationsystem.model.ProjectGroup;
import com.example.webworkingtimeregistrationsystem.model.User;
import com.example.webworkingtimeregistrationsystem.model.User_ProjectGroup;
import com.example.webworkingtimeregistrationsystem.service.User_ProjectGroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/user-project")
@RestController
public class User_ProjectGroupController {
    private final User_ProjectGroupService u_pgService;

    public User_ProjectGroupController(User_ProjectGroupService u_pgService) {
        this.u_pgService = u_pgService;
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public boolean insertUser_ProjectGroup(@RequestBody User_ProjectGroup user_projectGroup) {
        return this.u_pgService.insertUser_ProjectGroup(user_projectGroup);
    }

    @GetMapping("all")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<User_ProjectGroup> selectU_PGs() {
        return this.u_pgService.selectU_PGs();
    }

    @GetMapping("users")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<User> selectUsersInProject(@RequestParam int id) {
        return this.u_pgService.selectUsersInProject(id);
    }

    @GetMapping("projects")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<ProjectGroup> selectProjectsWithUser(@RequestParam int id) {
        return this.u_pgService.selectProjectsWithUser(id);
    }
}
