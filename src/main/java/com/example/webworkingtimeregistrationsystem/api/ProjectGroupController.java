package com.example.webworkingtimeregistrationsystem.api;

import com.example.webworkingtimeregistrationsystem.model.ProjectGroup;
import com.example.webworkingtimeregistrationsystem.service.ProjectGroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/project-group")
@RestController
public class ProjectGroupController {
    private final ProjectGroupService projectGroupService;

    public ProjectGroupController(ProjectGroupService projectGroupService) {
        this.projectGroupService = projectGroupService;
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public boolean insertProjectGroup(@RequestBody ProjectGroup projectGroup) {
        return this.projectGroupService.insertProjectGroup(projectGroup);
    }

    @GetMapping("all")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<ProjectGroup> selectProjectGroups(){
        return this.projectGroupService.selectProjectGroups();
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public ProjectGroup selectProjectGroup(@RequestParam int id) {
        return this.projectGroupService.selectProjectGroup(id);
    }

    @GetMapping("project-name")
    @CrossOrigin(origins = "http://localhost:8080")
    public ProjectGroup selectProjectGroup(@RequestParam String projectName) {
        return this.projectGroupService.selectProjectGroup(projectName);
    }

}
