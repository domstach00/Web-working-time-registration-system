package com.example.webworkingtimeregistrationsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebWorkingTimeRegistrationSystemController {

    @RequestMapping
    public String helloWord() {
        return "Hi";

    }

}
