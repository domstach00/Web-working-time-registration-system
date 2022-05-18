package com.example.webworkingtimeregistrationsystem;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class WebWorkingTimeRegistrationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebWorkingTimeRegistrationSystemApplication.class, args);

        String url = "jdbc:sqlite:src/database/project.db";
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM User");

            while (result.next()){
                System.out.println(result.getString("Email"));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
