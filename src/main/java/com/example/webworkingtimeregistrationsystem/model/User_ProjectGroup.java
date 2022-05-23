package com.example.webworkingtimeregistrationsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

public class User_ProjectGroup {
    @NotBlank
    private int idU;
    @NotBlank
    private int idPG;

    public User_ProjectGroup(@JsonProperty("idU") int idU,
                             @JsonProperty("idPG") int idPG) {
        this.idU = idU;
        this.idPG = idPG;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public int getIdPG() {
        return idPG;
    }

    public void setIdPG(int idPG) {
        this.idPG = idPG;
    }
}
