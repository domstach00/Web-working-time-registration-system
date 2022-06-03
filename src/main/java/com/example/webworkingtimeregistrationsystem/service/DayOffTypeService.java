package com.example.webworkingtimeregistrationsystem.service;

import com.example.webworkingtimeregistrationsystem.dao.DayOffTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DayOffTypeService {
    private final DayOffTypeDao dayOffTypeDao;

    @Autowired
    public DayOffTypeService(@Qualifier("DayOffTypeAccess") DayOffTypeDao dayOffTypeDao) {
        this.dayOffTypeDao = dayOffTypeDao;
    }

    // TODO: DayOffTypeService
}
