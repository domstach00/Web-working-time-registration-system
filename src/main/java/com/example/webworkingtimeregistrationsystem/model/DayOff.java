package com.example.webworkingtimeregistrationsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DayOff extends Event{
    private int idDO;
    private int fk_dayOffType;
    private int fk_event;
    private int fk_user;


    public DayOff(@JsonProperty("description") String description,
                  @JsonProperty("startDate") String startDate,
                  @JsonProperty("endDate") String endDate,
                  @JsonProperty("fk_dayOffType") int fk_dayOffType,
                  @JsonProperty("fk_user") int fk_user) {
        super(description, startDate, endDate);
        this.fk_dayOffType = fk_dayOffType;
        this.fk_user = fk_user;
    }

    public DayOff(Event event, int fk_dayOffType, int fk_user) {
        super(event.getDescription(), event.getStartDate(), event.getEndDate());
        this.fk_dayOffType = fk_dayOffType;
        this.fk_user = fk_user;
    }

    public int getIdDO() {
        return idDO;
    }

    public void setIdDO(int idDO) {
        this.idDO = idDO;
    }

    public int getFk_dayOffType() {
        return fk_dayOffType;
    }

    public void setFk_dayOffType(int fk_dayOffType) {
        this.fk_dayOffType = fk_dayOffType;
    }

    public int getFk_event() {
        return fk_event;
    }

    public void setFk_event(int fk_event) {
        this.fk_event = fk_event;
    }

    public int getFk_user() {
        return fk_user;
    }

    public void setFk_user(int fk_user) {
        this.fk_user = fk_user;
    }
}
