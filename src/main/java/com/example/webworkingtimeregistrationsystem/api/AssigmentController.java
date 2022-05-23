package com.example.webworkingtimeregistrationsystem.api;

import com.example.webworkingtimeregistrationsystem.model.Assigment;
import com.example.webworkingtimeregistrationsystem.service.AssigmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/assigment")
@RestController
public class AssigmentController {
    private final AssigmentService assigmentService;

    @Autowired
    public AssigmentController(AssigmentService assigmentService) {
        this.assigmentService = assigmentService;
    }

    @GetMapping
    public List<Assigment> getAllAssigments(){
        return assigmentService.selectAssigments();
    }
}
