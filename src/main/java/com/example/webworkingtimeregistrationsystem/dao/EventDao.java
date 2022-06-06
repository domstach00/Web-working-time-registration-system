package com.example.webworkingtimeregistrationsystem.dao;

import com.example.webworkingtimeregistrationsystem.model.Event;

import java.util.Date;
import java.util.List;

public interface EventDao {
    boolean insertEvent(Event event);
    List<Event> selectEvents();
    List<Event> selectEvents(Date startDate, Date endDate);
    Event selectEvent(int id);
    int idEvent(Event event);
    boolean deleteEvent(int id);
}
