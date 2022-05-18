package com.example.webworkingtimeregistrationsystem;

import com.example.webworkingtimeregistrationsystem.system_DO_NOT_USE_NOW.users.*;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebWorkingTimeRegistrationSystemController {

    @RequestMapping
    public String helloWord() {
        return "Hi";

    }

    @Bean
    public ProjectGroup casd(){
        return new ProjectGroup();
    }

    public User csad(){
        return new User();
    }
}
