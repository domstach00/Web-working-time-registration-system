package com.example.webworkingtimeregistrationsystem.model;

import java.util.Date;

public class Event {
    private int idE;
    private String description;
    private Date startDate;
    private Date endDate;

    public String getDescription() {
        return description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setDateEnd(String str) {

    }


    public void setEndDate(Date date) {
        this.endDate = date;
    }
}