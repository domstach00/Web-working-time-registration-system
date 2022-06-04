package com.example.webworkingtimeregistrationsystem.service;

import com.example.webworkingtimeregistrationsystem.dao.DayOffTypeDao;
import com.example.webworkingtimeregistrationsystem.model.DayOffType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayOffTypeService {
    private final DayOffTypeDao dayOffTypeDao;

    @Autowired
    public DayOffTypeService(@Qualifier("DayOffTypeAccess") DayOffTypeDao dayOffTypeDao) {
        this.dayOffTypeDao = dayOffTypeDao;
    }

    public boolean insertDayOffType(DayOffType dayOffType) {
        return this.dayOffTypeDao.insertDayOffType(dayOffType);
    }

    public List<DayOffType> selectDayOffType() {
        return this.dayOffTypeDao.selectDayOffTypes();
    }

    public DayOffType selectDayOffType(int id) {
        return this.dayOffTypeDao.selectDayOffType(id);
    }
}
