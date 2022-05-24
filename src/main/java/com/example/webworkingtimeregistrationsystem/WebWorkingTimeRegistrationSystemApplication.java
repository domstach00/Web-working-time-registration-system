package com.example.webworkingtimeregistrationsystem;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

@SpringBootApplication
public class WebWorkingTimeRegistrationSystemApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WebWorkingTimeRegistrationSystemApplication.class, args);


//        ProjectGroup projectGroup = context.getBean(ProjectGroup.class);
//
//        User user = context.getBean(User.class);


//        String url = "jdbc:sqlite:src/database/project.db";
//        try {
//            Connection connection = DriverManager.getConnection(url);
//            Statement statement = connection.createStatement();
//
//            ResultSet result = statement.executeQuery("SELECT * FROM User");
//
//            while (result.next()){
//                System.out.println(result.getString("Email"));
//            }
//
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
    }
}
