package com.example.webworkingtimeregistrationsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Assigment extends Event {
    private int idA;
    private int isComplete;
    private int fk_projectGroup;
    private int fk_event;

    public Assigment(@JsonProperty("description") String description,
                     @JsonProperty("startDate") String startDate,
                     @JsonProperty("endDate") String endDate,
                     @JsonProperty("isComplete") int isComplete,
                     @JsonProperty(" ") int fk_projectGroup) {
        super(description, startDate, endDate);
        this.isComplete = isComplete;
        this.fk_event = super.getIdE();
        this.fk_projectGroup = fk_projectGroup;
    }

    public Assigment(Event event, int isComplete, int fk_projectGroup){
        super(event.getDescription(), event.getStartDate(), event.getEndDate());
        this.isComplete = isComplete;
        this.fk_projectGroup = fk_projectGroup;
    }

    public Event getEvetFromAssigment() {
        return new Event(
                getDescription(),
                getStartDate(),
                getEndDate()
        );
    }

    public int getIdA() {
        return idA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    public int getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(int isComplete) {
        this.isComplete = isComplete;
    }

    public int getFk_projectGroup() {
        return fk_projectGroup;
    }

    public void setFk_projectGroup(int fk_projectGroup) {
        this.fk_projectGroup = fk_projectGroup;
    }

    public int getFk_event() {
        return fk_event;
    }

    public void setFk_event(int fk_event) {
        this.fk_event = fk_event;
    }

}
