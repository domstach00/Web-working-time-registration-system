package com.example.webworkingtimeregistrationsystem.service;

import com.example.webworkingtimeregistrationsystem.dao.AssigmentDao;
import com.example.webworkingtimeregistrationsystem.model.Assigment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssigmentService {
    private final AssigmentDao assigmentDao;

    @Autowired
    public AssigmentService(@Qualifier("AssigmentAccess") AssigmentDao assigmentDao) {
        this.assigmentDao = assigmentDao;
    }

    public List<Assigment> selectAssigments(){
        return assigmentDao.selectAssigments();
    }
}
