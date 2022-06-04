package com.example.webworkingtimeregistrationsystem.service;

import com.example.webworkingtimeregistrationsystem.dao.DayOffDao;
import com.example.webworkingtimeregistrationsystem.model.DayOff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Service
public class DayOffService {
    private final DayOffDao dayOffDao;

    @Autowired
    public DayOffService(@Qualifier("DayOffAccess") DayOffDao dayOffDao) {
        this.dayOffDao = dayOffDao;
    }

    public boolean insertDayOff(DayOff dayOff) {
        return this.dayOffDao.insertDayOff(dayOff);
    }

    public List<DayOff> selectDayOff() {
        return this.dayOffDao.selectDayOff();
    }

    public List<DayOff> selectDayOff(Date startDate, Date endDate) {
        return this.dayOffDao.selectDayOff(startDate, endDate);
    }

    public DayOff selectDayOff(int id) {
        return this.dayOffDao.selectDayOff(id);
    }
}
