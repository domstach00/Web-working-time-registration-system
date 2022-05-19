package com.example.webworkingtimeregistrationsystem.dao;

import com.example.webworkingtimeregistrationsystem.model.DayOffType;

import java.util.List;

public interface DayOffTypeDao {
    boolean insertDayOffType(DayOffType dayOffType);
    List<DayOffType> selectDayOffTypes();
    DayOffType selectDayOffType(int id);
}
