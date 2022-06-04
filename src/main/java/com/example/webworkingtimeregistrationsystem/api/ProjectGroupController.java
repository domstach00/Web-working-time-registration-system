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
    public boolean insertProjectGroup(@RequestBody ProjectGroup projectGroup) {
        return this.projectGroupService.insertProjectGroup(projectGroup);
    }

    @GetMapping("all")
    public List<ProjectGroup> selectProjectGroups(){
        return this.projectGroupService.selectProjectGroups();
    }

    @GetMapping
    public ProjectGroup selectProjectGroup(@RequestParam int id) {
        return this.projectGroupService.selectProjectGroup(id);
    }

    @GetMapping("project-name")
    public ProjectGroup selectProjectGroup(@RequestParam String projectName) {
        return this.projectGroupService.selectProjectGroup(projectName);
    }

}
