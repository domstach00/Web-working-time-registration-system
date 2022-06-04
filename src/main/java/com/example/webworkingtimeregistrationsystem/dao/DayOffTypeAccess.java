package com.example.webworkingtimeregistrationsystem.dao;

import com.example.webworkingtimeregistrationsystem.datasource.DataSource;
import com.example.webworkingtimeregistrationsystem.model.DayOffType;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("DayOffTypeAccess")
public class DayOffTypeAccess implements DayOffTypeDao{
    private final String url = DataSource.url;

    @Override
    public boolean insertDayOffType(DayOffType dayOffType) {
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = ("INSERT INTO DayOffType " +
                    "(DayOffTypeName, Description) " +
                    "VALUES (%s, %s)")
                    .formatted(
                            DataSource.formatStringToInsert(dayOffType.getDayOffTypeName()),
                            DataSource.formatStringToInsert(dayOffType.getDescription())
                    );
            statement.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<DayOffType> selectDayOffTypes() {
        List<DayOffType> resoult = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM DayOffType";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                DayOffType newDayOffType = new DayOffType(
                                resultSet.getString("DayOffTypeName"),
                                resultSet.getString("Description"));
                newDayOffType.setIdDOT(resultSet.getInt("IdDOT"));
                resoult.add(newDayOffType);
            }
            statement.close();
            resultSet.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return resoult;
    }

    @Override
    public DayOffType selectDayOffType(int id) {
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = "SELECT IdDOT, DayOffTypeName, Description FROM DayOffType WHERE IdDOT = %d"
                    .formatted(id);
            ResultSet resultSet = statement.executeQuery(query);

            DayOffType newDayOffType = new DayOffType(
                    resultSet.getString("DayOffTypeName"),
                    resultSet.getString("Description"));
            newDayOffType.setIdDOT(resultSet.getInt("IdDOT"));
            resultSet.close();
            return newDayOffType;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
