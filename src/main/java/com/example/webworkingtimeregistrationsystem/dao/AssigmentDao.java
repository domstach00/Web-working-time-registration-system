package com.example.webworkingtimeregistrationsystem.dao;

import com.example.webworkingtimeregistrationsystem.model.Assigment;

import java.util.Date;
import java.util.List;

public interface AssigmentDao {
    boolean insertAssigment(Assigment assigment);
    List<Assigment> selectAssigments();
    List<Assigment> selectAssigments (Date startDate, Date endDate);
    Assigment selectAssigment (int id);
}
