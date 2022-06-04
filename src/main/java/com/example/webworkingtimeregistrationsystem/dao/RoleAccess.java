package com.example.webworkingtimeregistrationsystem.dao;

import com.example.webworkingtimeregistrationsystem.datasource.DataSource;
import com.example.webworkingtimeregistrationsystem.model.Role;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("RoleAccess")
public class RoleAccess implements RoleDao {
    private final String url = DataSource.url;

    @Override
    public boolean insertRole(Role role) {
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = ("INSERT INTO Role" +
                    "(RoleName, AccessLevel) " +
                    "VALUES (%s, %d)")
                    .formatted(
                            DataSource.formatStringToInsert(role.getRoleName()),
                            role.getAccessLevel()
                    );
            statement.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Role> selectRoles() {
        List<Role> resoult = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM Role";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Role newRole = new Role(
                        resultSet.getString("RoleName"),
                        resultSet.getInt("AccessLevel"));
                newRole.setIdU(resultSet.getInt("IdR"));
                resoult.add(newRole);
            }
            resultSet.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return resoult;
    }

    @Override
    public Role selectRole(int id) {
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = "SELECT IdR, RoleName, AccessLevel FROM Role WHERE IdR = %d"
                    .formatted(id);
            ResultSet resultSet = statement.executeQuery(query);

            Role newRole = new Role(
                    resultSet.getString("RoleName"),
                    resultSet.getInt("AccessLevel"));
            newRole.setIdU(resultSet.getInt("IdR"));
            resultSet.close();
            return newRole;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public int getAccessLevel(int idRole) {
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = "SELECT AccessLevel FROM Role WHERE IdR = %d"
                    .formatted(idRole);
            ResultSet resultSet = statement.executeQuery(query);

            int access = resultSet.getInt("AccessLevel");
            resultSet.close();
            return access;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }
}
