package com.example.webworkingtimeregistrationsystem.service;

import com.example.webworkingtimeregistrationsystem.dao.EventDao;
import com.example.webworkingtimeregistrationsystem.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventService {
    private final EventDao eventDao;

    @Autowired
    public EventService(@Qualifier("EventAccess") EventDao eventDao){
        this.eventDao = eventDao;
    }

    public boolean insertEvent(Event event) {
        return eventDao.insertEvent(event);
    }

    public List<Event> selectEvents() {
        return eventDao.selectEvents();
    }

    public List<Event> selectEvents(Date startDate, Date endDate) {
        return eventDao.selectEvents(startDate, endDate);
    }

    public Event selectEvent(int id) {
        return this.eventDao.selectEvent(id);
    }
}
