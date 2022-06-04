package com.example.webworkingtimeregistrationsystem.service;

import com.example.webworkingtimeregistrationsystem.dao.AssigmentDao;
import com.example.webworkingtimeregistrationsystem.model.Assigment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AssigmentService {
    private final AssigmentDao assigmentDao;

    @Autowired
    public AssigmentService(@Qualifier("AssigmentAccess") AssigmentDao assigmentDao) {
        this.assigmentDao = assigmentDao;
    }

    public boolean insertAssigment(Assigment assigment) {
        return assigmentDao.insertAssigment(assigment);
    }

    public List<Assigment> selectAssigments(){
        return assigmentDao.selectAssigments();
    }

    public List<Assigment> selectAssigments(Date startDate, Date endDate) {
        return assigmentDao.selectAssigments(startDate, endDate);
    }

    public Assigment selectAssigments(int id) {
        return this.assigmentDao.selectAssigment(id);
    }

    public boolean updateState(int id) {
        return this.assigmentDao.updateState(id);
    }
}
