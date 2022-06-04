package com.example.webworkingtimeregistrationsystem.dao;

import com.example.webworkingtimeregistrationsystem.datasource.DataSource;
import com.example.webworkingtimeregistrationsystem.model.ProjectGroup;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("ProjectGroupAccess")
public class ProjectGroupAccess implements ProjectGroupDao {
    private final static String url = DataSource.url;

    @Override
    public boolean insertProjectGroup(ProjectGroup projectGroup) {
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = ("INSERT INTO ProjectGroup " +
                    "(ProjectName) " +
                    "VALUES (%s)")
                    .formatted(
                            DataSource.formatStringToInsert(projectGroup.getProjectName())
                    );
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<ProjectGroup> selectProjectGroups() {
        List<ProjectGroup> resoult = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM ProjectGroup";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                ProjectGroup projectGroup = new ProjectGroup(
                        resultSet.getString("ProjectName")
                );
                projectGroup.setIdPG(resultSet.getInt("IdPG"));


                resoult.add(projectGroup);
            }
            resultSet.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return resoult;
        }
        return resoult;
    }

    @Override
    public ProjectGroup selectProjectGroup(int id) {
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = ("SELECT * FROM ProjectGroup " +
                    "WHERE IdPG = %d")
                    .formatted(id);
            ResultSet resultSet = statement.executeQuery(query);
            ProjectGroup projectGroup = new ProjectGroup(
                    resultSet.getString("ProjectName")
            );
            projectGroup.setIdPG(resultSet.getInt("IdPG"));

            resultSet.close();
            return projectGroup;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public ProjectGroup selectProjectGroup(String projectName) {
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = ("SELECT * FROM ProjectGroup " +
                    "WHERE ProjectName = %s")
                    .formatted(projectName);
            ResultSet resultSet = statement.executeQuery(query);
            ProjectGroup projectGroup = new ProjectGroup(
                    DataSource.formatStringToInsert(projectName)
            );
            projectGroup.setIdPG(resultSet.getInt("IdPG"));

            resultSet.close();
            return projectGroup;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
