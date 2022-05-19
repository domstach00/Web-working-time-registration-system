package com.example.webworkingtimeregistrationsystem.dao;

import com.example.webworkingtimeregistrationsystem.datasource.DataSource;
import com.example.webworkingtimeregistrationsystem.model.DayOffType;
import com.example.webworkingtimeregistrationsystem.model.Event;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Date;
import java.util.ArrayList;

import java.util.List;

@Repository("EventAccess")
public class EventAccess implements EventDao {
    private final static String url = DataSource.url;

    @Override
    public boolean insertEvent(Event event) {
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = ("INSERT INTO Event " +
                    "(Description, StartDate, EndDate) " +
                    "VALUES (%s, %s, %s)")
                    .formatted(
                            DataSource.formatStringToInsert(event.getDescription()),
                            DataSource.formatDateToInsert(event.getDateFromString(event.getStartDate())),
                            DataSource.formatDateToInsert(event.getDateFromString(event.getEndDate()))
                    );
            statement.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Event> selectEvents() {
        List<Event> resoult = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM Event";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Event newEvent = new Event(
                        resultSet.getString("Description"),
                        resultSet.getDate("StartDate").toString(),
                        resultSet.getDate("EndDate").toString());
                newEvent.setIdE(resultSet.getInt("IdE"));
                resoult.add(newEvent);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return resoult;
    }

    @Override
    public List<Event> selectEvents(Date startDate, Date endDate) {
        List<Event> resoult = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = ("SELECT * " +
                    "FROM Event " +
                    "WHERE StartDate <= %s " +
                    "AND EndDate >= %s")
                    .formatted(
                            DataSource.formatDateToInsert(startDate),
                            DataSource.formatDateToInsert(endDate)
                    );
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Event newEvent = new Event(
                        resultSet.getString("Description"),
                        resultSet.getDate("StartDate").toString(),
                        resultSet.getDate("EndDate").toString());
                newEvent.setIdE(resultSet.getInt("IdE"));
                resoult.add(newEvent);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return resoult;
    }

    @Override
    public Event selectEvent(int id) {
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM Event WHERE IdE = %d"
                    .formatted(id);
            ResultSet resultSet = statement.executeQuery(query);

            Event newEvent = new Event(
                    resultSet.getString("Description"),
                    resultSet.getDate("StartDate").toString(),
                    resultSet.getDate("EndDate").toString());
            newEvent.setIdE(resultSet.getInt("IdE"));
            return newEvent;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}