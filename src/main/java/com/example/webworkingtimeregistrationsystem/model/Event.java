package com.example.webworkingtimeregistrationsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {
    private int idE;
    private String description;
    @NotBlank
    private String startDate;
    @NotBlank
    private String endDate;

    public Event(@JsonProperty("description") String description,
                 @JsonProperty("startDate") String startDate,
                 @JsonProperty("endDate") String endDate) {
        this.description = description;
        this.startDate = startDate;
        if (endDate == null)
            endDate = startDate;
        this.endDate = endDate;
    }

    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    public String getDescription() {
        return description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public Date getDateFromString(String strDate) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strDate);

        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setDateEnd(String str) {

    }

    public void setEndDate(String date) {
        this.endDate = date;
    }
}