package com.example.webworkingtimeregistrationsystem;

import java.sql.Statement;
import com.sun.jdi.connect.spi.Connection;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.DriverManager;
import java.sql.SQLException;

@RestController
public class WebWorkingTimeRegistrationSystemController {

    @RequestMapping
    public String helloWord() {
        return "Hi";

    }
}
