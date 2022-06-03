package com.example.webworkingtimeregistrationsystem.api;

import com.example.webworkingtimeregistrationsystem.service.ProjectGroupService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/project-group")
@RestController
public class ProjectGroupServiceController {
    private final ProjectGroupService projectGroupService;

    public ProjectGroupServiceController(ProjectGroupService projectGroupService) {
        this.projectGroupService = projectGroupService;
    }

    // TODO: ProjectGroupServiceController
}
