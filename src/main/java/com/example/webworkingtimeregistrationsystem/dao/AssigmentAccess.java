package com.example.webworkingtimeregistrationsystem.dao;

import com.example.webworkingtimeregistrationsystem.model.Assigment;

import com.example.webworkingtimeregistrationsystem.datasource.DataSource;
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
            // TODO: Do query
            String query = "";
            statement.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Assigment> selectAssigments() {
        List<Assigment> resoult = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM Assigment";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Assigment newAssigment = new Assigment(
                        selectEvent(resultSet.getInt("Fk_Event")),
                        resultSet.getInt("IsComplete"),
                        resultSet.getInt("Fk_ProjectGroup")
                );
                newAssigment.setIdA(resultSet.getInt("IdA"));
                newAssigment.setFk_event(resultSet.getInt("Fk_Event"));
                newAssigment.setIdE(selectEvent(resultSet.getInt("Fk_Event")).getIdE());
                resoult.add(newAssigment);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return resoult;
    }

    @Override
    public List<Assigment> selectAssigments(Date startDate, Date endDate) {
        return null;
    }

    @Override
    public Assigment selectAssigment (int id) {
        return null;
    }
}
