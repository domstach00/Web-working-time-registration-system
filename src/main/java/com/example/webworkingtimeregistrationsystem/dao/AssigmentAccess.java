package com.example.webworkingtimeregistrationsystem.dao;

import com.example.webworkingtimeregistrationsystem.model.Assigment;

import com.example.webworkingtimeregistrationsystem.datasource.DataSource;
import com.example.webworkingtimeregistrationsystem.model.Event;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Repository("AssigmentAccess")
public class AssigmentAccess extends EventAccess implements AssigmentDao {
    private final static String url = DataSource.url;

    @Override
    public boolean insertAssigment(Assigment assigment) {
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String queryEvent = ("INSERT INTO Event " +
                    "(Description, StartDate, EndDate) " +
                    "VALUES (%s, %s, %s)")
                    .formatted(
                            DataSource.formatStringToInsert(assigment.getDescription()),
                            DataSource.formatDateToInsert(assigment.getDateFromString(assigment.getStartDate())),
                            DataSource.formatDateToInsert(assigment.getDateFromString(assigment.getEndDate()))
                    );
            statement.executeUpdate(queryEvent);
            String newQuery = "SELECT IdE FROM Event WHERE Description = %s AND StartDate = %s AND EndDate = %s"
                    .formatted(
                            DataSource.formatStringToInsert(assigment.getDescription()),
                            DataSource.formatDateToInsert(assigment.getStartDate()),
                            DataSource.formatDateToInsert(assigment.getEndDate())
                            );
            int idE = statement.executeQuery(newQuery).getInt("IdE");

            String query = ("INSERT INTO Assigment " +
                    "(IsComplete, Fk_ProjectGroup, Fk_Event)" +
                    "VALUES (%d, %d, %d) ")
                    .formatted(
                            assigment.getIsComplete(),
                            assigment.getFk_projectGroup(),
                            idE
                    );
            statement.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Assigment> selectAssigments() {
        List<Assigment> result = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM Assigment INNER JOIN Event E on E.IdE = Assigment.Fk_Event";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Event event = new Event(
                        resultSet.getString("Description"),
                        resultSet.getDate("StartDate").toString(),
                        resultSet.getDate("EndDate").toString()
                );
                event.setIdE(resultSet.getInt("IdE"));

                Assigment assigment = new Assigment(
                        event,
                        resultSet.getInt("IsComplete"),
                        resultSet.getInt("Fk_ProjectGroup")
                );
                assigment.setIdA(resultSet.getInt("IdA"));
                assigment.setFk_event(resultSet.getInt("Fk_Event"));
                assigment.setIdE(selectEvent(resultSet.getInt("Fk_Event")).getIdE());
                result.add(assigment);
            }
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Assigment> selectAssigments(Date startDate, Date endDate) {
        List<Assigment> result = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = ("SELECT * FROM Assigment " +
                    "INNER JOIN Event E on E.IdE = Assigment.Fk_Event " +
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

                Assigment assigment = new Assigment(
                        event,
                        resultSet.getInt("IsComplete"),
                        resultSet.getInt("Fk_ProjectGroup")
                );
                assigment.setIdA(resultSet.getInt("IdA"));
                assigment.setFk_event(resultSet.getInt("Fk_Event"));
                assigment.setIdE(selectEvent(resultSet.getInt("Fk_Event")).getIdE());
                result.add(assigment);
            }
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return result;
    }

    @Override
    public Assigment selectAssigment (int id) {
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = ("SELECT * FROM Assigment " +
                    "INNER JOIN Event E on E.IdE = Assigment.Fk_Event " +
                    "WHERE IdA = %d")
                    .formatted(id);
            ResultSet resultSet = statement.executeQuery(query);

            Event event = new Event(
                    resultSet.getString("Description"),
                    resultSet.getDate("StartDate").toString(),
                    resultSet.getDate("EndDate").toString()
            );
            event.setIdE(resultSet.getInt("IdE"));

            Assigment assigment = new Assigment(
                    event,
                    resultSet.getInt("IsComplete"),
                    resultSet.getInt("Fk_ProjectGroup")
            );
            assigment.setIdA(resultSet.getInt("IdA"));
            assigment.setFk_event(resultSet.getInt("Fk_Event"));
            assigment.setIdE(selectEvent(resultSet.getInt("Fk_Event")).getIdE());
            resultSet.close();
            return assigment;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateState(int id) {
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = ("UPDATE Assigment " +
                    "SET IsComplete = 1 " +
                    "WHERE IdA = %d")
                    .formatted(id);
            statement.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }
}
