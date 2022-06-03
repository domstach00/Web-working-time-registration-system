package com.example.webworkingtimeregistrationsystem.dao;

import com.example.webworkingtimeregistrationsystem.model.DayOff;

import java.util.Date;
import java.util.List;

public interface DayOffDao {
    boolean insertDayOff(DayOff dayOff);
    List<DayOff> selectDayOff();
    List<DayOff> selectDayOff(Date startDate, Date endDate);
    DayOff selectDayOff(int id);
}
