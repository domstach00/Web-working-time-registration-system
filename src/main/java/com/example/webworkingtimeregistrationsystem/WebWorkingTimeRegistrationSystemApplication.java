package com.example.webworkingtimeregistrationsystem;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

@SpringBootApplication
public class WebWorkingTimeRegistrationSystemApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WebWorkingTimeRegistrationSystemApplication.class, args);
    }
}
