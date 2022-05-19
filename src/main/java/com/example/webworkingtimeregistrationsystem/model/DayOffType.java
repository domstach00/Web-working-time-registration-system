package com.example.webworkingtimeregistrationsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class DayOffType {
    private int idDOT;
    @NotBlank
    private String dayOffTypeName;
    private String description;

    public DayOffType(@JsonProperty("dayOffTypeName") String dayOffTypeName,
                      @JsonProperty("description") String description) {
        this.dayOffTypeName = dayOffTypeName;
        this.description = description;
    }

    public int getIdDOT() {
        return idDOT;
    }

    public void setIdDOT(int idDOT) {
        this.idDOT = idDOT;
    }

    public String getDayOffTypeName() {
        return dayOffTypeName;
    }

    public void setDayOffTypeName(String dayOffTypeName) {
        this.dayOffTypeName = dayOffTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
