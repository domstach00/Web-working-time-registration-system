package com.example.webworkingtimeregistrationsystem.dao;

import com.example.webworkingtimeregistrationsystem.datasource.DataSource;
import com.example.webworkingtimeregistrationsystem.model.DayOff;
import com.example.webworkingtimeregistrationsystem.model.Event;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository("DayOffAccess")
public class DayOffAccess extends EventAccess implements DayOffDao {
    private final static String url = DataSource.url;


    @Override
    public boolean insertDayOff(DayOff dayOff) {
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            insertEvent(dayOff.getEvetFromDayOff());
            int idEvent = idEvent(dayOff.getEvetFromDayOff());
            String query = ("INSERT INTO DayOff " +
                    "(Fk_DayOffType, Fk_Event, Fk_User) " +
                    "VALUES (%d, %d, %d)")
                    .formatted(
                            dayOff.getFk_dayOffType(),
                            idEvent,
                            dayOff.getFk_user()
                    );
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<DayOff> selectDayOff() {
        List<DayOff> result = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM DayOff " +
                    "INNER JOIN Event E on E.IdE = DayOff.Fk_Event";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Event event = new Event(
                        resultSet.getString("Description"),
                        resultSet.getDate("StartDate").toString(),
                        resultSet.getDate("EndDate").toString()
                );
                event.setIdE(resultSet.getInt("IdE"));

                DayOff dayOff = new DayOff(
                        event,
                        resultSet.getInt("Fk_DayOffType"),
                        resultSet.getInt("Fk_User")
                );
                dayOff.setIdDO(resultSet.getInt("IdDO"));
                dayOff.setFk_event(resultSet.getInt("Fk_Event"));
                dayOff.setIdE(selectEvent(resultSet.getInt("Fk_Event")).getIdE());
                result.add(dayOff);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public List<DayOff> selectDayOff(Date startDate, Date endDate) {
        List<DayOff> result = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = ("SELECT * FROM DayOff " +
                    "INNER JOIN Event E on E.IdE = DayOff.Fk_Event " +
                    "WHERE E.StartDate >= %s " +
                    "AND E.EndDate <= %s")
                    .formatted(
                            DataSource.formatDateToInsert(startDate),
                            DataSource.formatDateToInsert(endDate)
                    );
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Event event = new Event(
                        resultSet.getString("Description"),
                        resultSet.getDate("StartDate").toString(),
                        resultSet.getDate("EndDate").toString()
                );
                event.setIdE(resultSet.getInt("IdE"));

                DayOff dayOff = new DayOff(
                        event,
                        resultSet.getInt("Fk_DayOffType"),
                        resultSet.getInt("Fk_User")
                );
                dayOff.setIdDO(resultSet.getInt("IdDO"));
                dayOff.setFk_event(resultSet.getInt("Fk_Event"));
                dayOff.setIdE(selectEvent(resultSet.getInt("Fk_Event")).getIdE());
                result.add(dayOff);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public DayOff selectDayOff(int id) {
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = ("SELECT * FROM DayOff " +
                    "WHERE IdDO = %d")
                    .formatted(id);
            ResultSet resultSet = statement.executeQuery(query);
            Event event = new Event(
                    resultSet.getString("Description"),
                    resultSet.getDate("StartDate").toString(),
                    resultSet.getDate("EndDate").toString()
            );
            event.setIdE(resultSet.getInt("IdE"));

            DayOff dayOff = new DayOff(
                    event,
                    resultSet.getInt("Fk_DayOffType"),
                    resultSet.getInt("Fk_User")
            );
            dayOff.setIdDO(resultSet.getInt("IdDO"));
            dayOff.setFk_event(resultSet.getInt("Fk_Event"));
            dayOff.setIdE(selectEvent(resultSet.getInt("Fk_Event")).getIdE());
            resultSet.close();
            return dayOff;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
