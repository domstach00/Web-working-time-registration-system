package com.example.webworkingtimeregistrationsystem.dao;

import com.example.webworkingtimeregistrationsystem.datasource.DataSource;
import com.example.webworkingtimeregistrationsystem.model.ProjectGroup;
import com.example.webworkingtimeregistrationsystem.model.User;
import com.example.webworkingtimeregistrationsystem.model.User_ProjectGroup;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("User_ProjectGroupAccess")
public class User_ProjectGroupAccess implements User_ProjectGroupDao {
    private final static String url = DataSource.url;

    @Override
    public boolean insertUser_ProjectGroup(User user, ProjectGroup projectGroup) {
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = "INSERT INTO User_ProjectGroup " +
                    "(UserIdU, ProjectGroupIdPG) " +
                    "VALUES (%d, %d)"
                    .formatted(
                            user.getIdU(),
                            projectGroup.getIdPG()
                    );
            statement.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean insertUser_ProjectGroup(User_ProjectGroup user_projectGroup) {
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = "INSERT INTO User_ProjectGroup " +
                    "(UserIdU, ProjectGroupIdPG) " +
                    "VALUES (%d, %d)"
                            .formatted(
                                    user_projectGroup.getIdU(),
                                    user_projectGroup.getIdPG()
                            );
            statement.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<User_ProjectGroup> selectUPGs() {
        List<User_ProjectGroup> result = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM User_ProjectGroup";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                User_ProjectGroup user_projectGroup = new User_ProjectGroup(
                        resultSet.getInt("UserIdU"),
                        resultSet.getInt("ProjectGroupIdPG")
                );
            }
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public List<User> selectUsersInProject(int idU) {
        List<User> result = new ArrayList<>();
        List<Integer> userIdList = new ArrayList<>();
        UserAccess userAccess = new UserAccess();
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = ("SELECT UserIdU FROM User_ProjectGroup " +
                    "WHERE ProjectGroupIdPG = %d")
                    .formatted(idU);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next())
                userIdList.add(resultSet.getInt("UserIdU"));

            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        for (Integer id : userIdList)
            result.add(userAccess.selectUser(id));

        return result;
    }

    @Override
    public List<ProjectGroup> selectProjectsWithUser(int idPg) {
        List<ProjectGroup> result = new ArrayList<>();
        List<Integer> projectIdList = new ArrayList<>();
        ProjectGroupAccess projectGroupAccess = new ProjectGroupAccess();
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = ("SELECT ProjectGroupIdPG FROM User_ProjectGroup " +
                    "WHERE UserIdU = %d")
                    .formatted(idPg);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next())
                projectIdList.add(resultSet.getInt("ProjectGroupIdPG"));

            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        for (Integer id : projectIdList)
            result.add(projectGroupAccess.selectProjectGroup(id));


        return result;
    }
}
