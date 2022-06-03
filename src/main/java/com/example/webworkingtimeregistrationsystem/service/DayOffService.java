package com.example.webworkingtimeregistrationsystem.service;

import com.example.webworkingtimeregistrationsystem.dao.DayOffDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DayOffService {
    private final DayOffDao dayOffDao;

    @Autowired
    public DayOffService(@Qualifier("DayOffAccess") DayOffDao dayOffDao) {
        this.dayOffDao = dayOffDao;
    }

    // TODO: DayOffService
}
