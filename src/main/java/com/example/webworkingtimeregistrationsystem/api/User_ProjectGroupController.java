package com.example.webworkingtimeregistrationsystem.api;

import com.example.webworkingtimeregistrationsystem.service.User_ProjectGroupService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/user-project")
@RestController
public class User_ProjectGroupController {
    private final User_ProjectGroupService u_pgService;

    public User_ProjectGroupController(User_ProjectGroupService u_pgService) {
        this.u_pgService = u_pgService;
    }

    //  TODO: User_ProjectGroupController
}
